import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cd {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String linea = in.readLine();
		while (!linea.equals("0 0")) {
			StringTokenizer skt = new StringTokenizer(linea);
			int n = Integer.parseInt(skt.nextToken());
			int m = Integer.parseInt(skt.nextToken());
			HashMap<Integer, Integer> hash = new HashMap<>();
			for (int i = 0; i < n; i++) {
				String Num = in.readLine();
				hash.put(Integer.parseInt(Num), Integer.parseInt(Num));
			}
			int c = 0;
			for (int i = 0; i < m; i++) {
				String Num = in.readLine();
				if (hash.get(Integer.parseInt(Num))!=null){
					c++;
				}
			}
			out.write(c+"\n");
			linea = in.readLine();
		}
		out.close();
		in.close();
	}
	
}
