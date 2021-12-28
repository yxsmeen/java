package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main8 extends Application {
	protected Label lbl;
	protected TextField txfName;
	protected TextArea txaMessage;
	protected Button btnHelloWorld;
	protected Label lblImFeeling;
	protected CheckBox chkHappy, chkHungry, chkSleepy;
	protected ComboBox<String> cmbSalutation;
	protected ToggleGroup tGrpStyleChoice;
	protected ListView<String> lvwInterests;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Create root container for controls
			Pane root = buildGui();
			// Add GridPane (root) to Scene.
			Scene scene = new Scene(root,700,350);
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
	
	private Pane buildNameEntry() {
		cmbSalutation = new ComboBox<>();
		cmbSalutation.getItems().addAll("Mrs", "Ms", "Mr", "Dr");
		cmbSalutation.setValue("Ms");
		txfName = new TextField();
		// Create HBox and add label and text field
		HBox hBoxName = new HBox();
		hBoxName.getStyleClass().add("h_or_v_box");			
		hBoxName.getChildren().addAll(cmbSalutation, txfName);
		return hBoxName;
	}
	
	private Pane buildFeelingsEntry() {
		// Create VBox and check boxes and add
		lblImFeeling = new Label("I'm Feeling:");
		chkHappy = new CheckBox("Happy");
		chkHungry = new CheckBox("Hungry");
		chkSleepy = new CheckBox("Sleepy");
		VBox vBoxFeeling = new VBox();
		vBoxFeeling.getStyleClass().add("h_or_v_box");
		vBoxFeeling.getChildren().addAll(lblImFeeling, chkHappy, chkHungry, chkSleepy);
		return vBoxFeeling;
	}

	private Pane buildGui() {
		GridPane root = new GridPane();
		
		Pane p = buildUpperLeft();
		root.add(p, 0, 0);
		
		Pane p2 = buildFeelingsEntry();
		root.add(p2, 1, 0);
		
		// Create other controls
		txaMessage = new TextArea();
		txaMessage.setPrefHeight(100);
		txaMessage.setPrefWidth(200);
		root.add(txaMessage, 0, 1);
		
		Pane p3 = buildInterestsEntry();
		root.add(p3, 2, 0);
		return root;
	}


	private Pane buildMessageStyleEntry() {
		btnHelloWorld = new Button("Hello World");

		Label lbl = new Label("Message Style: ");
		
		RadioButton rbShort = new RadioButton("Short");
		rbShort.setToggleGroup(tGrpStyleChoice);
		rbShort.setSelected(true);

		RadioButton rbLong = new RadioButton("Long");
		rbLong.setToggleGroup(tGrpStyleChoice);
		
		// Create HBox and add label and radio buttons
		HBox hBoxName = new HBox();
		hBoxName.getStyleClass().add("h_or_v_box");
		hBoxName.getChildren().addAll(btnHelloWorld, lbl, rbShort, rbLong);
		return hBoxName;
	}

	private Pane buildUpperLeft() {
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().addAll(buildNameEntry(), buildMessageStyleEntry());
		return vBox;
	}

	private Pane buildInterestsEntry() {
		lvwInterests = new ListView<>();
		lvwInterests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvwInterests.getItems().addAll("Music", "Dance", "Disc Golf", "Theater", "Reading");
		lvwInterests.setPrefHeight(150);
		lvwInterests.setPrefWidth(120);
		VBox vBox = new VBox();
	    vBox.getStyleClass().add("h_or_v_box");	
		vBox.getChildren().add(new Label("Interests\nSelect all that apply"));
		vBox.getChildren().add(lvwInterests);
		return vBox;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
