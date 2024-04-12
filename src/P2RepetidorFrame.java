import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P2RepetidorFrame {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("2 repeticiones");
        ventana.setSize(300,300);
        ventana.setLayout(new GridLayout(2,1));

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnDecrementar = new JButton("-1");
        btnDecrementar.setEnabled(false);
        JButton btnIncrementar = new JButton("+1");
        panelBotones.add(btnDecrementar);
        panelBotones.add(btnIncrementar);
        ventana.add(panelBotones);

        JPanel panelTexto = new JPanel(new GridLayout(2,2));
        JLabel lblEntrada = new JLabel("Entrada: ",JLabel.RIGHT);
        JTextField txtEntrada = new JTextField();
        JLabel lblSalida = new JLabel("Salida: ",JLabel.RIGHT);
        JTextField txtSalida = new JTextField();
        panelTexto.add(lblEntrada);
        panelTexto.add(txtEntrada);
        panelTexto.add(lblSalida);
        panelTexto.add(txtSalida);
        ventana.add(panelTexto);

        btnDecrementar.addActionListener(new DecrementarActionListener(btnIncrementar,ventana));
        btnIncrementar.addActionListener(new IncrementarActionListener(btnDecrementar,ventana));

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class IncrementarActionListener implements ActionListener {
    JButton btn;
    JFrame ventana;

    public IncrementarActionListener(JButton btn, JFrame ventana) {
        this.btn = btn;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnIncrementar = (JButton) e.getSource();
        int num_repeticiones = Integer.parseInt(ventana.getTitle().split(" ")[0]);
        if (num_repeticiones < 5) {
            num_repeticiones++;
            ventana.setTitle(num_repeticiones + " repeticiones");
            btnIncrementar.setEnabled(num_repeticiones < 5);
            btn.setEnabled(num_repeticiones > 2);
        }
    }
}

class DecrementarActionListener implements ActionListener {
    JButton btn;
    JFrame ventana;

    public DecrementarActionListener(JButton btn, JFrame ventana) {
        this.btn = btn;
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnDecrementar = (JButton) e.getSource();
        int num_repeticiones = Integer.parseInt(ventana.getTitle().split(" ")[0]);
        if (num_repeticiones > 2) {
            num_repeticiones--;
            ventana.setTitle(num_repeticiones + " repeticiones");
            btnDecrementar.setEnabled(num_repeticiones > 2);
            btn.setEnabled(num_repeticiones < 5);
        }
    }
}