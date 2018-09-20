import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class batmanacci {

	static BigInteger[] fibonacci = new BigInteger[100000];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		fibonacci();
		StringTokenizer skt = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(skt.nextToken())-1;		
		String k = skt.nextToken();
		out.write(NanananaBatman(n, new BigInteger(k)));
		out.close();
	}
	
	static void fibonacci() {
		fibonacci[0] = new BigInteger("1");
		fibonacci[1] = new BigInteger("1");
		for (int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = fibonacci[i-1].add(fibonacci[i-2]);
		}
	}
	
	static char NanananaBatman(int n, BigInteger k) {
		if (n == 0) {
			return 'N';
		}
		if (n == 1){
			return 'A';
		}
		if (fibonacci[n-2].compareTo(k)<0) {
			return NanananaBatman(n-1, k.subtract(fibonacci[n-2]));
		} else {
			return NanananaBatman(n-2, k);
		}
	}
	
}
