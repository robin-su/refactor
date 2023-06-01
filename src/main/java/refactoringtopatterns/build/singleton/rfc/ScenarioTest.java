package refactoringtopatterns.build.singleton.rfc;

import sjmszm.iocrfc.TestCase;

public class ScenarioTest extends TestCase {

    public void testDealerStandardsWhenPlayerBusts() {
//        Console.setPlayerResponse(new TestAlwaysHitResponse());
        Blackjack blackjack = new Blackjack();
        blackjack.play();
        assert "dealer wins".equals(blackjack.didDealerWin());
    }
 
    @Override
    public boolean doTest() {
        return false;
    }
}
