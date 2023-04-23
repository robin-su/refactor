package sjmszm.pattern.statemachine.statesingle;

import sjmszm.pattern.statemachine.state.State;

public interface IMario {

    State getName();
    //以下是定义的事件
    void obtainMushRoom(MarioStateMachine stateMachine);
    void obtainCape(MarioStateMachine stateMachine);
    void obtainFireFlower(MarioStateMachine stateMachine);
    void meetMonster(MarioStateMachine stateMachine);

}
