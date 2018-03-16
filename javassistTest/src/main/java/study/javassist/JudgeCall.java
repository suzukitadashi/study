package study.javassist;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

public class JudgeCall {

	public static void main(String[] args) {
		try {
			new JudgeCall().execute();
		} catch (NotFoundException | CannotCompileException e) {
			e.printStackTrace();
		}
	}

	private void execute() throws NotFoundException, CannotCompileException {
		ClassPool cp = ClassPool.getDefault();
		CtClass cc = cp.get("study.javassist.Judge");
		CtMethod method = cc.getDeclaredMethod("judge");
		
		String newJudgeMethod = "{return true;}";
		method.setBody(newJudgeMethod);
		
		cc.toClass();

		System.out.println(Judge.judge(1));
		System.out.println(Judge.judge(2));
		System.out.println(Judge.judge(3));
		System.out.println(Judge.judge(4));
	
	}
	
	
}
