import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;

import java.io.IOException;

/**
 * Flight Info Windows
 */
public class InfoWin extends Application {

    public static InfoController infoController;
    public static IFlightServer stub;
    public static String clientName;
    public static FlightData flightData;

    private InfoWin instance;

    public InfoWin() {
        if (instance != null){
            new InfoWin();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Flight Information Panel");
        primaryStage.setResizable(false);
        AnchorPane root = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("info.fxml"));
            root = (AnchorPane)loader.load();
            infoController = loader.getController();
//            infoController.setFlightTable(flights);
            infoController.setStub(stub);
            infoController.setClientName(clientName);
            infoController.model.setIATAcode(flightData.getIATAcode());
            infoController.model.setOperatingName(flightData.getOperatingName());
            infoController.model.setAircraftModel(flightData.getAircraftModel());
            infoController.model.setFlightnumber(flightData.getFlightnumber());
            infoController.model.setDepature(flightData.getDepature());
            infoController.model.setArrival(flightData.getArrival());
            infoController.model.setDTerminal(flightData.getDTerminal());
            infoController.model.setATerminal(flightData.getATerminal());
        }catch (IOException e){
            e.printStackTrace();
        }
        primaryStage.setScene(new Scene(root, 600, 520));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("info ");
        super.stop();
    }
}
