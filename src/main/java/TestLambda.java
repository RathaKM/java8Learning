import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TestLambda {

    public static void main(String args[]) {
        Frame f = new Frame();
        Button btnOk = new Button("Ok");
        f.add(btnOk);
        //Button btnCancel = new Button("Cancel");
        //f.add(btnCancel);
        f.setVisible(true);
        f.setSize(400, 400);
        f.setLayout(new FlowLayout());

        //using anonymous class
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        /*
            btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button is clicked!");
            }
            });
        */
        //using Lambda
        ActionListener btnListener = e -> System.out.println("Button is clicked!");
        btnOk.addActionListener(btnListener);
        //btnCancel.addActionListener(btnListener);


    }
}
