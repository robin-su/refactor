package sjmszm.pattern.observer.myeventbus;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObserverAction {
    private Object target;
    private Method method;

    /**
     * target 表示观察者类，method 表示方法
     * @param target
     * @param method
     */
    public ObserverAction(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    public void execute(Object event) { // event是method方法的参数
        try {
            method.invoke(target, event);
        }catch (InvocationTargetException |IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
