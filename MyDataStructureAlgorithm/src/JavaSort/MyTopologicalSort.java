package JavaSort;

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