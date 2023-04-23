package sjmszm.pattern.statemachine.branch;

/**
 * 对于简单的状态机来说，分支逻辑这种实现方式是可以接受的。但是，对于复杂的状态机来说，这种实现方式极易漏写或者错写某个状态转移。除此之外，
 * 代码中充斥着大量的 if-else 或者 switch-case 分支判断逻辑，可读性和可维护性都很差。如果哪天修改了状态机中的某个状态转移，我们要在冗
 * 长的分支逻辑中找到对应的代码进行修改，很容易改错，引入 bug
 */
public class MarioStateMachine {

    private int score;
    private State currentState;

    public MarioStateMachine() {
        score = 0;
        this.currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        if(currentState.equals(State.SMALL)) {
            this.currentState = State.SUPPER;
            this.score += 100;
        }
    }

    public void obtainCape() {
        if(currentState.equals(State.SMALL) || currentState.equals(State.SUPPER)) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    public void obtainFireFlower() {
        if(currentState.equals(State.SMALL) || currentState.equals(State.SUPPER)) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    public void meetMonster() {
        if(currentState.equals(State.SUPPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }

        if(currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }

        if(currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
