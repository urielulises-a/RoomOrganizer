import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public final class Caja extends JLabel implements MouseListener{

    final static int ANCHOC = 200;
    final static int ALTOC = 200;
    static int cajas;
    int posX;
    int grupo;
    int puntaje ;
    int objetosEnCaja;
    int counter;
    boolean mousePresionado;
    boolean siMouseEnCaja;
    public Caja(int grupo, int counter) {

        puntaje = 0;
        this.grupo = grupo;
        this.counter = counter;
        posX = (ANCHOC + 90) * cajas;

        setIcon(new ImageIcon(new ImageIcon("src/main/resources/box.png")
                .getImage().getScaledInstance(ANCHOC, ALTOC, Image.SCALE_SMOOTH)));

        setBounds(posX, 768 - 270, ANCHOC, ALTOC);
        addMouseListener(this);
        cajas++;
    }

    @Override
    public void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        graphics.setColor(Color.WHITE);

        switch (counter) {
            case 1 -> graphics.drawString("Personajes " + objetosEnCaja, 55, getHeight() - 20);
            case 2 -> graphics.drawString("Enemigos " + objetosEnCaja, 55, getHeight() - 20);
            case 3 -> graphics.drawString("Jefes " + objetosEnCaja, 75, getHeight() - 20);
            case 4 -> graphics.drawString("Items " + objetosEnCaja, 75, getHeight() - 20);
            case 5 -> graphics.drawString("Amigos " + objetosEnCaja, 75, getHeight() - 20);
            default -> {

            }
        }

    }
    public void reset(){
        puntaje = 0;
        posX = (ANCHOC + 90) * cajas;
        objetosEnCaja = 0;
        counter = 0;

        addMouseListener(this);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        mousePresionado = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePresionado = false;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        if (mousePresionado) siMouseEnCaja = true;

    }

    @Override
    public void mouseExited(MouseEvent e) {

        siMouseEnCaja = false;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
}
