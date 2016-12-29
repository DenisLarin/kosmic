package sample.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controllers.MainController;
import sample.logical.KosmikServises;
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("../fxml/sample.fxml"));
        Parent fxmlMain = fxmlLoader.load();
        MainController mainController = fxmlLoader.getController();
        mainController.setMainWindow(primaryStage);

        primaryStage.setTitle("Косметический магазин");
        primaryStage.setScene(new Scene(fxmlMain));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
       launch(args);
    }
}
