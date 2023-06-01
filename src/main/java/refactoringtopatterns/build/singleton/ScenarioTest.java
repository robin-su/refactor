package refactoringtopatterns.build.singleton;

import sjmszm.iocrfc.TestCase;

public class ScenarioTest extends TestCase {

    public void testDealerStandardsWhenPlayerBusts() {
        Console.setPlayerResponse(new TestAlwaysHitResponse());
        int[] deck = { 10, 9 , 7, 2, 6};
        Blackjack blackjack = new Blackjack();
        blackjack.play();
        assert "dealer wins".equals(blackjack.didDealerWin());
    }

    @Override
    public boolean doTest() {
        return false;
    }
}
