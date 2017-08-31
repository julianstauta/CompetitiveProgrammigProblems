import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;

public class DeduplicatingFiles {

	public static void main(String[] args) throws IOException{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = in.readLine();
		while (!line.equals("0")) {
			int c = Integer.parseInt(line);
			HashMap<String, Integer> uniqueFlies = new HashMap<>();
			for (int i = 0; i < c; i++) {
				String file = in.readLine();
				if (!uniqueFlies.containsKey(file)) {
					uniqueFlies.put(file, 1);
				} else {
					uniqueFlies.put(file, uniqueFlies.get(file)+1);
				}
			}
			int collisions = 0;
			Iterator<String> iter1 = uniqueFlies.keySet().iterator();
			while (iter1.hasNext()) {
				String file1 = iter1.next();
				char hash1 = hash(file1);
				Iterator<String> iter2 = uniqueFlies.keySet().iterator();
				while (iter2.hasNext()) {
					String file2 = iter2.next();
					if (!file1.equals(file2)) {
						char hash2 = hash(file2);
						if (hash1==hash2) {
							collisions += uniqueFlies.get(file1)*uniqueFlies.get(file2);
						}						
					}
				}
			}
			out.write(uniqueFlies.size()+" "+(collisions/2)+"\n");
			line = in.readLine();
		}
		out.close();
	}
	
	static char hash(String name) {
		char[] cad = name.toCharArray();
		char c = cad[0];
		for (int i = 1; i < name.length(); i++) {
			c ^= cad[i];
		}
		return c;
	}
	
}
