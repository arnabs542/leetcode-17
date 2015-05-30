/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
	public boolean isPalindrome(String s) {
		int length = s.length();
		int left = 0;
		int right = length - 1;

		if (length == 0 || length == 1) return true;

		while (left < right) {
			char leftC = s.charAt(left);
			while ((leftC < 'a' || leftC > 'z') && (leftC < 'A' || leftC > 'Z') && (leftC < '0' || leftC > '9') && left < right) {
				left ++;
				leftC = s.charAt(left);
			}

			if (leftC >= 'A' && leftC <= 'Z') {
				leftC = (char)(leftC - 'A' + 'a');
			}

			if (left < right) {
				char rightC = s.charAt(right);
				while ((rightC < 'a' || rightC > 'z') && (rightC < 'A' || rightC > 'Z') && (rightC < '0' || rightC > '9') && left < right) {
					right --;
					rightC = s.charAt(right);
				}

				if (rightC >= 'A' && rightC <= 'Z') {
					rightC = (char)(rightC - 'A' + 'a');
				}
				
				if (leftC != rightC) return false;
				else {
					left ++;
					right --;
				}
			}
		}
		
		return true;
	}

    public boolean isPalindrome_TimeLimitExceed(String s) {
    	String sNew;
    	int length = s.length();

        if (length == 0) return true;
        else {
        	sNew = getChars(s);
        	int sNewLength = sNew.length();

        	if (sNewLength == 0 || sNewLength == 1) {
        		return true;
        	}
        	else {
        		for (int i = 0; i <= (sNewLength / 2); i ++) {
        			if (sNew.charAt(i) != sNew.charAt(sNewLength - 1 - i)) {
        				return false;
        			}
        		}
        		return true;
        	}
        }
    }

    private String getChars (String s) {
    	String sNew = "";
    	int length = s.length();

    	for (int i = 0; i < length; i ++) {
    		char c = s.charAt(i);
    		if (c >= 'a' && c <= 'z') sNew += c;
    		if (c >= 'A' && c <= 'Z') sNew += (char)(c - 'A' + 'a');
    	}

    	return sNew;
    }
}