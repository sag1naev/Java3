package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestsInvoker {

    public void invokeTests(Class c) throws InvocationTargetException, IllegalAccessException {
        // TODO: 18/11/2019
        Tests tests = new Tests();
        Method [] methods = c.getDeclaredMethods();
        for(Method method : methods){
            if (method.isAnnotationPresent(Before.class)){
                method.invoke(tests);
                break;
            }
        }
        ArrayList<Method> list = new ArrayList<>();
        for(Method method : methods){
            if (method.isAnnotationPresent(Test.class)){
                list.add(method);
            }
        }
        list.sort(Comparator.comparing(x->
                x.getAnnotation(Test.class)
                        .priority()));
        for(Method method : list){
            method.invoke(tests);
        }
        for(Method method : methods){
            if (method.isAnnotationPresent(After.class)){
                method.invoke(tests);
                break;
            }
        }

    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class clazz = Tests.class;
        new TestsInvoker().invokeTests(clazz);
    }
}
