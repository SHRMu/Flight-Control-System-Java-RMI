## Flight-Control-System-Java-RMI

+ IFlightServer 
```aidl
boolean login(String clientName, IFlightClient client) throws RemoteException;
void logout(String clientName) throws RemoteException;
void updateFlight(String clientName, Flight flight) throws RemoteException;
void deleteFlight(String clientName, Flight flight) throws RemoteException;
```
+ IFlightClient 
```aidl
void receiveListOfFlights(List<Flight> flights) throws RemoteException;
void receiveUpdatedFlight(Flight flight, boolean deleted) throws RemoteException;
```

![mainPanel](https://github.com/SHRMu/Flight-Control-System-Java-RMI/blob/master/images/mainPanel.png ''mainPanel'')
![subPanel](https://github.com/SHRMu/Flight-Control-System-Java-RMI/blob/master/images/subPanel.png ''subPanel'')
