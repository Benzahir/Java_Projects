package NodeColoring;

import java.util.ArrayList;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GraphNode extends StackPane {

	private Circle circle;
	private Label text;

	private ArrayList<GraphNode> connectedNodesList = new ArrayList<>();
	private ArrayList<Line> edgesList = new ArrayList<>();
	private ArrayList<Label> edgesLabelList = new ArrayList<>();

	private double radius = 50.0;

	public GraphNode(String name, double xPos, double yPos, Color color) {

		circle = new Circle(radius, color);
		text = new Label(name);
		text.setTextFill(Color.WHITE);

		setLayoutX(xPos);
		setLayoutY(yPos);

		getChildren().addAll(circle, text);
		layout();
	}

	public void addNeighbor(GraphNode node) {
		connectedNodesList.add(node);
	}

	public void addEdge(Line edgeLine, Label edgeLabel) {
		edgesList.add(edgeLine);
		edgesLabelList.add(edgeLabel);

		// If user move the node we should translate the edge labels as well
		// one way of doing that is by make a custom binding to the layoutXProperty as
		// well
		// as to layoutYProperty. We will listen for changes to the currentNode
		// translate properties
		// and for changes of our neighbor.

		edgeLabel.layoutXProperty().bind(new DoubleBinding() {
			{
				bind(translateXProperty());
				bind(connectedNodesList.get(connectedNodesList.size() - 1).translateXProperty());
			}

			@Override
			protected double computeValue() {

				// We find the center of the line to translate the text
				double width = edgeLine.getEndX() - edgeLine.getStartX();

				return edgeLine.getStartX() + width / 2.0;
			}
		});

		edgeLabel.layoutYProperty().bind(new DoubleBinding() {
			{
				bind(translateYProperty());
				bind(connectedNodesList.get(connectedNodesList.size() - 1).translateYProperty());
			}

			@Override
			protected double computeValue() {

				double width = edgeLine.getEndY() - edgeLine.getStartY();
				return edgeLine.getStartY() + width / 2.0;
			}
		});

	}

	public ArrayList<GraphNode> getConnectedNodes() {
		return connectedNodesList;
	}
	
	public ArrayList<Integer> getConnectedNodes2() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (GraphNode integer : connectedNodesList) {
			arr.add(Integer.valueOf(integer.getText().toString()));
		}
		return arr;
	}

	public ArrayList<Line> getEdges() {
		return edgesList;
	}

	public double getX() {
		return getLayoutX() + getTranslateX();
	}

	public double getY() {
		return getLayoutY() + getTranslateY();
	}

	public double getCenterX() {
		return getX() + radius;
	}

	public double getCenterY() {
		return getY() + radius;
	}

	public String getText() {
		return text.getText();
	}

	public void setColor(Color color) {
		this.getCircle().setFill(color);
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public boolean isNeighbor(GraphNode g) {
		ArrayList<GraphNode> neighbors = this.getConnectedNodes();
		
		for (GraphNode graphNode : neighbors) {
			if(graphNode.equals(g)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	
	
	
}