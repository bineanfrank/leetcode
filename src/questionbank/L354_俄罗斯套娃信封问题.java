package questionbank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L354_俄罗斯套娃信封问题 {

    public static void main(String[] args) {
//        int[][] envelopes = new int[][]{
//                {4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}, {1, 1}
//        };
        int[][] envelopes = new int[][]{
//                {4, 5}, {6, 7}, {2, 3}
                {46, 89}, {50, 53}, {52, 68}, {72, 45}, {77, 81}
        };
        int res = new L354_俄罗斯套娃信封问题().maxEnvelopes1(envelopes);
        System.out.println(res);
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) {
            return envelopes.length;
        }
        int max = 0;
        for (int i = 0; i < envelopes.length; i++) {
            boolean[] used = new boolean[envelopes.length];
            max = Math.max(max, dfs(0, i, envelopes, used));
        }
        return max + 1;
    }

    public int dfs(int depth, int cur, int[][] envelopes, boolean[] used) {
        if (depth == envelopes.length) return depth;
        int width = envelopes[cur][0];
        int height = envelopes[cur][1];
        if (width > envelopes[depth][0] && height > envelopes[depth][1] && !used[depth]) {
            used[depth] = false;
            return dfs(depth++, depth, envelopes, used);
        }
        return 1;
    }

    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length <= 1) return envelopes.length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            pairs.add(new Pair(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(pairs);
        Pair cur = pairs.get(0);
        int max = 0;
        for (int i = 1; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            if (cur.width < pair.width && cur.height < pair.height) {
                cur = pair;
                max++;
            }
        }
        return max + 1;
    }

    class Pair implements Comparable<Pair> {
        int width;
        int height;

        public Pair(int width, int height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.width > o.width && this.height > o.height) return 1;
            else if (this.width == o.width) return this.height - o.height;
            else if (this.height == o.height) return this.width - o.width;
            else if (this.width == o.width && this.height == o.height) return 0;
            return -1;
        }
    }
}
