package questionbank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L187_重复的DNA序列 {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String cur = s.substring(i, i + 10);
            int times = map.getOrDefault(cur, 0);
            if (times == 1) ans.add(cur);
            map.put(cur, times + 1);
        }
        return ans;
    }
}
