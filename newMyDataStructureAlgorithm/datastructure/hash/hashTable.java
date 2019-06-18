https://www.youtube.com/watch?v=Vi0hauJemxA

유튜브에 남 채널 영상을 다운 받아 올리면 중복되는 영상이라고 바로 에러 뜸.
그 순간 에러가 날 수 있는 이유는
해쉬 테이블
검색하고자 하는 키값을 입력받고, 해쉬 함수를 돌려 해쉬 코드를 배열의 인덱스로 환산해서 데이터를 접근하는 방식이다.
F(key) -> HashCode -> Index -> Value

해쉬 테이블 장점은 엄청 빠름.

import java.util.LinkedList;

class HashTable {
    class Node {
        String key;
        String value;
        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
        String value() {
            return value;
        }
        void value(String value) {
            this.value = value;
        }
    }
    LinkedList<Node> data[];
    HashTable(int size) {
        this.data = new LinkedList[size];
    }
    int getHashCode(String key) {
        int hashcode = 0;
        for (char c : key.toCharArray()) {
            hashcode += c;
        }
        return hashcode;
    }
    int convertToIndex(int hashcode) {
        return hashcode % data.length;
    }
    Node searchKey(LinkedList<Node> list, String key) {
        if(list == null) return null;
        for (Node node : list ) {
            if(node.key.equals(key)) {
                return node;
            }
        }
    }
    void put(String key, String value) {

    }
}
