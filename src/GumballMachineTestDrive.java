import java.rmi.Naming;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        int i = 1;
        GumballMachineRemote gumballMachine = null;
        int count;
        if (args.length < 3){
            System.out.println("GumballMachine <name><inventory><index>");
            System.exit(1);
        }
        try {
            count  = Integer.parseInt(args[1]);
            gumballMachine = new GumballMachine(args[0], count);
            Naming.rebind("//"+args[0]+"/gumballmachine"+args[2],gumballMachine);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
