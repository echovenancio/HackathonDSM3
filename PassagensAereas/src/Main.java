import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        setTitle("Sistema de Reserva de Passagens Aéreas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}