import javax.swing.*;


public class Main extends JFrame {

    Ventana ventana = new Ventana();

    public Main(){

        add(ventana);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.setVisible(true);

    }
}