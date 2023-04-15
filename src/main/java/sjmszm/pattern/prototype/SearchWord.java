package sjmszm.pattern.prototype;

public class SearchWord {

    private long lastUpdateTime;
    private String keyword;
    private Long count;

    public SearchWord(String keyword,long lastUpdateTime,  Long count) {
        this.lastUpdateTime = lastUpdateTime;
        this.keyword = keyword;
        this.count = count;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
