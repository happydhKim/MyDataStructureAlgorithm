
/**
 *http://arabiannight.tistory.com/entry/%EC%9E%90%EB%B0%94Java-%EC%9E%90%EB%B0%94-HashMap-%EC%9D%B4%EB%9E%80
 **/
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class hashMap {
	public static void main(String args[]) {
		// HashMap에 Data 넣기 (Key , Value) 형태
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("김태희", new Integer(90));
		map.put("전혜빈", new Integer(80));
		map.put("유인나", new Integer(100));
		map.put("아이유", new Integer(90));

		// HashMap에 포함된 Key 중에 "유인나"라는 키를 가질 경우 true 리턴 (없을 경우 false)
		if (map.containsKey("유인나")) {
			System.out.println("유인나 최고");
		}

		// HashMap에 포함된 Key , Value를 Set에 담고 iterator에 값을 Set 정보를 담아 준다.
		Set<Entry<String, Integer>> set = map.entrySet();
		Iterator<Entry<String, Integer>> it = set.iterator();

		// HashMap에 포함된 key, value 값을 호출 한다.
		while (it.hasNext()) {
			Map.Entry<String, Integer> e = (Map.Entry<String, Integer>) it.next();
			System.out.println("이름 : " + e.getKey() + ", 점수 : " + e.getValue());
		}

		// Map에서 저장된 Key들을 가져올 Set을 만든다.
		Set<String> set2 = map.keySet();
		System.out.println("참가자 명단 : " + set2);

		// Map에 저장된 value값들 Collection<Interger> 형태로 얻어 오고 iterator에 담는다.
		Iterator<Integer> it2;
		Collection<Integer> values = map.values();
		it2 = values.iterator();

		int total = 0;

		while (it2.hasNext()) {
			Integer i = (Integer) it2.next();
			total += i.intValue();
		}

		// 결과 출력
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float) total / set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
