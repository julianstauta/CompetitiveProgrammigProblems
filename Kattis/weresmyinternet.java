import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class weresmyinternet {
	

	public static void main(String[] args) throws IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer skt = new StringTokenizer(in.readLine());
		int houses = Integer.parseInt(skt.nextToken());
		int conncetions = Integer.parseInt(skt.nextToken());
		UnionFind city = new UnionFind(houses);
		for (int i = 0; i < conncetions; i++) {
			skt = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(skt.nextToken())-1, b = Integer.parseInt(skt.nextToken())-1;
			city.unionSet(a, b);
		}
		boolean connected = true;
		for (int i = 0; i < houses; i++) {
			if (!city.isSameSet(0, i)) {
				out.write((i+1)+"\n");
				connected = false;
			}
		}
		if (connected) {
			out.write("Connected\n");
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
