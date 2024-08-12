import javax.swing.*;

public class Main extends JFrame {
    public Main() {
        setTitle("Sistema de Treinamento em Tecnologia");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}