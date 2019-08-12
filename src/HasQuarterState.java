import java.util.Random;

public class HasQuarterState implements State {
     Random random = new Random(System.currentTimeMillis());

    transient GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quater returned");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = random.nextInt(10);
        gumballMachine.setState(gumballMachine.getSoldState());
        if (winner == 0  && gumballMachine.getCount() >1){
            gumballMachine.setState(gumballMachine.getWinnerState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
