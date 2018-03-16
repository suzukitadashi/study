package study.javassist;

import java.lang.reflect.Method;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

public class Sample {

	public static void main(String[] args) throws Exception {
        new Sample().weave();
    }

    public void weave() throws Exception {

        ClassPool pool = new ClassPool();
        pool.appendClassPath(new LoaderClassPath(Thread.currentThread().getContextClassLoader()));

        CtClass parent = pool.get("study.javassist.Target");
        CtClass proxy = pool.makeClass("study.javassist.Target$$Proxy", parent);

        // 追加したいメソッド、配列型で定義する
        String methodContent = 
            "public int getArgsLength(Object[] args) {" +
            "    return args.length;" +
            "}";

        CtMethod ctMethod = CtMethod.make(methodContent, proxy);
        proxy.addMethod(ctMethod);

        Class<?> proxyClass = proxy.toClass();
        Target proxyInstance = (Target) proxyClass.newInstance();

        exec(proxyInstance, "neko"); // 引数1つ
        exec(proxyInstance, "neko", "nuko"); // 引数2つ
    }

    public void exec(Target proxy,  Object ...varargs) throws Exception {
        Method method = proxy.getClass().getMethod("getArgsLength", Object[].class);
        Object result = method.invoke(proxy, new Object[]{varargs});
        System.out.println("length = " + result);
    }

}
