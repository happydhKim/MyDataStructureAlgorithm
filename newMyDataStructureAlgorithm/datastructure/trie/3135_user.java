public class user {

	private TrieNode trieTree[];

	public class TrieNode {
		public char val;
		public TrieNode nodes[] = new TrieNode[26];
		public int cnt;
	}

	public void init() {
		trieTree = new TrieNode[26];
	}

	public void insert(int buffer_size, String buf) {
		int cnt = 0;
		TrieNode map[] = trieTree;
		while (cnt < buffer_size) {
			if (map[buf.charAt(cnt) - 'a'] != null) {
				map[buf.charAt(cnt) - 'a'].cnt++;
				map = map[buf.charAt(cnt++) - 'a'].nodes;
			} else {
				map[buf.charAt(cnt) - 'a'] = new TrieNode();
				map[buf.charAt(cnt) - 'a'].val = buf.charAt(cnt);
				map[buf.charAt(cnt) - 'a'].cnt = 1;
				map = map[buf.charAt(cnt++) - 'a'].nodes;
			}
		}
	}

	public int query(int buffer_size, String buf) {
		int cnt = 0;
		int result = 0;
		TrieNode map[] = trieTree;
		while (cnt < buffer_size) {
			if (map[buf.charAt(cnt) - 'a'] != null) {
				result = map[buf.charAt(cnt) - 'a'].cnt;
				map = map[buf.charAt(cnt++) - 'a'].nodes;
			} else {
				return 0;
			}
		}
		return result;
	}
}
