import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CoastLength {

	static int[][] matriz = null;
	static boolean[][] visitados = null;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer skt = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(skt.nextToken()) + 2;
		int m = Integer.parseInt(skt.nextToken()) + 2;
		matriz = new int[n][m];
		visitados = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String[] line = null;
			if (i != 0 && i !=n-1){
				line = in.readLine().split("");				
			}
			for (int j = 0; j < m; j++) {
				if (i == 0 || j == 0 || i == n-1 || j == m-1) {
					matriz[i][j] = 0;
				}
				else{
					matriz[i][j] = Integer.parseInt(line[j-1]); 
				}
			}
		}
		int coast = recusividadOP(0, 0, 0);
		out.write(coast+"\n");
		out.close();
		in.close();
	}

	public static int recusividadOP(int valor, int j, int i) {
		int tamano = 0;
		visitados[i][j] = true;
		if (j != matriz[0].length - 1) {
			if (valor == matriz[i][j + 1] && !visitados[i][j + 1]) {
				tamano += recusividadOP(valor, j + 1, i);
			} else if (valor != matriz[i][j + 1]) {
				tamano += 1;
			}
		}
		if (j != 0) {
			if (valor == matriz[i][j - 1] && !visitados[i][j - 1]) {
				tamano += recusividadOP(valor, j - 1, i);
			} else if (valor != matriz[i][j - 1]) {
				tamano += 1;
			}
		}
		if (i != matriz.length - 1) {
			if (valor == matriz[i + 1][j] && !visitados[i + 1][j]) {
				tamano += recusividadOP(valor, j, i + 1);
			} else if (valor != matriz[i + 1][j]) {
				tamano += 1;
			}
		}
		if (i != 0) {
			if (valor == matriz[i - 1][j] && !visitados[i - 1][j]) {
				tamano += recusividadOP(valor, j, i - 1);
			} else if (valor != matriz[i - 1][j]) {
				tamano += 1;
			}
		}
		return tamano;
	}

}
