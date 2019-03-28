import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Tree implements Comparable<Tree> {
	int x;
	int y;
	int age;
	String life;

	Tree(int x, int y, int age, String life) {
		this.x = x;
		this.y = y;
		this.age = age;
		this.life = life;
	}

	@Override
	public int compareTo(Tree t) {
		return this.age > t.age ? 1 : -1;
	}
}

public class 16235 {
	static final int X[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static final int Y[] = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int N, M, K, A[][], add[][], cnt, ans;
	static PriorityQueue<Tree> pq = new PriorityQueue<>();
	static Queue<Tree> q = new LinkedList<>();

	static void spring() {
		if (cnt == K) {
			while (!pq.isEmpty()) {
				Tree t = pq.remove();
				if (t.life == "Y") {
					ans++;
				}
			}
			return;
		}
		int size = pq.size();
		if (size == 0) {
			return;
		}
		for (int s = 0; s < size; s++) {
			Tree t = pq.remove();
			int x = t.x;
			int y = t.y;
			int age = t.age;
			System.out.println("cnt:"+cnt+"  "+"K:"+K+"     "+age + " " + t.life + "    ");
			if (age == 5) { //여기서 중복 발견 안됨.
				System.out.println(age + " " + t.life + "    " + cnt);
			}
			if (A[x][y] >= age) {
				A[x][y] -= age;
				pq.add(new Tree(x, y, age + 1, "Y"));
			} else {
				pq.add(new Tree(x, y, age, "N"));
			}
		}
		summer();
	}

	static void summer() {
		int size = pq.size();
		if (size == 0) {
			return;
		}
		for (int s = 0; s < size; s++) {
			Tree t = pq.remove();
			int x = t.x;
			int y = t.y;
			int age = t.age;
			if (age == 5) { //여기서 중복 발견됨. (죽어야 하는 5가 안죽고 다시 생겨남)
				System.out.println(age + " " + t.life + "    " + cnt);
			}
			String life = t.life;
			if (life == "N") {
				A[x][y] += age / 2;
			} else {
				q.add(new Tree(x, y, age, "Y"));
			}
		}
		fall();
	}

	static void fall() {
		int size = q.size();
		if (size == 0) {
			return;
		}
		for (int s = 0; s < size; s++) {
			Tree t = q.remove();
			int x = t.x;
			int y = t.y;
			int age = t.age;
			if (age % 5 == 0) {
				for (int k = 0; k < 8; k++) {
					int nx = x + X[k];
					int ny = y + Y[k];
					if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1) {
						continue;
					}
					pq.add(new Tree(nx, ny, 1, "Y"));
				}
			}

			pq.add(new Tree(x, y, age, "Y"));
		}
		winter();
	}

	static void winter() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				A[i][j] += add[i][j];
			}
		}
		cnt++;
		spring();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 땅 크기
		M = sc.nextInt(); // M 개의 나무
		K = sc.nextInt(); // K 년
		A = new int[N + 1][N + 1]; // 양분의 값
		add = new int[N + 1][N + 1];
		cnt = 0;
		ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				add[i][j] = sc.nextInt();
				A[i][j] = 5;
			}
		}
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int age = sc.nextInt();
			pq.add(new Tree(x, y, age, "Y"));
		}
		spring();
		System.out.println(ans);
		sc.close();
	}
}

아래 테스트케이스는 에러 발견 테스트케이스
5 2 3
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 3 2 3 2
2 1 3
3 2 3
