/*
package refactoringtopatterns.build.singleton.rfc;

import java.io.BufferedReader;

public class Console {

    private static HitStayResponse hitStayResponse = new HitStayResponse();

    private Console() {
    }
    // 1.将静态方法搬移到Blackjack,把Singleton的功能搬移到一个保存并提供对象访问的入口类中，
    public static HitStayResponse obtainHitStayResponse(BufferedReader input) {
        hitStayResponse.readFrom(input);
        return hitStayResponse;
    }

    public static void setPlayerResponse(HitStayResponse newHitStayResponse) {
        hitStayResponse = newHitStayResponse;
    }


}
*/
