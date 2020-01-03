package NodeColoring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Test {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> nodes = new ArrayList<String>();
		

		File file = new File("C:\\Users\\abdelmonaim\\Desktop\\graph.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String line = br.readLine();
		while(line!=null) {
			nodes.add(line);
			line = br.readLine();
		}
		br.close();
		
		int len = Integer.valueOf(nodes.get(0).split(" ")[2]);
		int edges = Integer.valueOf(nodes.get(0).split(" ")[3]);
		
		int p=1;
		
		for(int j=1;j<edges;j++) {
			//nodes.get(1).split(" ")[1];
			
			int o = Integer.valueOf(nodes.get(p).split(" ")[1]);		
			//System.out.println(p);
			while(p==j) {
				System.out.println(nodes.get(o)+"---"+nodes.get(Integer.valueOf(nodes.get(p).split(" ")[2])));
				p++;
			}
			
		}

	}

}
