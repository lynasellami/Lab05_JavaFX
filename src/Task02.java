import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Task02 extends Application {

    private static final double TAX_RATE = 0.13; // change if specified otherwise

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

    private final String[] bevNames = {"Coffee","Tea","Soft Drink","Water","Milk","Juice"};
    private final double[] bevPrices = {2.50, 2.00, 1.75, 2.95, 1.50, 2.50};

    private final String[] appNames = {"Soup","Salad","Spring Rolls","Garlic Bread","Chips and Salsa"};
    private final double[] appPrices = {4.50, 3.75, 5.25, 3.00, 6.95};

    private final String[] mainNames = {"Steak","Grilled Chicken","Chicken Alfredo","Turkey Club","Shrimp Scampi","Pasta","Fish and Chips"};
    private final double[] mainPrices = {15.00, 13.50, 13.95, 11.90, 18.99, 11.75, 12.25};

    private final String[] desNames = {"Apple Pie","Carrot Cake","Mud Pie","Pudding","Apple Crisp"};
    private final double[] desPrices = {5.95, 4.50, 4.75, 3.25, 5.98};

    @Override
    public void start(Stage primaryStage) {
        Label title = new Label("Restaurant Bill Calculator");

        cbBeverage = new ComboBox<>();
        cbAppetizer = new ComboBox<>();
        cbMain      = new ComboBox<>();
        cbDessert   = new ComboBox<>();

        cbBeverage.getItems().addAll(bevNames);
        cbAppetizer.getItems().addAll(appNames);
        cbMain.getItems().addAll(mainNames);
        cbDessert.getItems().addAll(desNames);

        cbBeverage.setPromptText("Beverage");
        cbAppetizer.setPromptText("Appetizer");
        cbMain.setPromptText("Main Course");
        cbDessert.setPromptText("Dessert");

        tipSlider = new Slider(0, 20, 0);
        tipSlider.setShowTickLabels(true);
        tipSlider.setShowTickMarks(true);
        tipSlider.setMajorTickUnit(5);
        tipSlider.setMinorTickCount(4);
        tipSlider.setBlockIncrement(1);
        tipSlider.setSnapToTicks(true);

        tipPercentLabel = new Label("Tip: 0%");

        lblSubtotal = new Label("$0.00");
        lblTax      = new Label("$0.00");
        lblTip      = new Label("$0.00");
        lblTotal    = new Label("$0.00");

        Button clearBtn = new Button("Clear Bill");

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

        form.add(clearBtn, 0, 10);

        VBox root = new VBox(12, title, form);
        root.setPadding(new Insets(14));

        cbBeverage.setOnAction(e -> recalc());
        cbAppetizer.setOnAction(e -> recalc());
        cbMain.setOnAction(e -> recalc());
        cbDessert.setOnAction(e -> recalc());
        tipSlider.valueProperty().addListener((obs, o, n) -> recalc());

        clearBtn.setOnAction(e -> {
            cbBeverage.setValue(null);
            cbAppetizer.setValue(null);
            cbMain.setValue(null);
            cbDessert.setValue(null);
            tipSlider.setValue(0);
            tipPercentLabel.setText("Tip: 0%");
            lblSubtotal.setText("$0.00");
            lblTax.setText("$0.00");
            lblTip.setText("$0.00");
            lblTotal.setText("$0.00");
        });

        Scene scene = new Scene(root, 640, 560);
        primaryStage.setTitle("Task 02 - Restaurant Bill");
        primaryStage.setScene(scene);
        primaryStage.show();
        root.requestFocus();
    }

    private void recalc() {
        double subtotal = 0.0;
        subtotal += priceOf(cbBeverage.getValue(), bevNames, bevPrices);
        subtotal += priceOf(cbAppetizer.getValue(), appNames, appPrices);
        subtotal += priceOf(cbMain.getValue(),      mainNames, mainPrices);
        subtotal += priceOf(cbDessert.getValue(),   desNames, desPrices);

        double tax = subtotal * TAX_RATE; // ⚠️ arithmetic beyond slides; required by lab
        double tipPct = Math.round(tipSlider.getValue());
        tipPercentLabel.setText("Tip: " + (int) tipPct + "%");

        double tip = (subtotal + tax) * (tipPct / 100.0);
        double total = subtotal + tax + tip;

        lblSubtotal.setText(String.format("$%.2f", subtotal)); // ⚠️ String.format (standard Java)
        lblTax.setText(String.format("$%.2f", tax));
        lblTip.setText(String.format("$%.2f", tip));
        lblTotal.setText(String.format("$%.2f", total));
    }

    private double priceOf(String selected, String[] names, double[] prices) {
        if (selected == null) return 0.0;
        for (int i = 0; i < names.length; i++) {
            if (selected.equals(names[i])) {
                return prices[i];
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
