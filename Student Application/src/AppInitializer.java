import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class AppInitializer extends Application {
    public static void  main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException, AWTException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Form.fxml"))));
        primaryStage.show();

        Robot robot=new Robot();
        robot.mouseMove(900,400);
    }
}