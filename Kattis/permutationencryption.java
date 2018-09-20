import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class permutationencryption {
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = in.readLine();
		while (!line.equals("0")){
			StringTokenizer skt = new StringTokenizer(line);
			int n = Integer.parseInt(skt.nextToken());
			int[] perm = new int[n];
			for (int i = 0; i < perm.length; i++) {
				perm[i] = Integer.parseInt(skt.nextToken());
			}
			char[] phrase = in.readLine().toCharArray();
			String modified = "'";
			for (int i = 0; i < phrase.length; i+=n) {
				for (int j = 0; j < n; j++) {
					if (i+perm[j]-1>=phrase.length){
						modified += ' ';						
					} else{
						modified += phrase[i+perm[j]-1];						
					}
				}
			}
			modified += "'";
			out.write(modified+"\n");
			line = in.readLine();
		}
		out.close();
		in.close();
		
	}
}
