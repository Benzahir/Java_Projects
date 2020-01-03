package NodeColoring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class NodeColoring extends Application {

	private File file;
	private ArrayList<String> nodes;
	private ArrayList<GraphNode> graphNodes;
	private ArrayList<Integer> neighbors;

	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;

	private Group root = new Group();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {

		// ArrayList<GraphNode> l = drawGraph();
		ArrayList<GraphNode> l = drawGraph();

		// l.get(0).setColor(l.get(0).getCircle(), Color.ORANGE);

		root.getChildren().addAll(l);

		// System.out.println(l.get(1));

		stage.setScene(new Scene(root, 600, 400));

		stage.show();
	}

	private void connectNodes(GraphNode node1, GraphNode node2, String edgeText) {

		Line edgeLine = new Line(node1.getCenterX(), node1.getCenterY(), node2.getCenterX(), node2.getCenterY());
		Label edgeLabel = new Label(edgeText);

		node1.addNeighbor(node2);
		node2.addNeighbor(node1);

		node1.addEdge(edgeLine, edgeLabel);
		node2.addEdge(edgeLine, edgeLabel);

		root.getChildren().addAll(edgeLine, edgeLabel);

	}

	private GraphNode createNode(String nodeName, double xPos, double yPos, Color color) {
		GraphNode node = new GraphNode(nodeName, xPos, yPos, color);
		node.setOnMousePressed(circleOnMousePressedEventHandler);
		node.setOnMouseDragged(circleOnMouseDraggedEventHandler);

		return node;
	}

	EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			orgSceneX = t.getSceneX();
			orgSceneY = t.getSceneY();

			GraphNode node = (GraphNode) t.getSource();

			orgTranslateX = node.getTranslateX();
			orgTranslateY = node.getTranslateY();
		}
	};

	EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent t) {
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;

			GraphNode node = (GraphNode) t.getSource();

			node.setTranslateX(newTranslateX);
			node.setTranslateY(newTranslateY);

			updateLocations(node);
		}
	};

	private void updateLocations(GraphNode node) {

		ArrayList<GraphNode> connectedNodes = node.getConnectedNodes();

		ArrayList<Line> edgesList = node.getEdges();

		for (int i = 0; i < connectedNodes.size(); i++) {

			GraphNode neighbor = connectedNodes.get(i);
			Line l = edgesList.get(i);

			l.setStartX(node.getCenterX());

			l.setStartY(node.getCenterY());

			l.setEndX(neighbor.getCenterX());

			l.setEndY(neighbor.getCenterY());
		}
	}

	private ArrayList<GraphNode> drawGraph() throws IOException {

		nodes = new ArrayList<String>();
		graphNodes = new ArrayList<GraphNode>();
		neighbors = new ArrayList<Integer>();

		file = new File("C:\\Users\\abdelmonaim\\Desktop\\my3.col");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = br.readLine();
		while (line != null) {
			if (line.split(" ")[0].equals("p")) {
				nodes.add(line);
			}
			if (line.split(" ")[0].equals("e")) {
				nodes.add(line);
			}
			line = br.readLine();
		}
		br.close();

		int len = Integer.valueOf(nodes.get(0).split(" ")[2]);
		int edges = Integer.valueOf(nodes.get(0).split(" ")[3]);

		// System.out.println(nodes.get(0));

		for (int i = 0; i < len; i++) {
			int a = i + 1;
			graphNodes.add(createNode(a + "", 100, 100, Color.RED));
		}
		for (int i = 1; i < nodes.size(); i++) {
			neighbors.add(Integer.valueOf(nodes.get(i).split(" ")[1]));
		}

		for (int j = 1; j <= edges; j++) {
			GraphNode a = graphNodes.get(Integer.valueOf(nodes.get(j).split(" ")[1]) - 1);
			GraphNode b = graphNodes.get(Integer.valueOf(nodes.get(j).split(" ")[2]) - 1);
			connectNodes(a, b, "--");
			// System.out.println(Integer.valueOf(nodes.get(j).split(" ")[1]));
			// System.out.println(graphNodes.get(Integer.valueOf(nodes.get(j).split(" ")[2])
			// - 1).getText());
		}

		// System.out.println(graphNodes.get(0).getText());

		/*
		 * for(int i=0;i<graphNodes.size();i++) { GraphNode gr = graphNodes.get(i);
		 * Color c = Color.rgb(10+i*15, 0, 0); for(int j=0;j<graphNodes.size();j++) {
		 * if(!gr.isNeighbor(graphNodes.get(j))) { gr.setColor(c); }
		 * System.out.println((int)( c.getRed() * 255 )+"-"+(int)( c.getGreen() * 255
		 * )+"-"+(int)( c.getBlue() * 255 )); } }
		 */

		Set<Integer> s = new HashSet<Integer>(neighbors);
		int i = 5;
		int j = 5;

		for (Integer integer : s) {
			Color c = Color.BLACK;
			graphNodes.get(integer).setColor(c);
			ArrayList<GraphNode> cn = graphNodes.get(integer).getConnectedNodes();
			for (GraphNode gr : cn) {
				Color d = Color.rgb(100 + i * 10, 0, 20 + j * 10);
				gr.setColor(d);
				// System.out.println(
				// (int) (d.getRed() * 255) + "-" + (int) (d.getGreen() * 255) + "-" + (int)
				// (d.getBlue() * 255));
			}

			i++;
			j++;
		}

		greedyColoring(graphNodes);

		return graphNodes;
	}

	void greedyColoring(ArrayList<GraphNode> gr) {
		System.out.println(gr.size());
		int V = gr.size();
		int result[] = new int[V];

		// Initialize all vertices as unassigned
		Arrays.fill(result, -1);

		// Assign the first color to first vertex
		result[0] = 0;

		// A temporary array to store the available colors. False
		// value of available[cr] would mean that the color cr is
		// assigned to one of its adjacent vertices
		boolean available[] = new boolean[V];

		// Initially, all colors are available
		Arrays.fill(available, true);

		// Assign colors to remaining V-1 vertices
		for (int u = 1; u < V; u++) {
			// Process all adjacent vertices and flag their colors
			// as unavailable
			// System.out.println("---"+gr.get(u).getText());
			Iterator<Integer> it = gr.get(u).getConnectedNodes2().iterator();
			// System.out.println(gr.get(u).getText()+"---------");
			while (it.hasNext()) {
				int i = it.next();
				if (i < V && result[i] != -1)
					available[result[i]] = false;
				// System.out.println(i);
			}

			// Find the first available color
			int cr;
			for (cr = 0; cr < V; cr++) {
				if (available[cr])
					break;
			}

			result[u] = cr; // Assign the found color

			// Reset the values back to true for the next iteration
			Arrays.fill(available, true);
		}

		// print the result
		for (int u = 1; u < V; u++) {
			gr.get(u).setColor(Color.rgb(result[u]*100,0,255-result[u]*100));
			System.out.println("Vertex " + u + " --->  Color " + result[u]);
		}

	}

}
