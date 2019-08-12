public class NoQuarterState implements State {
    transient GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You insert a quarter");
        gumballMachine.setState(gumballMachine.getHasQuaterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You havn't insert a Quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no Quarter");
    }

    @Override
    public void dispense() {
        System.out.println("you need pay first");
    }
}
