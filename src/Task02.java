// Git repository: https://github.com/<your-username>/<your-repo>

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Task02 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Restaurant Bill Calculator");

        VBox root = new VBox(10, title);
        root.setPadding(new Insets(12));

        Scene scene = new Scene(root, 520, 480);
        primaryStage.setTitle("Task 02 - Restaurant Bill");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
