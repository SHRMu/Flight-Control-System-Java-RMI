
import javafx.beans.property.SimpleStringProperty;

public class FlightData {

    private final SimpleStringProperty IATAcode = new SimpleStringProperty();
    private final SimpleStringProperty OperatingName = new SimpleStringProperty();
    private final SimpleStringProperty AircraftModel = new SimpleStringProperty();
    private final SimpleStringProperty Flightnumber = new SimpleStringProperty();
    private final SimpleStringProperty Depature = new SimpleStringProperty();
    private final SimpleStringProperty Arrival = new SimpleStringProperty();
    private final SimpleStringProperty DTerminal = new SimpleStringProperty();
    private final SimpleStringProperty ATerminal = new SimpleStringProperty();

    public FlightData() {
    }

    public FlightData(String IATAcode, String OperatingName, String AircraftModel, String Flightnumber, String Depature, String Arrival, String DTerminal, String ATerminal) {
        setIATAcode(IATAcode);
        setOperatingName(OperatingName);
        setAircraftModel(AircraftModel);
        setFlightnumber(Flightnumber);
        setDepature(Depature);
        setArrival(Arrival);
        setDTerminal(DTerminal);
        setATerminal(ATerminal);
    }

    public String getIATAcode() {
        return IATAcode.get();
    }

    public SimpleStringProperty IATAcodeProperty() {
        return IATAcode;
    }

    public void setIATAcode(String IATAcode) {
        this.IATAcode.set(IATAcode);
    }

    public String getOperatingName() {
        return OperatingName.get();
    }

    public SimpleStringProperty operatingNameProperty() {
        return OperatingName;
    }

    public void setOperatingName(String operatingName) {
        this.OperatingName.set(operatingName);
    }

    public String getAircraftModel() {
        return AircraftModel.get();
    }

    public SimpleStringProperty aircraftModelProperty() {
        return AircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.AircraftModel.set(aircraftModel);
    }

    public String getFlightnumber() {
        return Flightnumber.get();
    }

    public SimpleStringProperty flightnumberProperty() {
        return Flightnumber;
    }

    public void setFlightnumber(String flightnumber) {
        this.Flightnumber.set(flightnumber);
    }

    public String getDepature() {
        return Depature.get();
    }

    public SimpleStringProperty depatureProperty() {
        return Depature;
    }

    public void setDepature(String depature) {
        this.Depature.set(depature);
    }

    public String getArrival() {
        return Arrival.get();
    }

    public SimpleStringProperty arrivalProperty() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        this.Arrival.set(arrival);
    }

    public String getDTerminal() {
        return DTerminal.get();
    }

    public SimpleStringProperty DTerminalProperty() {
        return DTerminal;
    }

    public void setDTerminal(String DTerminal) {
        this.DTerminal.set(DTerminal);
    }

    public String getATerminal() {
        return ATerminal.get();
    }

    public SimpleStringProperty ATerminalProperty() {
        return ATerminal;
    }

    public void setATerminal(String ATerminal) {
        this.ATerminal.set(ATerminal);
    }
}
