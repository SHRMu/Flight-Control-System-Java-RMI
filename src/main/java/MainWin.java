import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainWin extends Application {

    public MainController mainController;

    public static List<Flight> flights = new ArrayList<>();
    public static IFlightServer stub;
    public static String clientName;

    private static MainWin instance;

    public MainWin(){
        instance = this;
    }

    public static MainWin getInstance(){
        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flight Control System");
        primaryStage.setResizable(false);
        AnchorPane root = null;
        try {
            URL resource = getClass().getResource("main.fxml");
            FXMLLoader loader = new FXMLLoader(resource);
            root = (AnchorPane)loader.load();
            mainController = loader.getController();
            mainController.setFlightTable(flights);
            mainController.setStub(stub);
            mainController.setClientName(clientName);
        }catch (IOException e){
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        stub.logout("demo");
        super.stop();
    }

}
