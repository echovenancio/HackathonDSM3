import javax.swing.*;

public class Main extends JFrame {
    private JPanel MainPanel;

    public Main() {
        setContentPane(MainPanel);
        setTitle("Sistema de Pedidos em Restaurante");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}