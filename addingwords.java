import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class addingwords {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = in.readLine();
		HashMap<Integer, String> calcMemory = new HashMap<>();
		HashMap<String, Integer> wordValues = new HashMap<>();
		
		while (line != null) {
			
			StringTokenizer skt = new StringTokenizer(line);
			
			switch (skt.nextToken()) {
			case "def":
				String wordValue = skt.nextToken();
				int numValue = Integer.parseInt(skt.nextToken());
				if (wordValues.containsKey(wordValue)) {
					calcMemory.remove(wordValues.get(wordValue));
				}
				calcMemory.put(numValue, wordValue);
				wordValues.put(wordValue, numValue);					
				break;
			case "calc":
				String word = skt.nextToken();
				boolean unknown = true;
				int num = 0;
				if (calcMemory.containsValue(word)) {
					num = wordValues.get(word);
					unknown = false;
				}
				while (!word.equals("=") && !unknown) {
					word = skt.nextToken();
					switch (word) {
					case "+":
						word = skt.nextToken();
						if (calcMemory.containsValue(word)) {
							num += wordValues.get(word);
						} else {
							unknown = true;
						}
						break;
					case "-":
						word = skt.nextToken();
						if (calcMemory.containsValue(word)) {
							num -= wordValues.get(word);
						} else {
							unknown = true;
						}
						break;
					}
				}
				if (!unknown&&calcMemory.containsKey(num)) {
					out.write(line.substring(5) + " " + calcMemory.get(num) + "\n");
				} else {
					out.write(line.substring(5) + " " + "unknown\n");
				}
				break;
			case "clear":
				calcMemory = new HashMap<>();
				wordValues = new HashMap<>();
				break;
			}
			line = in.readLine();
		}
		out.close();
	}

}
