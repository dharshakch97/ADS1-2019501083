/**
 * @author Dharshak
 */
class Solution {
	/**
	 * Checks for parentheses matching using stacks
	 * @param str String input
	 */
	public static String isMatching(String str) {
		// fill you code Here
		// Create object for stack
		Stack stack = new Stack();
		for (int i = 0; i < str.length(); i++) {
			char s =  str.charAt(i);
			// If open parentheses, push into stack
			if (s == '(' || s == '[' || s == '{')
				stack.push(s);
			/* checks with head of stack and if hea value equals
			with open braces then pops the head value*/
			else if (stack.top != null && (((s == ']' && stack.getTop() == '[') ||
					(s == ')' && stack.getTop() == '(') || (s == '}' && stack.getTop() == '{'))))
						stack.pop();
			else {
				return "NO";
			}
			
		}
		// if stack top is null, return "YES" or else return "NO"
		if (stack.top == null)
			return "YES";
		else
			return "NO";
		}
	}

		// String[] bracket = new String[str.length()];
		// bracket = str.split("");

		// String[] stack = new String[str.length()];
		// int s = 0;
		// for (String i : bracket) {
		// 	if (i.equals("[") || i.equals("{") || i.equals("("))
		// 		stack[s++] = i;
		// 	else if (s > 0) {
		// 		String preBracket = stack[s - 1];
				
		// 		if (preBracket.equals("[") && i.equals("]"))
		// 			s--;
		// 		else if (preBracket.equals("(") && i.equals(")"))
		// 			s--;
		// 		else if (preBracket.equals("{") && i.equals("}"))
		// 			s--;
		// 	}
		// }
		// if (s == 0) 
		// 	return "YES";
		// else
		// 	return "NO";



