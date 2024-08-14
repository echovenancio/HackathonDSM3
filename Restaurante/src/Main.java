import model.Pedido;
import model.Restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel MainPanel;
    private JButton novoPedidoButton;
    private JTable table1;
    private Restaurante restuarante = new Restaurante();

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