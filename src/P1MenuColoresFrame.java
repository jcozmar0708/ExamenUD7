import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P1MenuColoresFrame {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Menu Colores");
        ventana.setSize(600, 600);

        JPanel panel = new JPanel();
        ventana.add(panel);

        JMenuBar menuBar = new JMenuBar();
        JMenu colores = new JMenu("Colores");
        JMenuItem rojo = new JMenuItem("Rojo");
        rojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               panel.setBackground(Color.RED);
            }
        });
        JMenuItem verde = new JMenuItem("Verde");
        verde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.GREEN);
            }
        });
        JMenuItem azul = new JMenuItem("Azul");
        azul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.BLUE);
            }
        });
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        colores.add(rojo);
        colores.add(verde);
        colores.add(azul);
        colores.addSeparator();
        colores.add(salir);

        menuBar.add(colores);
        ventana.setJMenuBar(menuBar);

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
