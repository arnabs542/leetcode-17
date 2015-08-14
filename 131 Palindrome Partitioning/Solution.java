/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
  */

/*
NOTE when thinking:
We can use recursion to solve this problem.

We should think in this way when we meet this problem:
Given "aab", can we get the answer if we already knew the answer to "aa".

If we knew the anwser when it goes to "aa", we can find the anwser to "aab" 
by considering all the possible solutions that adding the "b" at the last partition 
still statisfies the requirement.

If so, we can use recursion method to solve this problem.

*** This solution works. However you will get time limite exceeding error!!! ***
*/

//Use DFS method to solve this problem
//Reference: http://fisherlei.blogspot.ca/2013/03/leetcode-palindrome-partitioning.html
//Reference: http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/

public class Solution {
	//DFS
	public List<List<String>> partition(String s) {
		List<List<String>> r = new ArrayList<List<String>>();
		List<String> p = new ArrayList<String>();
		getPartition(s, 0, r, p);

		return r;
	}

	private void getPartition (String s, int start, List<List<String>> r, List<String> p) {
		int length = s.length();

		if (start == length) {
			ArrayList<String> pTemp = new ArrayList<String>(p);
			r.add(pTemp);
			return;
		}

		for (int i = start + 1; i <= length; i ++) {
			String sTemp = s.substring(start, i);

			if (isPalindrome(sTemp)) {
				p.add(sTemp);
				getPartition(s, i, r, p);
				p.remove(p.size() - 1);
			}
		}
	}


	private boolean isPalindrome (String s) {
    	int length = s.length();

    	if (length == 0) {
    		return false;
    	}

    	if (length == 1) {
    		return true;
    	}

    	int left = 0;
    	int right = length - 1;

    	while (left < right) {
    		if (s.charAt(left) != s.charAt(right)) {
    			return false;
    		}
    		left ++;
    		right --;
    	}

    	return true;
    }

	/*
	private Set<List<String>> set = new HashSet<List<String>>();

    public List<List<String>> partition(String s) {
    	set.clear();
    	List<List<String>> r = new ArrayList<List<String>>();
        partitionRecursion(r, s);

        return r;
    }

    private void partitionRecursion (List<List<String>> r, String s) {
    	int length = s.length();

    	//s only contains one character
    	if (length == 1) {
    		List<String> subR = new ArrayList<String>();

    		subR.add(s);
    		r.add(subR);
    		set.add(subR);
    	}
    	//s contains more than 1 charaters
    	else {
    		String sCur = s.substring(s.length() - 1, s.length());
    		String sTemp = s.substring(0, s.length() - 1);
    		partitionRecursion(r, sTemp);
    		List<List<String>> rExtra = new ArrayList<List<String>>();

    		for (List<String> subRTemp: r) {
    			findPartition(rExtra, subRTemp, sCur);
    		}

    		if (sTemp.length() > 1 && isPalindrome(sTemp)) {
    			List<String> subRTemp = new ArrayList<String>();
    			subRTemp.add(sTemp);
    			subRTemp.add(sCur);
    			r.add(subRTemp);
    			set.add(subRTemp);
    		}

    		r.addAll(rExtra);
    	}
    }

    //find the solution to add string s to the original solutions
    //e.g., given solution for "aa", find soluiton for "aab"
    private void findPartition (List<List<String>> result, List<String> subResult, String s) {
    	int size = subResult.size();

    	for (int i = (size - 1); i > 0; i --) {
    		String sTemp = "";
    		for (int j = i; j < size; j ++) {
    			sTemp += subResult.get(j);
    		}
    		sTemp += s;
    		if (isPalindrome(sTemp)) {
    			List<String> subResultTemp = new ArrayList<String>();
    			for (int k = 0; k < i; k ++) {
    				subResultTemp.add(subResult.get(k));
    			}
    			subResultTemp.add(sTemp);
    			if (!set.contains(subResultTemp)) {
    				result.add(subResultTemp);
    				set.add(subResultTemp);
    			}
    		}
    	}

    	subResult.add(s);
    }

    private boolean isPalindrome (String s) {
    	int length = s.length();

    	if (length == 0) {
    		return false;
    	}

    	if (length == 1) {
    		return true;
    	}

    	int left = 0;
    	int right = length - 1;

    	while (left < right) {
    		if (s.charAt(left) != s.charAt(right)) {
    			return false;
    		}
    		left ++;
    		right --;
    	}

    	return true;
    }
    */


	/*
	Set<List<String>> set = new HashSet<List<String>>();

    public List<List<String>> partition(String s) {
    	set.clear();
        return partitionRecursion(s);
    }

    private List<List<String>> partitionRecursion (String s) {
    	int length = s.length();

    	//s only contains one character
    	if (length == 1) {
    		List<List<String>> r = new ArrayList<List<String>>();
    		List<String> subR = new ArrayList<String>();

    		subR.add(s);
    		r.add(subR);
    		set.add(subR);

    		return r;
    	}
    	//s contains more than 1 charaters
    	else {
    		String sCur = s.substring(s.length() - 1, s.length());
    		String sTemp = s.substring(0, s.length() - 1);
    		List<List<String>> r = partitionRecursion(sTemp);
    		List<List<String>> rExtra = new ArrayList<List<String>>();

    		for (List<String> subRTemp: r) {
    			findPartition(rExtra, subRTemp, sCur);
    		}

    		if (sTemp.length() > 1 && isPalindrome(sTemp)) {
    			List<String> subRTemp = new ArrayList<String>();
    			subRTemp.add(sTemp);
    			subRTemp.add(sCur);
    			r.add(subRTemp);
    			set.add(subRTemp);
    		}

    		r.addAll(rExtra);

    		return r;
    	}
    }

    //find the solution to add string s to the original solutions
    //e.g., given solution for "aa", find soluiton for "aab"
    private void findPartition (List<List<String>> result, List<String> subResult, String s) {
    	int size = subResult.size();

    	for (int i = (size - 1); i > 0; i --) {
    		String sTemp = "";
    		for (int j = i; j < size; j ++) {
    			sTemp += subResult.get(j);
    		}
    		sTemp += s;
    		if (isPalindrome(sTemp)) {
    			List<String> subResultTemp = new ArrayList<String>();
    			for (int k = 0; k < i; k ++) {
    				subResultTemp.add(subResult.get(k));
    			}
    			subResultTemp.add(sTemp);
    			if (!set.contains(subResultTemp)) {
    				result.add(subResultTemp);
    				set.add(subResultTemp);
    			}
    		}
    	}

    	subResult.add(s);
    }

    private boolean isPalindrome (String s) {
    	int length = s.length();

    	if (length == 0) {
    		return false;
    	}

    	if (length == 1) {
    		return true;
    	}

    	int left = 0;
    	int right = length - 1;

    	while (left < right) {
    		if (s.charAt(left) != s.charAt(right)) {
    			return false;
    		}
    		left ++;
    		right --;
    	}

    	return true;
    }*/
}