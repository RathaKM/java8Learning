package java8.method.reference;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.function.Function;
import java.util.function.Supplier;


public class TestMethodRef {

    public static void main(String args[]) {
        Frame f = new Frame();
        Button btnOk = new Button("Ok");
        f.add(btnOk);
        Button btnCancel = new Button("Cancel");
        f.add(btnCancel);
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

        //using static method reference
        //btnOk.addActionListener(System.out::println);//will print event object
        btnOk.addActionListener(TestMethodRef::printSource);

        //using instance method and constructor reference
        Supplier<MethodRef> supplier = MethodRef::new; //Need a functional interface here
        MethodRef mr = supplier.get();
        btnCancel.addActionListener(mr::print);

        //Use Function<String, MethodRef> if the constructor has a parameter
        Function<String, MethodRef> function = MethodRef::new;
        MethodRef mrc = function.apply("e.getSource()");
        btnCancel.addActionListener(mrc::print);
    }

    public static void printSource(ActionEvent e) {
        System.out.println("Event Source name: "+e.getActionCommand());
    }
}

class MethodRef {

    String label;

    public MethodRef() {
        this.label =  "Event Source: ";
    }

    public MethodRef(String label) {
        this.label =  label;
    }

    public void print(ActionEvent e) {
        System.out.println(label + ":" + e.getSource());
    }
}