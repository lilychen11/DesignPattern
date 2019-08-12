import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
            String[] location = {"rmi://santafe.mightygumball.com/gumballmachine1",
                    "rmi://boulder.mightygumball.com/gumballmachine2",
                    "rmi://seattle.mightygumball.com/gumballmachine3"};
       // String[] location = {"rmi://127.0.0.1/gumballmachine"};
        GumballMonitor[] monitors = new GumballMonitor[location.length];
        for (int i = 0; i < location.length; i++) {
            try {
                GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
                monitors[i]= new GumballMonitor(machine);
            } catch (NotBoundException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        for (GumballMonitor monitor : monitors)
            monitor.report();
    }
}
