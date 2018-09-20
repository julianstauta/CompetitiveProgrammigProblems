import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class npuzzle {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[][] puzzle = new char[4][4];
		char[][] solved = new char[4][4];
		fillsolved(solved);
		
		for (int i = 0; i < puzzle.length; i++) {
			puzzle[i] = in.readLine().toCharArray();
		}
		int scatter = 0;
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle.length; j++) {
				if (puzzle[i][j]!=solved[i][j]) {
					boolean cond = false; 
					for (int j2 = 0; j2 < solved.length&&!cond; j2++) {
						for (int k = 0; k < solved.length&&!cond; k++) {
							if (puzzle[i][j]==solved[j2][k]) {
								scatter += Math.abs(i-j2)+Math.abs(j-k);
								cond = true;
							}
						}
					}
				}
			}
		}
		out.write(scatter+"\n");
		out.close();
	}
	
	static void fillsolved(char[][] npuzzle) {
		char c = 'A';
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (j == 3&&i==3) {
					npuzzle[i][j] = '.';
				}
				npuzzle[i][j] = c;
				c++;
			}
		}
	}
	
}
