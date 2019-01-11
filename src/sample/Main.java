package sample;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Splash.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.show();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage newStage = new Stage();

        newStage.setScene(new Scene(root1));
        newStage.setTitle("Editor");
        newStage.initStyle(StageStyle.TRANSPARENT);

        //TextField foo = (TextField)fxmlLoader.getNamespace().get("txtNum1");
        //foo.requestFocus();

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished( event -> primaryStage.close() );
        delay.play();
        PauseTransition openWindow = new PauseTransition(Duration.seconds(2));
        openWindow.setOnFinished( event -> newStage.show() );
        openWindow.play();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
