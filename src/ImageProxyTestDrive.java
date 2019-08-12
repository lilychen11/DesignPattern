import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

public class ImageProxyTestDrive {
    ImageComponent imageComponent;
    JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
    Hashtable cds = new Hashtable();

    public static void main(String[] args) throws Exception{
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }
    public ImageProxyTestDrive() throws Exception{
        cds.put("Ambient:Music for Airpots","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565611435585&di=f699d96452a1f39576e834658b70916b&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D2579479985%2C2142466729%26fm%3D214%26gp%3D0.jpg");
        cds.put("Ima","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1565611468329&di=6395988e692f0588b2c7fde87e30c0e2&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D1110513793%2C2234445526%26fm%3D214%26gp%3D0.jpg");
        URL initialURL = new URL((String)cds.get("Ambient:Music for Airpots"));
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        for (Enumeration e = cds.keys();e.hasMoreElements();){
            String name = (String) e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    imageComponent.setIcon(new ImageProxy(getCDUrl(e.getActionCommand())));
                    frame.repaint();
                }
            });
        }
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    URL getCDUrl(String name){
        try {
            return new URL((String)cds.get(name));
        }catch (MalformedURLException e){
            e.printStackTrace();
            return null;
        }
    }
}
