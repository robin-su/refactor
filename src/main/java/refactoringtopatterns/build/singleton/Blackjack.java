package refactoringtopatterns.build.singleton;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Blackjack {

    private Player player;
    private Dealer dealer;

    public Blackjack() {
        player = new Player();
        dealer = new Dealer();
    }

    public void play() {
        deal();
        writeln(player.getHandAsString());
        writeln(dealer.getHandAsStringWithFirstCarDown());
        HitStayResponse hitStayResponse;
        do {
            write ("H) or S)tay: ");
            hitStayResponse = Console.obtainHitStayResponse(new BufferedReader(new InputStreamReader(System.in)));
            write(hitStayResponse.toString());
            if(hitStayResponse.shouldHit()) {
                dealCardTo(player.getHandAsString());
                writeln(player.getHandAsString());
            }
        } while (canPlayerHit(hitStayResponse));
    }

    public String didDealerWin() {
        return "dealer wins";
    }

    private void dealCardTo(String value) {
    }

    private void deal() {
    }

    private void writeln(String value) {
    }

    private void write(String value) {
    }

    private boolean canPlayerHit(HitStayResponse hitStayResponse) {
        return true;
    }


}
