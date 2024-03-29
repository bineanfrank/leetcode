package questionbank;

import java.util.HashMap;
import java.util.Map;

public class L208_实现Trie前缀树 {

    public static void main(String[] args) {
        Trie trie = new L208_实现Trie前缀树().new Trie();
        trie.insert("apple");
        boolean res = trie.search("apple");
        System.out.println(res);
        res = trie.search("app");
        System.out.println(res);
        res = trie.startsWith("app");
        System.out.println(res);
    }

    class TrieNode {
        char c;
        int occurrence;
        Map<Character, TrieNode> children;

        TrieNode(char c) {
            this.c = c;
            occurrence = 0;
            children = null;
        }

        int insert(String s, int pos) {
            // 如果插入空串，则直接返回
            // 此方法调用时从pos=0开始的递归调用，pos指的是插入的第pos个字符
            if (s == null || pos >= s.length())
                return 0;

            // 如果当前节点没有孩子节点，则new一个
            if (children == null)
                children = new HashMap<Character, TrieNode>();

            // 创建一个TrieNode
            char c = s.charAt(pos);
            TrieNode n = children.get(c);

            // 确保字符保存在即将要插入的节点中
            if (n == null) {
                n = new TrieNode(c);
                children.put(c, n);
            }

            // 插入的结束时直到最后一个字符插入，返回的结果是该字符串出现的次数
            // 否则继续插入下一个字符
            if (pos == s.length() - 1) {
                n.occurrence++;
                return n.occurrence;
            } else {
                return n.insert(s, pos + 1);
            }
        }

        boolean remove(String s, int pos) {
            if (children == null || s == null)
                return false;

            // 取出第pos个字符，若不存在，则返回false
            char c = s.charAt(pos);
            TrieNode n = children.get(c);
            if (n == null)
                return false;

            // 递归出口是已经到了字符串的最后一个字符，occurrence=0，代表已经删除了
            // 否则继续递归到最后一个字符
            boolean ret;
            if (pos == s.length() - 1) {
                int before = n.occurrence;
                n.occurrence = 0;
                ret = before > 0;
            } else {
                ret = n.remove(s, pos + 1);
            }

            // 删除之后，必须删除不必要的字符
            // 比如保存的“Harlan”被删除了，那么如果n保存在叶子节点，意味着它虽然被标记着不存在了，但是还占着空间
            // 所以必须删除，但是如果“Harlan”删除了，但是Trie里面还保存这“Harlan1994”,那么不需要删除字符
            if (n.children == null && n.occurrence == 0) {
                children.remove(n.c);
                if (children.size() == 0)
                    children = null;
            }

            return ret;
        }

        TrieNode lookup(String s, int pos, boolean contains) {
            if (s == null)
                return null;

            // 如果找的次数已经超过了字符的长度，说明，已经递归到超过字符串的深度了，表明字符串不存在
            if (pos >= s.length() || children == null) {
                return null;
            }
            // 如果刚好到了字符串最后一个，则只需要返回最后一个字符对应的结点，若节点为空，则表明不存在该字符串
            else if (pos == s.length() - 1) {
                TrieNode node = children.get(s.charAt(pos));
                if (node == null) return null;
                if (contains) {
                    return node;
                } else {
                    return node.occurrence <= 0 ? null : node;
                }
            }

            // 否则继续递归查询下去，直到没有孩子节点了
            else {
                TrieNode n = children.get(s.charAt(pos));
                return n == null ? null : n.lookup(s, pos + 1, contains);
            }
        }
    }

    class Trie {

        private TrieNode root;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode((char) 0);
            size = 0;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || root == null)
                return;
            int times = root.insert(word, 0);
            if (times == 1) {
                // 如果插入后出现的次数为1，则是新字符串
                size++;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || root == null)
                return false;
            return root.lookup(word, 0, false) != null;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || root == null)
                return false;
            return root.lookup(prefix, 0, true) != null;
        }
    }
}
