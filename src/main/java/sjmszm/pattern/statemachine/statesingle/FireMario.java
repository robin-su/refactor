package sjmszm.pattern.statemachine.statesingle;

import sjmszm.pattern.statemachine.state.State;

public class FireMario implements IMario{

    private static final FireMario instance = new FireMario();
    private FireMario() {}
    public static FireMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {

    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {

    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {

    }
}
