package questionbank;

import java.util.*;

public class L1178_猜字谜 {

    public static void main(String[] args) {
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        List<Integer> res = new L1178_猜字谜().findNumOfValidWords(words, puzzles);
        System.out.println(res);
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<String, Set<Character>> wordsMap = new HashMap<>();
        Map<String, Set<Character>> puzzlesMap = new HashMap<>();
        char[] firstChars = new char[puzzles.length];
        List<Integer> res = new ArrayList<>();
        int k = 0;
        for (String word : puzzles) {
            Set<Character> characterSet = new HashSet<>();
            firstChars[k++] = word.charAt(0);
            for (int i = 0; i < word.length(); i++) {
                characterSet.add(word.charAt(i));
            }
            puzzlesMap.put(word, characterSet);
        }

        for (String word : words) {
            Set<Character> characterSet = new HashSet<>();
            for (int i = 0; i < word.length(); i++) {
                characterSet.add(word.charAt(i));
            }
            wordsMap.put(word, characterSet);
        }

        for (int i = 0; i < puzzles.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (!wordsMap.get(words[j]).contains(firstChars[i])) {
                    continue;
                }
                if (!puzzlesMap.get(puzzles[i]).containsAll(wordsMap.get(words[j]))) {
                    continue;
                }
                count++;
            }
            res.add(count);
        }
        return res;
    }
}
