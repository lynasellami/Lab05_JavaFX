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

    private Slider tipSlider;
    private Label tipPercentLabel;

    private Label lblSubtotal;
    private Label lblTax;
    private Label lblTip;
    private Label lblTotal;

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Restaurant Bill Calculator");

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

        tipSlider = new Slider(0, 20, 0);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        tipSlider.setMajorTickUnit(5);
        tipSlider.setMinorTickCount(4);
        tipSlider.setBlockIncrement(1);
        tipSlider.setSnapToTicks(true);

        tipPercentLabel = new Label("Tip: 0%");

        // Totals labels
        lblSubtotal = new Label("$0.00");
        lblTax      = new Label("$0.00");
        lblTip      = new Label("$0.00");
        lblTotal    = new Label("$0.00");

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

        form.add(new Label("Tip (0%–20%):"), 0, 4);
        form.add(tipSlider,               1, 4);
        form.add(tipPercentLabel,         1, 5);

        form.add(new Label("Subtotal:"), 0, 6);
        form.add(lblSubtotal,            1, 6);
        form.add(new Label("Tax:"),      0, 7);
        form.add(lblTax,                 1, 7);
        form.add(new Label("Tip:"),      0, 8);
        form.add(lblTip,                 1, 8);
        form.add(new Label("Total:"),    0, 9);
        form.add(lblTotal,               1, 9);

        VBox root = new VBox(10, title, form);
        root.setPadding(new Insets(12));

        Scene scene = new Scene(root, 580, 520);
        primaryStage.setTitle("Task 02 - Restaurant Bill");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}