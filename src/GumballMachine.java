import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    State soldOutSate;
    State soldState;
    State hasQuaterState;
    State noQuaterState;
    State winnerState;

    State state;
    int count = 0;
    String location;

    public GumballMachine(String location, int count) throws RemoteException {
        this.count = count;
        this.location = location;
        soldOutSate = new SoldOutState(this);
        soldState = new SoldState(this);
        hasQuaterState = new HasQuarterState(this);
        noQuaterState = new NoQuarterState(this);
        winnerState = new WinnerState(this);
        if (count > 0) {
            state = noQuaterState;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot");
        if (count!= 0){
            --count;
        }
    }

    public State getSoldOutSate() {
        return soldOutSate;
    }

    public void setSoldOutSate(State soldOutSate) {
        this.soldOutSate = soldOutSate;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public State getHasQuaterState() {
        return hasQuaterState;
    }

    public void setHasQuaterState(State hasQuaterState) {
        this.hasQuaterState = hasQuaterState;
    }

    public State getNoQuaterState() {
        return noQuaterState;
    }

    public void setNoQuaterState(State noQuaterState) {
        this.noQuaterState = noQuaterState;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String getLocation(){
        return location;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public State getWinnerState() {
        return winnerState;
    }

    public void setWinnerState(State winnerState) {
        this.winnerState = winnerState;
    }
}
