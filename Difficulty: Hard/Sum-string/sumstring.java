class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                if ((s1.length() > 1 && s1.charAt(0) == '0') || (s2.length() > 1 && s2.charAt(0) == '0')) {
                    continue;
                }

                if (isValidSequence(s1, s2, s.substring(j))) {
                    return true;
                }
            }
        }

        return false;
    }
    private boolean isValidSequence(String s1, String s2, String remaining) {
        if (remaining.length() == 0) return true;
        String sum = addStrings(s1, s2);
        if (!remaining.startsWith(sum)) return false;
        return isValidSequence(s2, sum, remaining.substring(sum.length()));
    }
    private String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int n2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = n1 + n2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}
