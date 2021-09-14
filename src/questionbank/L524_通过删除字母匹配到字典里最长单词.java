package questionbank;

import java.util.Arrays;
import java.util.List;

public class L524_通过删除字母匹配到字典里最长单词 {

    public static void main(String[] args) {
        L524_通过删除字母匹配到字典里最长单词 solution = new L524_通过删除字母匹配到字典里最长单词();

        /**
         * "aewfafwafjlwajflwajflwafj"
         * ["apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"]
         *
         *
         * "wordgoodgoodgoodbestword"
         * ["word","good","best","good"]
         *
         */
        String longestWord = solution.findLongestWord("wordgoodgoodgoodbestword", Arrays.asList("word", "good", "best", "good"));
        System.out.println(longestWord);

        System.out.println("abc".compareTo("abe"));
        System.out.println("best".compareTo("good"));
        System.out.println("ale".compareTo(""));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String target : dictionary) {
            if (target.length() > s.length()) {
                continue;
            } else if (target.length() <= s.length()) {
                String r;
                if (target.length() == s.length()) {
                    r = target;
                } else {
                    r = helper(s, target);
                }
                if (r.length() == 0) {
                    continue;
                }

                int com = res.compareTo(r);
                if (com == 0) {
                    res = r.length() > res.length() ? r : res;
                } else if (com < 0) {
                    // no modify
                } else {

                }
            }
        }
        return res;
    }

    /**
     * target长度比s小
     *
     * @param s
     * @param target
     * @return
     */
    public String helper(String s, String target) {
        int indexS = 0;
        int indexT = 0;
        while (indexS < s.length() && indexT < target.length()) {
            char cs = s.charAt(indexS);
            char ts = target.charAt(indexT);
            if (cs == ts) {
                indexT++;
            }
            indexS++;
        }
        if (indexT == target.length()) {
            return target;
        }
        return "";
    }
}
