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

public class pq {
	static final int X[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static final int Y[] = { -1, 1, 0, 0, -1, 1, 1, -1 };
	static int N, M, K, A[][], add[][], cnt, ans;
	static PriorityQueue<Tree> pq = new PriorityQueue<>();

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = new int[N + 1][N + 1];
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
		System.out.println(ans);
		sc.close();
	}
}
