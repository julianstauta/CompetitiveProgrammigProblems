import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class flexible {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer skt = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(skt.nextToken());
		int p = Integer.parseInt(skt.nextToken());
		skt = new StringTokenizer(in.readLine());
		int[] partitions = new int[p+2];
		for (int i = 1; i < p+1; i++) {
			partitions[i] = Integer.parseInt(skt.nextToken());
		}
		partitions[p+1] = w;
		HashMap<Integer, Integer> map= new HashMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < partitions.length; i++) {
			for (int j = i+1; j < partitions.length; j++) {
				int size = partitions[j] - partitions[i];
				if (!map.containsKey(size)){
					queue.add(size);
					map.put(size, size);
				}
			}
		}
		while (!queue.isEmpty()) {
			if (queue.size()==1){
				out.write(queue.poll()+"\n");
			} else{				
				out.write(queue.poll()+" ");
			}
		}
		out.close();
	}
}
