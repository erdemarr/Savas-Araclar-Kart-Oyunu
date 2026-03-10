package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Oyun extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            Parent root = loader.load();

            primaryStage.setTitle("Savaş Araçları Kart Oyunu");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.setResizable(true); // Pencere boyutlandırılabilir
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1); 
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
