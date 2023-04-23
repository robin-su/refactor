package sjmszm.pattern.statemachine.statesingle;

import sjmszm.pattern.statemachine.state.State;

public class SuperMario implements IMario{

    private static final SuperMario instance = new SuperMario();

    private SuperMario() {}

    public static final SuperMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SUPPER;
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
