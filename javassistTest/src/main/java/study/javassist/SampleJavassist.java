package study.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class SampleJavassist {

	public static void main(String[] args) throws Exception {

		ClassPool cp = ClassPool.getDefault();
		CtClass cc = cp.get("study.javassist.HelloWorld");
		CtMethod m = cc.getDeclaredMethod("hello");
		m.insertBefore("System.out.println(\"helloメソッドの先頭で呼び出されるはずです。\");");
		cc.writeFile();

		Class clazz = cc.toClass();
		HelloWorld obj = (HelloWorld) clazz.newInstance();
		obj.hello();
	}
}
