package martinfowler.chapter11_11rfc;

import java.util.Vector;

//3. 去掉继承关系
//class MyStack extends Vector {
class MyStack {
        //1.在子类中新建一个字段，使其引用超类的一个实例，并将它初始化为this
//    private Vector _vector = this;
    //4.重新初始化_vector
        private Vector _vector = new Vector();

    //2.修改委托关系
    public void push(Object element) {
//        insertElementAt(element,0);
        //2.1
        _vector.insertElementAt(element,0);
    }

    //自己的独有函数
    public Object pop() {
//        Object result = firstElement();
        //2.2
        Object result = _vector.firstElement();
        //2.3
        _vector.removeElementAt(0);
        return result;
    }

    //从Vector集成来的
    public int size() {
//        return super.size();
        //2.4
        return _vector.size();
    }

    //从Vector集成来的
    public boolean isEmpty() {
//        return super.isEmpty();
        //2.5
        return _vector.isEmpty();
    }
}
