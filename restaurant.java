import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class restaurant {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		while (!line.equals("0")) {
			int instructions = Integer.parseInt(line);
			int st1 = 0;
			int st2 = 0;
			int filling = 2;
			for (int i = 0; i < instructions; i++) {
				StringTokenizer skt = new StringTokenizer(in.readLine());
				switch (skt.nextToken()) {
				case "DROP":
					int nDrop = Integer.parseInt(skt.nextToken());
					st2 += nDrop;
					out.write("DROP " + filling + " " + nDrop +"\n");
					break;
				case "TAKE":
					int ntake = Integer.parseInt(skt.nextToken());
					if (filling == 2) {
						int diference = st1-ntake;
						if (diference>=0) {
							out.write("TAKE "+ "1 " + ntake+"\n");
							st1-=ntake;
						} else if (diference < 0){
							if (st1 != 0) {								
								out.write("TAKE "+ 1 + " " + st1+"\n");
								st1 = 0;
							}
							out.write("MOVE "+ "2->1 " + st2+"\n");
							st1 = st2;
							st2 = 0;
							out.write("TAKE "+ "1 "+(diference*-1)+"\n");
							st1+=diference;
						}
					}					
					break;
				}
			}
			out.write("\n");
			line = in.readLine();
		}
		out.close();
	}
}
