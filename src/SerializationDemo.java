import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("Duck.out");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        WildTurkey tt = new WildTurkey();
        tt.setName("STurkey");
        oout.writeObject(tt);
        oout.close();
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object turkey = oin.readObject();
        System.out.println(turkey);
    }
}
