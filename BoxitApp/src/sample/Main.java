package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.stage = stage; // initialize value of stage.
        Parent root = FXMLLoader.load(getClass().getResource("sample/sample.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
