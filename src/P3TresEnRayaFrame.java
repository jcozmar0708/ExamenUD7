import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P3TresEnRayaFrame {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Tres en raya");
        ventana.setSize(500,500);
        ventana.setLayout(new BorderLayout());

        String[] casillas = {
                "1","2","3",
                "4","5","6",
                "7","8","9"
        };
        JPanel panel = new JPanel(new GridLayout(3,3));

        JLabel lblTurno = new JLabel("Turno del jugador X",JLabel.CENTER);
        lblTurno.setFont(lblTurno.getFont().deriveFont(20.0f));
        ventana.add(lblTurno,BorderLayout.PAGE_END);

        for (String s : casillas) {
            JButton btn = new JButton(s);
            btn.addActionListener(new TurnoActionListener(lblTurno));
            btn.setFont(btn.getFont().deriveFont(30.0f));
            panel.add(btn);
        }
        ventana.add(panel,BorderLayout.CENTER);

        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class TurnoActionListener implements ActionListener {
    JLabel turno;

    public TurnoActionListener(JLabel turno) {
        this.turno = turno;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String turnoJugador = this.turno.getText().split(" ")[3];
        switch (turnoJugador) {
            case "X":
                btn.setText("X");
                btn.setEnabled(false);
                turno.setText("Turno del jugador O");
                break;
            case "O":
                btn.setText("O");
                btn.setEnabled(false);
                turno.setText("Turno del jugador X");
                break;
        }
    }
}