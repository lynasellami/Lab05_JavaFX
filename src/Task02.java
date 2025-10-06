import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Task02 extends Application {

    private ComboBox<String> cbBeverage;
    private ComboBox<String> cbAppetizer;
    private ComboBox<String> cbMain;
    private ComboBox<String> cbDessert;

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Restaurant Bill Calculator");

        // --- ComboBoxes for each category (from lab sample data) ---
        cbBeverage = new ComboBox<>();
        cbAppetizer = new ComboBox<>();
        cbMain      = new ComboBox<>();
        cbDessert   = new ComboBox<>();

        cbBeverage.getItems().addAll("Coffee","Tea","Soft Drink","Water","Milk","Juice");
        cbAppetizer.getItems().addAll("Soup","Salad","Spring Rolls","Garlic Bread","Chips and Salsa");
        cbMain.getItems().addAll("Steak","Grilled Chicken","Chicken Alfredo","Turkey Club","Shrimp Scampi","Pasta","Fish and Chips");
        cbDessert.getItems().addAll("Apple Pie","Carrot Cake","Mud Pie","Pudding","Apple Crisp");

        cbBeverage.setPromptText("Select Beverage");
        cbAppetizer.setPromptText("Select Appetizer");
        cbMain.setPromptText("Select Main Course");
        cbDessert.setPromptText("Select Dessert");

        GridPane form = new GridPane();
        form.setHgap(12);
        form.setVgap(10);
        form.setPadding(new Insets(12));

        form.add(new Label("Beverage:"), 0, 0);
        form.add(cbBeverage,            1, 0);
        form.add(new Label("Appetizer:"), 0, 1);
        form.add(cbAppetizer,            1, 1);
        form.add(new Label("Main Course:"), 0, 2);
        form.add(cbMain,                  1, 2);
        form.add(new Label("Dessert:"), 0, 3);
        form.add(cbDessert,             1, 3);

        VBox root = new VBox(10, title, form);
        root.setPadding(new Insets(12));

        Scene scene = new Scene(root, 560, 420);
        primaryStage.setTitle("Task 02 - Restaurant Bill");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}