package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Component
public class DemoBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> targetClass = bean.getClass();
        while (targetClass != null) {
            Field[] fields = targetClass.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(AutowireLogger.class)) {
                    try {
                        ReflectionUtils.makeAccessible(field);
                        ReflectionUtils.setField(field, bean, processInjectionPoint(field.getType()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            targetClass = targetClass.getSuperclass();
        }
        return bean;
    }

    // 创建代理类，在具体方法执行前后输出一个日志
    protected <T> T processInjectionPoint(final Class<T> injectionType) {
        return ProxyUtil.newProxyInstance(injectionType, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("do before " + method.getName() + " | " + Thread.currentThread());
                try {
                    InjectDemo injectDemo = new InjectDemo();
                    return method.invoke(injectDemo, args);
                } finally {
                    System.out.println("do after " + method.getName() + " | " + Thread.currentThread());
                }
            }
        }, new ProxyUtil.CallbackFilter() {
            @Override
            public boolean accept(Method var1) {
                return true;
            }
        });
    }
}
