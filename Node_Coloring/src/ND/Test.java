package ND;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws IOException {
		
		
		// ArrayList of nodes
		ArrayList<String> nodes = new ArrayList<String>();
		
		// read the instance file , pass the filename as argument
		File file = new File("C:\\Users\\abdelmonaim\\Desktop\\"+args[0]);
		
		

		BufferedReader br = new BufferedReader(new FileReader(file));

		// Read the file line by line
		String line = br.readLine();		
		while (line != null) {
			
			// here we add nodes to the ArrayList "nodes"
			if (line.split(" ")[0].equals("p")) {
				nodes.add(line);				
			}
			if (line.split(" ")[0].equals("e")) {
				nodes.add(line);				
			}
			line = br.readLine();
		}
		br.close();
		
		// get the total number of nodes
		int len = Integer.valueOf(nodes.get(0).split(" ")[2]);					
		
		Graph g = new Graph(len+1);
		
		for(int i=1;i<nodes.size();i++) {
			int a = Integer.valueOf(nodes.get(i).split(" ")[1]);
			int b = Integer.valueOf(nodes.get(i).split(" ")[2]);
			
			// call the function addEdge to assign edges
			g.addEdge(a,b);
		}								
		
		// Calling the color function
		g.colorTheGraph();

	}

}
