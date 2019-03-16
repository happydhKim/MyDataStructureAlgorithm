//https://javaplant.tistory.com/14

private static class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    /**
     * Trie에 문자열 입력
     * @param word
     */
    public void insert(String word) {
        TrieNode current = root;
        for(char c : word.toCharArray()) {
            if(current.getChild(c) != null) {
                current = current.getChild(c);
            }
            else {
                current = current.putChild(c);
            }
        }
        current.setLeaf(true);
    }

    /**
     * 문자열 word까지 입력된 경우 리턴되는 모든 leaf 리턴
     * @param word
     * @return
     */
    public ArrayList<TrieNode> findLeafs(String word) {
        ArrayList<TrieNode> retList = new ArrayList<TrieNode>();

        TrieNode current = root;

        //입력된 word에 해당하는 마지막 TrieNode를 탐색
        for(char c : word.toCharArray()) {
            if(current.getChild(c)!=null) {
                current = current.getChild(c);
            }
            else {
                retList.clear();
                return retList;
            }
        }

        // 마지막 TrieNode가 leaf이면 추가
        if(current.isLeaf()) {
            retList.add(current);
        }

        // 현재 TrieNode에 연결된 자식노드들의 모든 leaf를 추가
        retList.addAll(current.getAllLeaf());
        return retList;
    }
}

private static class TrieNode {
    private char data;
    private boolean isLeaf;
    private HashMap<Character, TrieNode> children;

    public TrieNode(char c) {
        this.data = c;
        children = new HashMap<Character, TrieNode>();
        isLeaf = false;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 입력 c에 해당하는 TrieNode 생성 후 Child로 추가
     * @param c
     * @return
     */
    public TrieNode putChild(char c) {
        TrieNode temp = new TrieNode(c);
        getChildren().put(c, temp);
        return temp;
    }
    /**
     * 현재 노드의 자식노드 중 입력값 c에 해당하는 값 리턴
     * @param c
     * @return
     */
    public TrieNode getChild(char c) {
        return getChildren().get(c);
    }

    /**
     * 현재 노드와 연결된 모든 자식노드 중 leaf에 해당하는 노드 전부 리턴
     * @return
     */
    public ArrayList<TrieNode> getAllLeaf() {
        ArrayList<TrieNode> retList = new ArrayList<TrieNode>();
        for(TrieNode child : getChildren().values()) {
            if(child.isLeaf()) {
                retList.add(child);
            }
            retList.addAll(child.getAllLeaf());
        }
        return retList;
    }

}
