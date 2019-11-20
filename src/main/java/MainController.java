
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;
import java.util.ResourceBundle;


public class MainController implements Initializable{

    private IFlightServer stub;
    private String clientName;

    public void setStub(IFlightServer stub) {
        this.stub = stub;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @FXML
    public TableView<FlightData> flightTable;
    @FXML
    public TableColumn<FlightData,String> colOpAirline;
    @FXML
    public TableColumn<FlightData,String> colIATACode;
    @FXML
    public TableColumn<FlightData,String> colFlightNum;
    @FXML
    public TableColumn<FlightData,String> colDepature;
    @FXML
    public TableColumn<FlightData,String> colArrival;
    @FXML
    public TableColumn<FlightData,String> colDTerminal;

    private static ObservableList<FlightData> data = FXCollections.observableArrayList(
    );

    public void setFlightTable(List<Flight> list){
        data.clear();
        list.forEach(flight -> {
            data.add(new FlightData(flight.IATAcode,flight.OperatingName, flight.AircraftModel,
                    flight.Flightnumber,flight.Departure,flight.Arrival,flight.DTerminal,flight.ATernimal));
        });
        System.out.println("setFlightTable size : " + data.size());
        flightTable.setItems(data);
        flightTable.refresh();
    }

    public void updateDate(){
        flightTable.setItems(data);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colIATACode.setCellValueFactory(new PropertyValueFactory<FlightData,String>("IATAcode"));
        colOpAirline.setCellValueFactory(new PropertyValueFactory<FlightData,String>("OperatingName"));
        colFlightNum.setCellValueFactory(new PropertyValueFactory<FlightData,String>("Flightnumber"));
        colDepature.setCellValueFactory(new PropertyValueFactory<FlightData,String>("Depature"));
        colArrival.setCellValueFactory(new PropertyValueFactory<FlightData,String>("Arrival"));
        colDTerminal.setCellValueFactory(new PropertyValueFactory<FlightData,String>("DTerminal"));
        flightTable.setItems(data);
    }

    @FXML
    public void add(){
        Parent root = null;
        //Load second scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("info.fxml"));
        try {
            root = (AnchorPane)loader.load();
        }catch (IOException e){
            System.out.println("load exception");
        }
        //Get controller of scene2
        InfoController controller = (InfoController) loader.getController();
        controller.setStub(stub);
        controller.setClientName(clientName);
        //Pass whatever data you want. You can have multiple method calls here
        //Show scene 2 in new window
        Stage stage = new Stage();
//        controller.setStage(stage);
        stage.setScene(new Scene(root));
        stage.setTitle("Add Flight Info");
        stage.show();
    }

    @FXML
    public void edit(){
        InfoWin.stub = stub;
        InfoWin.clientName = clientName;
        InfoWin.flightData = flightTable.getSelectionModel().getSelectedItem();
        InfoWin infoWin = new InfoWin();
        infoWin.start(new Stage());
    }

    @FXML
    public void delete() {
        ObservableList<FlightData> selectedFlight;
        selectedFlight = flightTable.getSelectionModel().getSelectedItems();
        selectedFlight.forEach(flightData -> {
            try {
                stub.deleteFlight(clientName, new Flight(flightData.getIATAcode(), flightData.getOperatingName(), flightData.getAircraftModel(),
                        flightData.getFlightnumber(), flightData.getDepature(), flightData.getArrival(), flightData.getDTerminal(), flightData.getATerminal()));

            }catch (RemoteException e){
                e.printStackTrace();
            }
        });
    }
}
