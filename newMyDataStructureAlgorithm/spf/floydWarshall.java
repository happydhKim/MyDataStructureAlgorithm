public class MyFloydWarshall {
	private static int vertexNum;
	private static double adj[][];

	private static void floydWarshall() {
		for (int i = 0; i < vertexNum; i++)
			adj[i][i] = 0; // 자기 자신으로 가는 가중치는 0
		for (int k = 0; k < vertexNum; k++) {
			for (int i = 0; i < vertexNum; i++) {
				for (int j = 0; j < vertexNum; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
	}
}
