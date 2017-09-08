

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class kastenlauf {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			int shops = Integer.parseInt(in.readLine());
			Graph city = new Graph(shops+2);
			for (int j = 0; j < shops+2; j++) {
				StringTokenizer skt = new StringTokenizer(in.readLine());
				city.addNode(j, Integer.parseInt(skt.nextToken()), Integer.parseInt(skt.nextToken()));
			}
			city.setEdges();
			out.write(city.isRutePossible()? "happy\n" : "sad\n");
		}
		out.close();
	}

	static class Graph {
		int[][] adjmatrix;
		node[] nodes;

		public Graph(int nNodes) {
			nodes = new node[nNodes];
			adjmatrix = new int[nNodes][nNodes];
		}

		public void addNode(int index, int x, int y) {
			nodes[index] = new node(index, x, y);
		}

		public void setEdges() {
			for (int i = 0; i < adjmatrix.length; i++) {
				for (int j = 0; j < adjmatrix.length; j++) {
					adjmatrix[i][j] = Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y);
				}
			}
		}

		public boolean isRutePossible() {
			boolean[] visited = new boolean[nodes.length];
			Queue<node> queue = new LinkedList<>();
			queue.add(nodes[0]);
			while (!visited[nodes.length - 1]&&!queue.isEmpty()) {
				node current = queue.poll();
				visited[current.index] = true;
				for (int i = 0; i < nodes.length; i++) {
					if (!visited[i] && adjmatrix[current.index][i] <= 1000) {
						queue.add(nodes[i]);
					}
				}
			}
			if (visited[nodes.length - 1]) {
				return true;
			}
			return false;
		}
	}

	static class node {
		int index;
		int x;
		int y;

		public node(int index, int x, int y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}
}
