/**
 * BREAK A PALINDROME
 *
 * A palindrome reads the same from left or right, mom for example. There is a palindrome which must be modified, if possible.
 * Change exactly one character of the string to another character in the range ascii[a-z] so that the string meets
 * the following three conditions:
 *
 * - The new string is lower alphabetically than the initial string.
 * - The new String is the lowest value string alphabetically that can be created from the original palindrome after
 *   making only one change.
 * - The new string is not a palindrome.
 *
 * Return the new string, or, if it not possible to create a string meeting the criteria, return the string IMPOSSIBLE.
 *
 * EXAMPLE
 * palindromeStr = 'aaabbaaa'
 *
 * - Possible strings lower alphabetically than 'aaabbaaa' after one change are ['aaaabaaa', 'aaabaaaa']
 * 'aaaabaaa' is not a palindrome and is the lowest string that can be created from palindromeStr.
 *
 *
 * TEST RESULT
 * bab -> aab
 * aaa -> IMPOSSIBLE
 * acca -> aaca
 *
 *
 * 解题思路
 * 1. 判断是否为palindrome的算法 isPalindrome()
 * 2. 利用String hashcode compare()来查询最小string
 *
 */
public class BreakPalindrome {

    public static void main(String[] args) {
        String s1 = "bab";
        String s2 = "aaa";
        String s3 = "aaabbaaa";

        String f3 = "aaaabaaa";

        System.out.println(solve(s3));
    }

    private static boolean isPalindrome(final String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if(text.charAt(start) != text.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

    public static String solve(String text) {

        for (int i = 0; i < text.length()/2; i++) {
            StringBuilder sb = new StringBuilder(text);
            if (sb.charAt(i) != 'a') {
                sb.setCharAt(i, 'a');
                if (isPalindrome(sb.toString()))
                    continue;
                else
                    return sb.toString();
            }
        }
        return "IMPOSSIBLE";
    }

}
