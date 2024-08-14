import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JPanel MainPanel;
    private JButton button1;

    public Main() {
        setContentPane(MainPanel);
        setTitle("Sistema de Reserva de Passagens Aéreas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
    }

    public static void main(String[] args) {

        Voo novovoo1 = new Voo ("Voo01", "Hell de Janeiro", "Tokyo", 500);
        Voo novovoo2 = new Voo ("Voo02", "Praia Grande", "Seul", 150);



        novovoo1.realizarReserva(5);
        novovoo1.realizarPagamento("ida e volta", true);
        novovoo1.imprimirpassagem();


        novovoo2.realizarReserva(10);
        novovoo2.realizarPagamento("ida", false);
        novovoo2.imprimirpassagem();






    }

    private void createUIComponents() {

    }
}