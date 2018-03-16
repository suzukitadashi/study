package study.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class TestJavassist {

	public static void main(String[] args) throws NotFoundException, CannotCompileException {
		a();
		ObjectA a = new ObjectA();
		a.m(17);
		System.out.println(a);
	}

	static void a() throws NotFoundException, CannotCompileException {
		ClassPool cp = ClassPool.getDefault();
		CtClass cc = cp.get("study.javassist.ObjectA");
		CtMethod method = cc.getDeclaredMethod("m");
		method.setBody("{ study.javassist.ObjectB b = new study.javassist.ObjectB(); x= 217 + f; System.out.println(b.xx);}");
		cc.toClass();
	}

}
