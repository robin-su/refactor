package sjmszm.bird;

/**
 * 口只声明方法，不定义实现。也就是说，每个会下蛋的鸟都要实现一遍 layEgg() 方法，
 * 并且实现逻辑是一样的，这就会导致代码重复的问题。那这个问题又该如何解决呢？
 */
public interface EggLayable {
    void layEgg();
}
