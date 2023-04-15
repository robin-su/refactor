package sjmszm.bired2;

//麻雀
public class Sparrow implements EggLayable, Flyable, Tweetable {

    private EggLayAbility eggLayAbility = new EggLayAbility();
    private TweetAbility tweetAbility = new TweetAbility();
    private FlyAbility flyAbility = new FlyAbility();

    @Override
    public void layEgg() {
        //...
        eggLayAbility.layEgg();
    }

    @Override
    public void fly() {
        //...
        flyAbility.fly();
    }

    @Override
    public void tweet() {
        //...
        tweetAbility.tweet();
    }
}
