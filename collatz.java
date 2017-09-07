import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class collatz {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = in.readLine();
		while (!line.equals("0 0")){
			StringTokenizer skt = new StringTokenizer(line);
			HashMap<Long, Integer> map = new HashMap<>();
			long n = Long.parseLong(skt.nextToken());
			long m = Long.parseLong(skt.nextToken());
			cllaz(n, map);
			long[] nums = cllaz(m, map);
			long sa = nums[1];
			long sb = nums[2];
			long c = nums[0];
			out.write(n+" needs "+sa+" steps, "+m+" needs "+sb+" steps, they meet at "+c+"\n");
			line = in.readLine();
		}
		out.close();
	}
	static long[] cllaz (long n, HashMap<Long, Integer> map){
		int c = 0;
		long nums [] = new long[3];
		boolean cond = true;
		while (cond){
			if (!map.containsKey(n)){
				map.put(n, c);				
			} else{
				nums[0] = n;
				nums[1] = map.get(n);
				nums[2] = c;
				return nums;
			}
			if (n==1){
				cond = false;
			}
			if (n%2==0){
				n = n/2;
			} else{
				n = 3*n+1;
			}
			c ++;
		}
		return nums;
	}
}
