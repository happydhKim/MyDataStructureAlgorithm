package JavaSort;

//위상 정렬(topological sorting)은 유향 그래프의 꼭짓점들(vertex)을 변의 방향을 거스르지 않도록 나열하는 것을 의미한다. 
//위상정렬을 가장 잘 설명해 줄 수 있는 예로 대학의 선수과목(prerequisite) 구조를 예로 들 수 있다. 
//만약 특정 수강과목에 선수과목이 있다면 그 선수 과목부터 수강해야 하므로, 특정 과목들을 수강해야 할 때 위상 정렬을 통해 올바른 수강 순서를 찾아낼 수 있다
// 이와 같이 선후 관계가 정의된 그래프 구조 상에서 선후 관계에 따라 정렬하기 위해 위상 정렬을 이용할 수 있다. 
//정렬의 순서는 유향 그래프의 구조에 따라 여러 개의 종류가 나올 수 있다. 위상 정렬이 성립하기 위해서는 반드시 그래프의 순환이 존재하지 않아야 한다.
//이 점에서 비순환 유향 그래프(directed acyclic graph) 이다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MyTopologicalSort {
	static int Ts, V, E, edgecount[];
	static String answer;
	static ArrayList<Integer> graph[];

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Ts = Integer.parseInt(st.nextToken());
		for (int T = 1; T <= Ts; T++) {
			answer = "";
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			graph = new ArrayList[V + 1];
			edgecount = new int[V + 1];
			for (int i = 1; i <= V; i++)
				graph[i] = new ArrayList<Integer>();
			// input
			for (int i = 1; i <= E; i++) {
				int s, e;
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
				edgecount[e]++;
			}
			// Sort 같은레벨일경우 오름차순으로 정렬한다.
			for (int i = 1; i <= V; i++)
				Collections.sort(graph[i]);
			// set start point
			ArrayList<Integer> root = new ArrayList<Integer>();
			for (int i = 1; i <= V; i++) {
				if (edgecount[i] == 0)
					root.add(i);
			}
			// call topological sort
			ArrayList<Integer> result = topologicalSort(root);
			// make output
			for (int vertax : result)
				answer += vertax + " ";
			// print screen
			System.out.println("#" + T + " " + answer);
		}
	}

	// 위상정렬
	static ArrayList<Integer> topologicalSort(ArrayList<Integer> root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		boolean visited[] = new boolean[V + 1];
		// set root
		for (int vertax : root)
			que.add(vertax);
		while (!que.isEmpty()) {
			int vertax = que.poll();
			result.add(vertax);
			if (!visited[vertax]) {
				visited[vertax] = true;
				for (int next : graph[vertax]) {
					edgecount[next]--; // 간선 차감
					if (edgecount[next] == 0) // 간선이 0인것은 다음 root 이므로 queue add
						que.add(next);
				}
			}
		}
		return result;
	}
}
/*
 * input example
 * 
 * 1
 * 
 * 5 6
 * 
 * 2 1
 * 
 * 2 3
 * 
 * 3 4
 * 
 * 3 1
 * 
 * 1 4
 * 
 * 5 4
 * 
 */