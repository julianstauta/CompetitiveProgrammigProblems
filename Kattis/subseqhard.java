import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class subseqhard {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		int cases = Integer.parseInt(in.readLine());
		for (int i = 0; i < cases; i++) {
			in.readLine();
			int nNumbers = Integer.parseInt(in.readLine());
			StringTokenizer skt = new StringTokenizer(in.readLine());
			HashMap<Long, Integer> map = new HashMap<>();
			long[] nums = new long[nNumbers];
			long[] sum = new long[nNumbers];
			int count = 0;
			nums[0] = Long.parseLong(skt.nextToken());
			sum[0] = nums[0];
			map.put(0L, 1);
			map.put(sum[0], 1);
			if (sum[0] == 47) {
				count++;
			}
			for (int j = 1; j < nums.length; j++) {
				nums[j] = Long.parseLong(skt.nextToken());
				sum[j] = nums[j] + sum[j - 1];
				if (map.containsKey(sum[j])) {
					map.put(sum[j], map.get(sum[j])+1);
				} else {
					map.put(sum[j], 1);
				}
				long excess = sum[j] - 47;
				if (map.containsKey(excess)) {
					count += map.get(excess);
				}
			}
			out.write(count + "\n");
		}
		out.close();
	}

}
