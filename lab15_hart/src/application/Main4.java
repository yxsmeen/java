package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main4 extends Application {
	protected Label lbl;
	protected TextField txfName;
	protected TextArea txaMessage;
	protected Button btnHelloWorld;
	protected Label lblImFeeling;
	protected CheckBox chkHappy, chkHungry, chkSleepy;
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create controls
			lbl = new Label("Name");
			txfName = new TextField();
			txaMessage = new TextArea();
			txaMessage.setPrefHeight(100);
			txaMessage.setPrefWidth(200);
			btnHelloWorld = new Button("Hello World");

			// Create HBox and add label and text field
			HBox hBoxName = new HBox();
			hBoxName.getStyleClass().add("h_or_v_box");			
			hBoxName.getChildren().addAll(lbl, txfName);

			//***LOOK at this carefully below

			// Create VBox and check boxes and add
			lblImFeeling = new Label("I'm Feeling:");
			chkHappy = new CheckBox("Happy");
			chkHungry = new CheckBox("Hungry");
			chkSleepy = new CheckBox("Sleepy");
			VBox vBoxFeeling = new VBox();
			vBoxFeeling.getStyleClass().add("h_or_v_box");
			vBoxFeeling.getChildren().addAll(lblImFeeling, chkHappy, chkHungry, chkSleepy);

			// Create root container for controls
			GridPane root = new GridPane();

			//***LOOK at this carefully below
			//***Note how we add the hbox at 0,0, and
			//   the vbox at 1,0, right beside it

			// Add HBox to Gridpane
			root.add(hBoxName, 0, 0);
			// Add VBox to Gridpane
			root.add(vBoxFeeling, 1, 0);

			// Add other controls to GridPane
			root.add(btnHelloWorld, 0, 1);
			root.add(txaMessage, 0, 2);

			// Add GridPane (root) to Scene.
			Scene scene = new Scene(root,400,300);

			// Set the title for the window
			primaryStage.setTitle("Hello World");

			// Code to display the Gui
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
