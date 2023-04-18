package sjmszm.pattern.proxy.controllerrfc3;

import sjmszm.pattern.proxy.MetricsCollector;
import sjmszm.pattern.proxy.RequestInfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    public Object createProxy(Object proxiedObject) {
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(),interfaces,handler);
    }

    private class DynamicProxyHandler implements InvocationHandler {

        protected Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimeStamp = System.currentTimeMillis();
            Object result = method.invoke(proxiedObject, args);
            long endTimestamp = System.currentTimeMillis();
            long responseTime = endTimestamp - startTimeStamp;
            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();

            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimeStamp);
            metricsCollector.recordRequest(requestInfo);
            return result;
        }
    }
}
