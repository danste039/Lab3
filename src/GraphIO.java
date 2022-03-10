import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphIO {
	
	static public void readFile(Graph g, String filename) {
		File file;
		Scanner scan = null;

		try {
			file = new File(filename);
			scan = new Scanner(file);
			int id = scan.nextInt();

			for (int i = 0; i < id; i++) {
				g.addNode(scan.nextInt(), scan.nextInt(), scan.nextInt());
			}

			while (scan.hasNextLine()) {
				g.addEdge(scan.nextInt(), scan.nextInt(), scan.nextInt());
			}
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}