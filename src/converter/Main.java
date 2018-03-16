package converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class of running Length Converter
 */
public class Main extends Application {
    /**
     * run the FXML stage
     * @param primaryStage XML stage
     */
    @Override
    public void start(Stage primaryStage){
        try {
            Parent root = (Parent) FXMLLoader.load(getClass().getResource("ConverterUI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("The Converter");
            primaryStage.setScene(scene);
            primaryStage.sizeToScene();
            primaryStage.show();
        } catch (Exception e){
            System.out.println("Exception creating scene: "+e.getMessage());
        }
    }
    /** run the application*/
    public static void main(String[] args) {
        launch(args);
    }
}
