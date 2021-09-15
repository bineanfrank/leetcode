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
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String target : dictionary) {
            String r = helper(s, target);
            if (r.length() == 0) {
                continue;
            }
            if (r.length() > res.length()) {
                res = r;
            } else if (r.length() == res.length()) {
                res = r.compareTo(res) < 0 ? r : res;
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
