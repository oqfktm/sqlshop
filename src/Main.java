// PhoneShop SQL - MF

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    // Console Color Support
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String WHITE = "\u001B[37m";
    public static final String GREEN = "\u001B[32m";

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println(YELLOW);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        System.out.println(YELLOW + "[FXML] Initializing...");
        System.out.println(YELLOW + "[FXML] Resource Loaded.");
        primaryStage.setTitle("Phone Shop");
        primaryStage.setScene(new Scene(root, 600, 520));
        System.out.println("[FXML] PrimaryStage Created.");
        primaryStage.show();
        System.out.println("[FXML] PrimaryStage Displayed.");
        System.out.println(GREEN + "[PhoneShop] Ready.");
        System.out.println();

    }


    public static void main(String[] args) {
        String ver = "FINAL-1 R0";
        System.out.println();
        Logo();
        System.out.println();
        System.out.println("-----------------[ " + "Phone Shop " + ver + " ]-----------------");
        launch(args);
    }

    static void Logo() {
        System.out.println("  ____  _                      ____  _                 ");
        System.out.println(" |  _ \\| |__   ___  _ __   ___/ ___|| |__   ___  _ __  ");
        System.out.println(" | |_) | '_ \\ / _ \\| '_ \\ / _ \\___ \\| '_ \\ / _ \\| '_ \\ ");
        System.out.println(" |  __/| | | | (_) | | | |  __/___) | | | | (_) | |_) |");
        System.out.println(" |_|   |_| |_|\\___/|_| |_|\\___|____/|_| |_|\\___/| .__/ ");
        System.out.println("                                                |_|    " + "   By Marek Fekete");
    }
}
