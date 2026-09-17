class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;
        char[] cArr = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "").toCharArray();
        if (cArr.length == 0 || cArr.length == 1) return true;
        int i = 0;
        int j = cArr.length - 1;
        while (i <= cArr.length / 2) {
            if (cArr[i] != cArr[j]) return false;
            i++;
            j--;
        }
    return true;
    }
}
