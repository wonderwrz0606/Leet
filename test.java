// longestPalindrome
abcdefg1234567 = 14
abc defg 123 4567
abc gfed 321 4567
abc 123gfed 4567
l   lm      rm r

public class Solution {
private int lo, maxLen;

public String longestPalindrome(String s) {
	int len = s.length();
	if (len < 2)
		return s;

    for (int i = 0; i < len-1; i++) {
     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
     	extendPalindrome(s, i, i+1); //assume even length.
    }
    return s.substring(lo, lo + maxLen);
}

private void extendPalindrome(String s, int j, int k) {
	while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
		j--;
		k++;
	}
	if (maxLen < k - j - 1) {
		lo = j + 1;
		maxLen = k - j - 1;
	}
}}

i : 0 -> 1
abc

0, 0: a
0, 1: ab
1,1:
1,2:


// General Method: Find and replace
// String: Find first occurance and replace(This one can has a assumption is if there is only one pattern, then we can find and replace together from length to 0)
// String: For find all and replace
// This is for finding
for (int f = 0; f < array.length; f++) {
  // abcccd
  // f 0 1 2
  if (array[f] == pattern[0]) {
    int slow = f; // 2
    for (int i = f; i < f + pattern.length; f++){
      if array[i] != replace[i-f] break;
    }

    // after loop, f goes to 5
    if (f - slow == replacement.length) { // Check if f-slow == whole replacement
      set.add(start);
    }
  }
}

// This is for replacing
int j = 0;
while (j < array.length) {
  if (set.contains(j)) {
    sb.append(pattern);
    f += pattern.length;
  } else {
    sb.append(array[f]);
  }
}
sb.toString();

// Find all anagram in String
// Using HashMap<Character, Integer> leftCharacters;
// Using int zero to keep the number of zero in the map;
// Init the map with pattern.length;
// Calculate the zero at that moment;
// case 1: before slow++, map(array[slow]++); // This means we need one more char array[slow] and update #zero if map[array[slow]] == 1 zero--, else if (map[array[slow]]) == 0 zero++
// Case 2: after fast++, map(array[fast]--); // This means we add one more array[fast] to the map and update #zero

// Using a HashMap to store all the
public int findAllAnagrams(String s, String pattern) {
	// Base case
		if (s == null || s.length() == 0 || pattern.length() > s.length()) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap();
		int zero = 0;
		char[] array = s.toCharArray();
		char[] patternArray = pattern.toCharArray();
		// First store all the chars from pattern into the map
		for (char c : patternArray) {
			if (map.containsKey(c)) {
				int count = map.get(c);
				map.put(c, count+1);
			} else {
				map.put(c, 1);
			}
		}

		int result = 0;
		int slow = 0;
		// Go through the sArray to see if any anagram found
		for (int i = 0; i < array.length; i++) {
			if (i < pattern.length()) {
				if (map.containsKey(array[i])) {
					int count = map.get(array[i]);
					map.put(array[i], count-1);
				} else {
					// Ignore all the chars which is not from pattern
				}
			} else {
				 slow = i-pattern.length();
				// Check the first out char
				if (map.containsKey(array[slow])) {
					int count = map.get(array[slow]);
					if (count == 0) {
						zero--;
						map.put(array[slow], count+1);
						if (count + 1 == 0) {
							zero++;
						}
					}
				}
				// Check the adding new char
				if (map.containsKey(array[i])) {
					int count = map.get(array[i]);
					if (count == 0) {
						zero--;
						map.put(array[slow], count-1);
						if (count - 1 == 0) {
							zero++;
						}
					}
				}
				if (zero == pattern.length()) {
					result++;
				}
			}
		}
		return result;
}

// String Compress
// O(n)
class Solution {
    public int compress(char[] chars) {
        // Base case
        if (chars == null || chars.length == 0) {
						return 0;
        }
        int slow = 0;
        int fast = 1;
        for (; fast < chars.length; fast++) {
            if (chars[slow] != chars[fast]) {
                // Check if fast - slow == 1, this means only one char and dont need to do anything
								int count = fast - slow;
                if (count > 1) {
                    char[] countArray = String.valueOf(count).toCharArray();
                    for (int i = 0; i < countArray.length; i++) {
                        chars[slow+1] = countArray[i];
                        slow++;
                    }
										chars[slow+1] = chars[fast];
										slow++;
                }
            }
        }
        return slow+1;
    }
}

// Lincence format
// O(n)
// a-b-c-d-e-2-J => k = 4, abc-de2J
// Using math
// First count how many un-dash chars in the origin string s
// find the group number using s.length()/k, if s.length()%k == 0, even divided, other wise the fir group length == s.length()%k
// Using StringBuilder or inplace to generate the new String

// PalindromeII
// O(n + m)
// Requirement: Delete at most one char to see if it is Polidrome
// abcba yes, abcdba delete 'd' yes, abcddbc no
// Using two pointer to solve this problem, similar to reverse String/ Polidrome
// i = 0, j = array.length-1
// while i < j, array[i] == array[j], i++ , j--;
// when array[i] != array[j], do two paralevel checking ,one for i--,j, another is i, j--, Since we dont know which word can be deleted
// Check if either i--,j or i, j-- works, otherwise return false

// Path SumIII
// O(lgn4)
// Using DFS Backtracking to solve the problem
// For each of the node, add current.val first dfs(value+current.val), then dont change the value and directly pass to the next dfs(value);
// There for for each of the node,will will call 4 times left*2, right*2

// K-diff pairs in an Array
// O(n)
// Using HashMap<Integer, Count> to keep all the origin data
// Using another HashMap<i+j, i,j> to keep the result
// For loop the list, if array[i]+target existd in the map, check if this pair is in the result, add if new, remove if duplicate happens


// // Iterative
// public class Solution {
// public ListNode reverse(ListNode head) {
// 	If (head == null) { // If head == null, just return
// 		return null;
// }
// If (head.next == null) { // If head.next == null, just return the head
// 	return head;
// }
// ListNode pre = null;
// ListNode curr = head;
// ListNode next = null;
// while (curr.next != null) {  -4
//  next = curr.next;
// 	pre = curr;
// 	curr = next;
// 	next = curr.next;
// }
// return curr;
// }
// }

// Recursion
public class Solution {
	public ListNode revertList (ListNode root) {
		if (root == null || root.next == null) {
			return root;
		}
		ListNode newHead = this.revertlist(root.next);
		root.next.next = root;
		root.next = null;
		return newHead;
	}
}
