
public class RPN {
	public static void main(String[] arg) {
		String s[] = {"(2+3)"};
		for (int i = 0; i < s.length; i++)
		{
		Arithmetic a = new Arithmetic(s[i]);
		if (a.isBalance())
		{
		System.out.println("Expression " + s[i] + " is balanced\n");
		a.postfixExpression();
		System.out.println("The post fixed expression is " + a.getPostfix());
		a.evaluateRPN();
		System.out.println("The result is : " + a.getResult() + "\n");
		}
		else
		{
		System.out.println("Expression " + s[i] + " is not balanced\n");
		}
		}
		}
		
}
