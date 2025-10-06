// Git repository: https://github.com/lynasellami/Lab05_JavaFX.git

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Task01 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Bag Order Form");

        // --- ListView: 6 bag types ---
        ListView<String> bagList = new ListView<>();
        bagList.getItems().addAll(
                "Full Decorative",
                "Beaded",
                "Pirate Design",
                "Fringed",
                "Leather",
                "Plain"
        );
        bagList.setPrefSize(200, 120);

        // --- ComboBox: quantity 1..10 ---
        ComboBox<Integer> qtyCombo = new ComboBox<>();
        for (int i = 1; i <= 10; i++) {
            qtyCombo.getItems().add(i);
        }
        qtyCombo.setPromptText("Quantity");
        qtyCombo.setVisibleRowCount(10);

        // --- RadioButtons + ToggleGroup: Small / Medium / Large ---
        ToggleGroup sizeGroup = new ToggleGroup();
        RadioButton rbSmall = new RadioButton("Small");
        RadioButton rbMedium = new RadioButton("Medium");
        RadioButton rbLarge = new RadioButton("Large");
        rbSmall.setToggleGroup(sizeGroup);
        rbMedium.setToggleGroup(sizeGroup);
        rbLarge.setToggleGroup(sizeGroup);
        rbMedium.setSelected(true);

        HBox sizeRow = new HBox(10, rbSmall, rbMedium, rbLarge);
        sizeRow.setAlignment(Pos.CENTER_LEFT);

        // Layout rows
        GridPane grid = new GridPane();
        grid.setHgap(12);
        grid.setVgap(10);
        grid.setPadding(new Insets(12));

        grid.add(new Label("Bag Type:"), 0, 0);
        grid.add(bagList,              1, 0);

        grid.add(new Label("Quantity:"), 0, 1);
        grid.add(qtyCombo,               1, 1);

        grid.add(new Label("Size:"), 0, 2);
        grid.add(sizeRow,            1, 2);

        VBox root = new VBox(10, title, grid);
        root.setPadding(new Insets(12));

        Scene scene = new Scene(root, 440, 330);
        primaryStage.setTitle("Task 01 - Bag Order Form");
        primaryStage.setScene(scene);
        primaryStage.show();

        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}