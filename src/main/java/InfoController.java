

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

/**
 * Flight info windows Controller
 */
public class InfoController implements Initializable {

    @FXML
    private TextField IATAText; //IATAcode
    @FXML
    private TextField OpNameText; //OperatingName
    @FXML
    private TextField ModelText; //AircraftModel
    @FXML
    private TextField TrackNrText; //Flightnumber
    @FXML
    private TextField DepatureText; //Departure
    @FXML
    private TextField ArrivalText; //Arrival
    @FXML
    private TextField DTerminalText; //DTerminal
    @FXML
    private TextField ATerminalText; //ATernimal
    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;

    public static FlightData model ;

    public IFlightServer stub ;
    public String clientName;

    public void setStub(IFlightServer stub) {
        this.stub = stub;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new FlightData();
        model.IATAcodeProperty().addListener((obs,oldText,newText) -> IATAText.setText(newText));
        model.operatingNameProperty().addListener((obs,oldText,newText) -> OpNameText.setText(newText));
        model.aircraftModelProperty().addListener((obs,oldText,newText) -> ModelText.setText(newText));
        model.flightnumberProperty().addListener((obs,oldText,newText) -> TrackNrText.setText(newText));
        model.depatureProperty().addListener((obs,oldText,newText) -> DepatureText.setText(newText));
        model.arrivalProperty().addListener((obs,oldText,newText) -> ArrivalText.setText(newText));
        model.DTerminalProperty().addListener((obs,oldText,newText) -> DTerminalText.setText(newText));
        model.ATerminalProperty().addListener((obs,oldText,newText) -> ATerminalText.setText(newText));
    }

    public void save(){
        Flight flight = new Flight(IATAText.getText(),OpNameText.getText(),ModelText.getText(),TrackNrText.getText(),DepatureText.getText(),ArrivalText.getText(),DTerminalText.getText(),ATerminalText.getText());
        try {
            stub.updateFlight(clientName,flight);
        }catch (RemoteException e){
            e.printStackTrace();
        }
        Stage stage = (Stage)saveBtn.getScene().getWindow();
        stage.close();
    }

    public void cancel(){
        Stage stage = (Stage)cancelBtn.getScene().getWindow();
        stage.close();
    }

}
