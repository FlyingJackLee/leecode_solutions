package medium;

class TrieNode {
    TrieNode[] children;
    boolean isEnd =  false;

    TrieNode(){
        children = new TrieNode[26];
    }

    TrieNode getChild(char c){
        return children[c - 'a'];
    }

    void setChild(char c){
        children[c - 'a'] = children[c - 'a'] != null ? children[c - 'a'] : new TrieNode();
    }

    void setChild(char c, boolean isEnd){
        setChild(c);
        isEnd = isEnd;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public TrieNode[] getChildren() {
        return children;
    }
}

public class Trie {
    TrieNode root = new TrieNode();

    public Trie() {

    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node.setChild(word.charAt(i));
            node = node.getChild(word.charAt(i));
        }

        node.setEnd(true);
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private TrieNode searchPrefix(String prefix){
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (node.getChild(prefix.charAt(i))  == null) {
                return null;
            }
            node = node.getChild(prefix.charAt(i));
        }

        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}
