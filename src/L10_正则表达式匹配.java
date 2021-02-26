public class L10_正则表达式匹配 {

    public static void main(String[] args) {
//        boolean res = new L10_正则表达式匹配().isMatch("", "");
//        System.out.println(res);
        boolean res = new L10_正则表达式匹配().isMatch("aab", "c*a*b");
        System.out.println(res);
    }


    public boolean isMatch1(String s, String p) {
        if ("".equals(s) && "".equals(p)) return true;
        int[] starIndex = new int[p.length()];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                starIndex[k++] = i;
            }
        }
        if (k == 0) {
            if (s.length() != p.length()) return false;
            for (int i = 0; i < s.length(); i++) {
                if (!(s.charAt(i) == p.charAt(i) || p.charAt(i) == '.')) {
                    return false;
                }
            }
            return true;
        }
        if (starIndex[0] == 0) return false;

        int i = 0;
        int j = 0;
        while (j < p.length() || i < s.length()) {
            while (j < p.length() && i < s.length()
                    && p.charAt(j) != '*' && p.charAt(j) != '.'
                    && p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            }
            if (j < p.length() && p.charAt(j) == '.' && i < s.length()) {
                i++;
                j++;
            }
            if (j < p.length() && p.charAt(j) == '*') {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j);
                while (j < p.length() && p.charAt(j) == pc) {
                    j++;
                }
                while (i < s.length() && s.charAt(i) == sc) {
                    i++;
                }
                if (j < p.length() && i < s.length() && p.charAt(j) != s.charAt(i)) {
                    return false;
                }
            }
            j++;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        if ("".equals(s) && "".equals(p)) return true;
        int[] starIndex = new int[p.length()];
        int k = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                starIndex[k++] = i;
            }
        }
        if (k == 0) {
            if (s.length() != p.length()) return false;
            for (int i = 0; i < s.length(); i++) {
                if (!(s.charAt(i) == p.charAt(i) || p.charAt(i) == '.')) {
                    return false;
                }
            }
            return true;
        }
        if (starIndex[0] == 0) return false;

        int i = 0;
        int j = 0;
        while (j < p.length() || i < s.length()) {
            while (j < p.length() && p.charAt(j) != '*' && p.charAt(j) != '.') {
                j++;
            }
            if (j < p.length()) {
                if (p.charAt(j) == '.') {
                    int start = j - 1;
                    while (start-- >= 0) {
                        if (start < s.length() && s.charAt(start) != p.charAt(start)) {
                            return false;
                        }
                    }
                } else {
                    char c = p.charAt(j - 1);
                    while (i < s.length() && s.charAt(i) == c) {
                        i++;
                    }

                }
            }
        }
        return true;
    }
}
