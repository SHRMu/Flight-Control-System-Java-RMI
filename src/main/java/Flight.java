
import java.io.Serializable;

public class Flight implements Serializable {

    private static final long serialVersionUID = 1829933276009626326L;

    String IATAcode = null; //LH
    String OperatingName = null; //Lufthansa
    String AircraftModel = null; //A380
    String Flightnumber = null; //591
    String Departure= null; //TK
    String Arrival = null; //FRA
    String DTerminal = null;
    String ATernimal = null;

    String Origindate = null;
    String AScheduleddatetime = null;
    String Agate = null;
    String AEstimateddatetime  = null;
    String DScheduleddatetime = null;
    String Dgate = null;
    String DEstimateddatetime  = null;
    String Checkinlocation = null;
    String Checkincouter = null;
    String StartCheckindateandtime = null;
    String EndCheckindateandtime = null;
    String[] Flightstatus = {"B","D","I","L","M","S","X","Y","Z"};
    String FlightStatus = null;

    public Flight(String IATAcode, String OperatingName, String AircraftModel, String Flightnumber, String Departure,
                  String Arrival, String DTerminal, String ATerminal) {
        this.IATAcode = IATAcode;
        this.OperatingName = OperatingName;
        this.AircraftModel = AircraftModel;
        this.Flightnumber = Flightnumber;
        this.Departure = Departure;
        this.Arrival = Arrival;
        this.DTerminal = DTerminal;
        this.ATernimal = ATerminal;
    }

    public Flight(String iATAcode, String operatingName, String aircraftModel, String flightnumber, String departure,
                  String arrival, String aTernimal, String origindate, String aScheduleddatetime, String agate,
                  String aEstimateddatetime, String dScheduleddatetime, String dTernimal, String dgate,
                  String dEstimateddatetime, String checkinlocation, String checkincouter, String checkindateandtime,
                  String endCheckindateandtime,String flightStatus) {
        super();
        IATAcode = iATAcode;
        OperatingName = operatingName;
        AircraftModel = aircraftModel;
        Flightnumber = flightnumber;
        Departure = departure;
        Arrival = arrival;
        ATernimal = aTernimal;
        Origindate = origindate;
        AScheduleddatetime = aScheduleddatetime;
        Agate = agate;
        AEstimateddatetime = aEstimateddatetime;
        DScheduleddatetime = dScheduleddatetime;
        DTerminal = dTernimal;
        Dgate = dgate;
        DEstimateddatetime = dEstimateddatetime;
        Checkinlocation = checkinlocation;
        Checkincouter = checkincouter;
        StartCheckindateandtime = checkindateandtime;
        //Flightstatus = flightstatus;
        //FlightStatus = flightStatus2;
        EndCheckindateandtime = endCheckindateandtime;
        this.FlightStatus = flightStatus;
    }

    public Flight() {}

}
