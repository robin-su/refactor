package martinfowler.chapter11_11;

import java.util.Vector;

class MyStack extends Vector {

    //自己的独有函数
    public void push(Object element) {
        insertElementAt(element,0);
    }

    //自己的独有函数
    public Object pop() {
        Object result = firstElement();
        removeElementAt(0);
        return result;
    }

    //从Vector集成来的
    @Override
    public int size() {
        return super.size();
    }

    //从Vector集成来的
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}
