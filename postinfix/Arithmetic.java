import java.util.Stack;

class Arithmetic {
	private String exp;
	private char postexp[] = new char[50];
	private double value = 0;

	public Arithmetic(String s) {
		exp = s;
	}

	public boolean isBalance() {
		Stack<Character> st = new Stack<Character>();
		char ch;
		for (int i = 0; i < exp.length(); i++) {
			ch = exp.charAt(i);
			if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				try {
					st.pop();
				} catch (Exception e) {
					return false;
				}
			}
		}
		if (!(st.empty())) {
			return false;
		} else {
			return true;
		}
	}

	public void postfixExpression() {
		int pi = -1;
		Stack<Character> sk = new Stack<Character>();
		char ch, ch2;
		for (int i = 0; i < exp.length(); i++) {
			ch2 = exp.charAt(i);
			if (ch2 >= '0' && ch2 <= '9') {
				postexp[++pi] = exp.charAt(i);
			} else if (ch2 == '+' || ch2 == '-' || ch2 == '*' || ch2 == '/' || ch2 == '%') {
				if (sk.empty()) {
					sk.push(ch2);
				} else {
					if (ch2 > sk.peek()) {
						sk.push(ch2);
					} else {
						if (!sk.empty()) {
							while ((ch = sk.pop()) != '(' && !sk.empty()) {
								postexp[++pi] = ch;
							}
						}
						sk.push(ch2);
					}
				}
			} else if (ch2 == '(' || ch2 == ')') {
				if (ch2 == '(') {
					sk.push(ch2);
				} else {
					if (!sk.empty()) {
						while ((ch = sk.pop()) != '(' && !sk.empty()) {
							if (ch != ')') {
								postexp[++pi] = ch;
							}
						}
					}
				}
			}
		}
		if (!sk.empty()) {
			postexp[++pi] = sk.pop();
		}
		postexp[++pi] = '\0';
	}

	String getPostfix() {
		return new String(postexp);
	}

	public void evaluateRPN() {
		Stack<Double> sc = new Stack<Double>();
		char ch;
		for (int i = 0; i < postexp.length; i++) {
			ch = postexp[i];
			if (ch >= '0' && ch <= '9') {
				//sc.push((double) exp.charAt(i));
				 sc.push((double)Character.getNumericValue(ch));
			}
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%') {
				double t1 = (double) (sc.pop());
				double t2 = (double) (sc.pop());
				switch (ch) {
				case '+':
					value = t2 + t1;
					break;
				case '-':
					value = t2 - t1;
					break;
				case '*':
					value = t2 * t1;
					break;
				case '%':
					value = t2 % t1;
					break;
				case '/':
					value = t2 / t1;
					break;
				}
				sc.push((double) value);
			}
		}
		value = sc.pop();
	}

	public double getResult() {
		return value;
	}
}