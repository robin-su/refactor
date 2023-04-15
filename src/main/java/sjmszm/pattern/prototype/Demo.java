package sjmszm.pattern.prototype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 新需求：
 * 任何时刻，系统A中的所有数据都必须是同一个版本的，要么都是版本a，要么都是版本b，不能有的是版本a，有的是版本b。
 * 那刚刚的更新方式就不能满足这个要求了。除此之外，我们还要求：在更新内存数据的时候，系统A不能处于不可用状态，也就是
 * 不能停机更新数据。
 */
public class Demo {

    private HashMap<String,SearchWord>  currentKeywords = new HashMap<String, SearchWord>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // 从数据库中获取更新时间>lastUpdateTime的数据，放入到currentKeywords中。
        /*List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if(searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if(currentKeywords.containsKey(searchWord.getKeyword())) {
                currentKeywords.replace(searchWord.getKeyword(),searchWord);
            } else {
                currentKeywords.put(searchWord.getKeyword(),searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;*/

        //1.新需求的解决思路:
        /**
         * newKeywords 构建的成本比较高。我们需要将这 10 万条数据从数据库中读出，然后计算哈希值，
         * 构建 newKeywords。这个过程显然是比较耗时。为了提高效率，原型模式就派上用场了。
         *
         * 最耗时的还是从数据库中取数据的操作。相对于数据库的 IO 操作来说，内存操作和 CPU 计算的耗时都是可以忽略的。
         */
        /*ConcurrentHashMap<String, SearchWord> newKeywords = new ConcurrentHashMap<String, SearchWord>();
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            newKeywords.put(searchWord.getKeyword(),searchWord);
        }
        currentKeywords = newKeywords;*/

        // 原型模式就这么简单，拷贝已有对象的数据，更新少量差值
        /**
         * 这样实现的问题：
         * 1.我们通过调用 HashMap 上的 clone() 浅拷贝方法来实现原型模式。当我们通过 newKeywords 更新 SearchWord 对象的时候
         * （比如，更新“设计模式”这个搜索关键词的访问次数），newKeywords 和 currentKeywords 因为指向相同的一组 SearchWord
         * 对象，就会导致 currentKeywords 中指向的 SearchWord，有的是老版本的，有的是新版本的，就没法满足我们之前的需求：
         * currentKeywords 中的数据在任何时刻都是同一个版本的，不存在介于老版本与新版本之间的中间状态
         * 解决方案：
         * 2.我们可以将浅拷贝替换为深拷贝。newKeywords 不仅仅复制 currentKeywords 的索引，还把 SearchWord 对象也复制一份出来，这样 newKeywords
         * 和 currentKeywords 就指向不同的 SearchWord 对象，也就不存在更新 newKeywords 的数据会导致 currentKeywords 的数据也被更新的问题了。
         */
        HashMap<String, SearchWord> newKeywords =  (HashMap<String, SearchWord>)currentKeywords.clone();
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;

        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if(searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if(newKeywords.containsKey(searchWord.getKeyword())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(),searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    /** 第一种浅拷贝的方式：递归拷贝对象、对象的引用对象以及引用对象的引用对象……直到要拷贝的对象只包含基本数据类型数据，没有引用对象为止 */
    public void refresh1() {
        HashMap<String, SearchWord> newKeywords = new HashMap<String, SearchWord>();
        for (Map.Entry<String, SearchWord> e : currentKeywords.entrySet()) {
            SearchWord searchWord = e.getValue();
            SearchWord newSearchWord = new SearchWord(searchWord.getKeyword(),
                    searchWord.getCount(),
                    searchWord.getLastUpdateTime());

            newKeywords.put(e.getKey(),newSearchWord);
        }

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())) {
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeywords.put(searchWord.getKeyword(), searchWord);
            }
        }

        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    /**
     * 第二种方法：将对象序列化、反序列化成新的对象
     *
     * @param lastUpdateTime
     * @return
     */
    /*public Object deepCopy(Object object) {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(object);

        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);

        return oi.readObject();
    }
*/

    /**
     * 针对我们这个应用场景，有没有更快、更省内存的实现方式呢？
     * 我们可以先采用浅拷贝的方式创建 newKeywords。对于需要更新的 SearchWord 对象，我们再使用深度拷贝的方式创建一份新的对象，替换 newKeywords
     * 中的老对象。毕竟需要更新的数据是很少的。这种方式即利用了浅拷贝节省时间、空间的优点，又能保证 currentKeywords 中的中数据都是老版本的数据。
     * @param
     * @return
     */
    public void refresh2() {
        // Shallow copy
        HashMap<String,SearchWord> newKeywords = (HashMap<String,SearchWord>)currentKeywords.clone();
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);

        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if(searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if(newKeywords.containsKey(searchWord.getKeyword())) {
                newKeywords.remove(searchWord.getKeyword());
            }
            newKeywords.put(searchWord.getKeyword(),searchWord);
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;

    }


    public List<SearchWord> getSearchWords(long lastUpdateTime) {
        // TODO: 2023/4/15 从数据库中取出更新时间 > lastUpdateTime的数据
        return null;
    }

}
