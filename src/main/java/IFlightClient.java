import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IFlightClient extends Remote {

    void receiveListOfFlights(List<Flight> flights) throws RemoteException;

    void receiveUpdatedFlight(Flight flight, boolean deleted) throws RemoteException;

}
