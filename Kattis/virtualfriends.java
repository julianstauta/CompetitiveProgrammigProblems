import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Vector;

public class virtualfriends {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			int nFriedships = Integer.parseInt(in.readLine());
			UnionFind uf = new UnionFind(2 * nFriedships);
			HashMap<String, Integer> users = new HashMap<>();
			int userindex = 0;
			for (int j = 0; j < nFriedships; j++) {
				String[] friendship = in.readLine().split(" ");
				if (users.containsKey(friendship[0]) && users.containsKey(friendship[1])) {
					uf.unionSet(users.get(friendship[0]), users.get(friendship[1]));
					out.write(uf.sizeOfSet(users.get(friendship[0])) + "\n");
				} else {
					if (!users.containsKey(friendship[0])) {
						users.put(friendship[0], userindex);
						userindex++;
					}
					if (!users.containsKey(friendship[1])) {
						users.put(friendship[1], userindex);
						userindex++;
					}
					uf.unionSet(users.get(friendship[0]), users.get(friendship[1]));
					out.write(uf.sizeOfSet(users.get(friendship[0])) + "\n");
				}
			}
		}
		out.close();
	}

	static class UnionFind {
		private Vector<Integer> p, rank, setSize;
		private int numSets;

		public UnionFind(int N) {
			p = new Vector<Integer>(N);
			rank = new Vector<Integer>(N);
			setSize = new Vector<Integer>(N);
			numSets = N;
			for (int i = 0; i < N; i++) {
				p.add(i);
				rank.add(0);
				setSize.add(1);
			}
		}

		public int findSet(int i) {
			if (p.get(i) == i)
				return i;
			else {
				int ret = findSet(p.get(i));
				p.set(i, ret);
				return ret;
			}
		}

		public Boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (!isSameSet(i, j)) {
				numSets--;
				int x = findSet(i), y = findSet(j);
				// rank is used to keep the tree short
				if (rank.get(x) > rank.get(y)) {
					p.set(y, x);
					setSize.set(x, setSize.get(x) + setSize.get(y));
				} else {
					p.set(x, y);
					setSize.set(y, setSize.get(y) + setSize.get(x));
					if (rank.get(x) == rank.get(y))
						rank.set(y, rank.get(y) + 1);
				}
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize.get(findSet(i));
		}
	}
}
