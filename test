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
