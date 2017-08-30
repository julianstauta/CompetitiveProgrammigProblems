import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Different {

	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		while (line!=null) {
			StringTokenizer skt = new StringTokenizer(line);
			out.write(Math.abs((Long.parseLong(skt.nextToken())-Long.parseLong(skt.nextToken())))+"\n");
			line = in.readLine();
		}
		out.close();
	}
}
