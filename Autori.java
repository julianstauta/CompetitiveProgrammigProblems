import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Autori {
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] prhrase = in.readLine().split("-");
		String acroim = "";
		for (int i = 0; i < prhrase.length; i++) {
			acroim += prhrase[i].charAt(0);
		}
		out.write(acroim);
		out.close();
	}
}
