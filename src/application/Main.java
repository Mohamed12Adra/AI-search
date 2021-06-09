package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application{
	/*@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}*/
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Map");
		primaryStage.show();

		
	}
	public static void main(String[] args) {
		launch(args);
		/*Node x1 = new Node("adra",20,20);
		Node x2 = new Node("adra1",30,30);
		Node x3 = new Node("adra2",40,40);
		Node x4 = new Node("adra3",50,50);
		x1.addNeighbor(x2, 10);
		x2.addNeighbor(x3, 20);
		x1.addNeighbor(x3, 40);
		Graph g = new Graph();
		g.add(x1);
		g.add(x2);
		g.add(x3);
		g.add(x4);
		System.out.println(g.UniformCostSearch(x1, x3));
		System.out.println(g.AStarSearch(x1, x3));*/
	}
}
