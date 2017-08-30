import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SecretMessage {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cases = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < cases; i++) {
			
			char[] original = in.readLine().toCharArray();
			int L = original.length;
			int M = findSquare(L);
			String[][] chart = new String[M][M]; 
			int c = 0;
			for (int j = M-1; j >= 0; j--) {
				for (int k = 0; k < chart.length; k++) {
					if (c==L){
						break;
					}
					chart[k][j] = original[c]+"";
					c++;
				}
			}
			for (int j = 0; j < chart.length; j++) {
				for (int j2 = 0; j2 < chart.length; j2++) {
					if (chart[j][j2]!=null){
						out.write(chart[j][j2]);
					}
				}
			}
			out.write("\n");
		}
		out.close();
	}
	
	static int findSquare(int L){
		double root = Math.sqrt(L);
		if (root%1 != 0){
			root = Math.ceil(root);
		}
		return (int) root;
	}
	
}
