package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {
    /*** GUI COMPONENTS ***/
    private Label topLabel;
    private Label bottomLabel;
    private Button topLeftButton;
    private Button bottomRightButton;
    private TextField textField;
    private int buttonPressCount = 0;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello GUI: Your Name");
        StackPane layout = new StackPane();
        Scene scene = new Scene(layout, 300, 300);

        Label label = new Label();
        label.setText("Hello GUI World");
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBottomAnchor(label, 0.0);
        anchorPane.setRightAnchor(label, 0.0);
        anchorPane.getChildren().add(label);
        layout.getChildren().add(anchorPane);

        topLabel = new Label("Top Label");
        bottomLabel = new Label("Bottom Label");
        topLeftButton = new Button("Change Text");
        bottomRightButton = new Button("Count Press");

        AnchorPane mainAnchor = new AnchorPane();
        mainAnchor.setTopAnchor(topLabel, 10.0);
        mainAnchor.setLeftAnchor(topLabel, 10.0);
        mainAnchor.setBottomAnchor(bottomLabel, 10.0);
        mainAnchor.setLeftAnchor(bottomLabel, 10.0);
        mainAnchor.setTopAnchor(topLeftButton, 10.0);
        mainAnchor.setRightAnchor(topLeftButton, 10.0);
        mainAnchor.setBottomAnchor(bottomRightButton, 10.0);
        mainAnchor.setRightAnchor(bottomRightButton, 10.0);

        mainAnchor.getChildren().addAll(topLabel, bottomLabel, topLeftButton, bottomRightButton);
        layout.getChildren().clear();
        layout.getChildren().add(mainAnchor);

        textField = new TextField();
        mainAnchor.setBottomAnchor(textField, 100.0);
        mainAnchor.setLeftAnchor(textField, 50.0);
        mainAnchor.setRightAnchor(textField, 50.0);
        mainAnchor.getChildren().add(textField);

        topLeftButton.setOnAction(this);
        bottomRightButton.setOnAction(this);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == topLeftButton) {
            String inputText = textField.getText();
            if (!inputText.isEmpty()) {
                topLabel.setText(inputText);
            } else {
                topLabel.setText("Enter text first!");
            }
        } else if (actionEvent.getSource() == bottomRightButton) {
            buttonPressCount++;
            bottomLabel.setText("Presses: " + buttonPressCount);
        }
    }
}