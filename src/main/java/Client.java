
import javafx.application.Application;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Client extends UnicastRemoteObject implements Serializable, IFlightClient{

    private static final long serialVersionUID = -1534124262342076502L;

    private String name;

    Client(String name) throws RemoteException {
        this.name = name;
    }

    public static IFlightServer stub;
    public static List<Flight> flights;
    public static MainWin mainWin;

    public static void main(String[] args){
        try{
            Registry registry = LocateRegistry.getRegistry();
            stub =(IFlightServer) registry.lookup("FlightServer");
            Client demo = new Client("demo");
            if (stub.login(demo.name, demo)){
                MainWin.stub = stub;
                MainWin.flights = flights;
                MainWin.clientName = demo.name;
                Application.launch(MainWin.class);
            }
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public void receiveListOfFlights(List<Flight> flights){
        System.out.println("client :: "+ this.name +" receiveListOfFlights by starting");
        this.flights = flights;
    }

    @Override
    public void receiveUpdatedFlight(Flight flight, boolean deleted){
        System.out.println("client :: "+ this.name +" receiveUpdatedFlight with Flightnumber >>> "+flight.Flightnumber);
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).Flightnumber.equals(flight.Flightnumber)){
                flights.remove(0);
                break;
            }
        }
        if (!deleted){
            flights.add(flight);
        }
        mainWin.getInstance().mainController.setFlightTable(flights);
    }
}
