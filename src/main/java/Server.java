
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server implements IFlightServer{

    private static IFlightServer stub;

    //login clients stub
    private List<ClientStub> clientStubs = new ArrayList<>();
    //flights
    private List<Flight> flights;

    
    public Server() {
        flights = new ArrayList<>();
        Flight flight = new Flight("LH","Lufthansa","A380","591","TK","FRA","1","3");
        flights.add(flight);
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            stub = (IFlightServer) UnicastRemoteObject.exportObject(server, 8889);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("FlightServer", stub);
            System.err.println("JAVA RMI :: Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public boolean login(String clientName, IFlightClient client) throws RemoteException {
        if (!clientStubs.stream().filter(clientStub -> clientStub.name.equals(clientName)).findFirst().isPresent()){
            Registry registry = LocateRegistry.getRegistry();
            try {
                registry.bind(clientName, client);
            }catch (AlreadyBoundException e){
                e.printStackTrace();
            }
            clientStubs.add(new ClientStub(clientName, client));
            System.out.println(clientName + " login, welcome !!! ");
            //push flights information to client
            client.receiveListOfFlights(flights);
            return true;
        }else
            return false;
    }

    @Override
    public void logout(String clientName) {
        for (int i = 0; i < clientStubs.size(); i++) {
            if (clientName.equals(clientStubs.get(i).name)){
                clientStubs.remove(i);
                System.out.println(clientName + " logout, bye :( ");
                break;
            }
        }
    }

    @Override
    public void updateFlight(String clientName, Flight flight){
        System.out.println(clientName + " try to update Flight Info with Flightnumber >>> "+ flight.Flightnumber);
        for (int i = 0; i < this.flights.size(); i++) {
            if (flights.get(i).Flightnumber.equals(flight.Flightnumber)){
                flights.remove(i);
                break;
            }
        }
        flights.add(flight);
        clientStubs.forEach(clientStub -> {
            try {
                clientStub.stub.receiveUpdatedFlight(flight,false);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        });
//        System.out.println("flights size after update has been changed to  : "+ flights.size());
//        flights.forEach(item->{
//            System.out.println(item.Flightnumber);
//        });
    }

    @Override
    public void deleteFlight(String clientName, Flight flight){
        clientStubs.forEach(clientStub -> {
            try {
                clientStub.stub.receiveUpdatedFlight(flight,true);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        });
    }
}
