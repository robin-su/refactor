package sjmszm.bired2;

//鸵鸟
public class Ostrich implements Tweetable, EggLayable {

    private EggLayAbility eggLayAbility = new EggLayAbility();
    private TweetAbility tweetAbility = new TweetAbility();

    @Override
    public void layEgg() {
        //...
        eggLayAbility.layEgg();
    }

    @Override
    public void tweet() {
        //...
        tweetAbility.tweet();
    }
}
