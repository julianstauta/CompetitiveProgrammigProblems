import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class closestsums {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = in.readLine();
		int c = 1;
		while (line != null) {
			int n = Integer.parseInt(line);
			out.write("Case " + c + ":\n");
			int[] nums = new int[n];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(in.readLine());
			}
			ArrayList<Integer> sums = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				for (int j = i+1; j < nums.length; j++) {
					sums.add(nums[i] + nums[j]);
				}
			}
			int m = Integer.parseInt(in.readLine());
			for (int i = 0; i < m; i++) {
				int closest = Integer.MAX_VALUE;
				int sum = 0;
				int num = Integer.parseInt(in.readLine());
				for (int j = 0; j < sums.size(); j++) {
					if (closest>Math.abs(sums.get(j)-num)) {
						sum = sums.get(j);
						closest = Math.abs(sums.get(j)-num);
					}
				}
				out.write("Closest sum to " + num + " is " + sum + ".\n");
			}
			line = in.readLine();
			c++;
		}
		out.close();

	}

}
