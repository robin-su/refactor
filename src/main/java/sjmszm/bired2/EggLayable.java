package sjmszm.bired2;

/**
 * 口只声明方法，不定义实现。也就是说，每个会下蛋的鸟都要实现一遍 layEgg() 方法，
 * 并且实现逻辑是一样的，这就会导致代码重复的问题。那这个问题又该如何解决呢？
 *
 * 我们可以针对三个接口再定义三个实现类，它们分别是：
 * 1. 现了fly()方法的FlyAbility类、
 * 2. 实现了tweet()方法的TweetAbility类、
 * 3. 实现了layEgg()方法的EggLayAbility 类。
 */
public interface EggLayable {
    void layEgg();
}
