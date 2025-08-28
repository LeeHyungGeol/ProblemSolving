class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }

        s = sb.toString();
        int left = 0, right = s.length()-1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }
}