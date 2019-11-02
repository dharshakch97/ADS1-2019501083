class Solution{

	public static String isMatching(String str) {
		// fill you code Here
		String[] bracket = new String[str.length()];
		bracket = str.split("");

		String[] stack = new String[str.length()];
		int s = 0;
		for (String i : bracket) {
			if (i.equals("[") || i.equals("{") || i.equals("("))
				stack[s++] = i;
			else if (s > 0) {
				String preBracket = stack[s - 1];
				
				if (preBracket.equals("[") && i.equals("]"))
					s--;
				else if (preBracket.equals("(") && i.equals(")"))
					s--;
				else if (preBracket.equals("{") && i.equals("}"))
					s--;
			}
		}
		if (s == 0) 
			return "YES";
		else
			return "NO";
	}

}
