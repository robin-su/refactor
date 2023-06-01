package refactoringtopatterns.build.singleton.rfc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1.旧的不变 --> Console类不变
 * 2.新的创建 --> 将Console中的方法签名copy到调用端Blackjack，然后在新方法中调用旧的对象方法
 * 3.一部切换，旧的再见 --> 将Console中的方法体copy过来，然后将Console删除【再见】
 *
 */
public class Blackjack {

    private Player player;
    private Dealer dealer;
    //5.copy 变量，并去掉static
    private HitStayResponse hitStayResponse = new HitStayResponse();

    public Blackjack() {
        player = new Player();
        dealer = new Dealer();
    }

    // 2.取消static关键字
    public HitStayResponse obtainHitStayResponse(BufferedReader input) {
        // 4.copy 旧方法中的方法体
        hitStayResponse.readFrom(input);
        return hitStayResponse;
    }

    public void setPlayerResponse(HitStayResponse newHitStayResponse) {
        // 4.copy 旧方法中的方法体
        hitStayResponse = newHitStayResponse;
    }

    public void play() {
        deal();
        writeln(player.getHandAsString());
        writeln(dealer.getHandAsStringWithFirstCarDown());
        HitStayResponse hitStayResponse;
        do {
            write ("H) or S)tay: ");
            //3.修改引用点为this
//            hitStayResponse = Console.obtainHitStayResponse(new BufferedReader(new InputStreamReader(System.in)));
            hitStayResponse = this.obtainHitStayResponse(new BufferedReader(new InputStreamReader(System.in)));
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
