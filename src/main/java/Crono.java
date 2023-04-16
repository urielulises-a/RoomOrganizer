import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crono extends JComponent implements ActionListener {
    private int tiempoRestante;
    private final Timer timer;

    public Crono(int minutos) {
        tiempoRestante = minutos * 60;
        timer = new Timer(1000, this);
        timer.start();
        setBounds(1200, 50, 360, 30);
    }
    public void reiniciar(int minutos) {
        tiempoRestante = minutos * 40;
        timer.restart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tiempoRestante > 0) {
            tiempoRestante--;
            repaint();
        } else {
            timer.stop();
        }
    }
    private String getTiempoFormateado() {
        int minutos = tiempoRestante / 60;
        int segundos = tiempoRestante % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.drawString(getTiempoFormateado(), getX(), getY());

    }

    public int getTiempoRestante(){

        return tiempoRestante;
    }
}
