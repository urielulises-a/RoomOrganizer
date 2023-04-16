import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Objeto extends JLabel implements MouseListener, MouseMotionListener {

    final static int ANCHOL = 100;
    final static int ALTOL = 100;
    int posX, posY;
    int grupo;
    private Caja caja;
    boolean mousePresionado;
    int localCounter;

    public Objeto() {

        posX = (int) (Math.random() * 1200);
        posY = (int) (Math.random() * 400);
        localCounter = 0;

        setBounds(posX, posY, ANCHOL, ALTOL);
        addMouseListener(this);
        addMouseMotionListener(this);

    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }
    public void objetoEnCaja(boolean siObjetoSobreCaja){

        if (siObjetoSobreCaja){

            setLocation(100000, 100000);
        }
    }
    public void reset() {
        posX = (int) (Math.random() * 1200);
        posY = (int) (Math.random() * 400);
        localCounter = 0;
        setLocation(posX, posY);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        mousePresionado = true;
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        mousePresionado = false;
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        if (mousePresionado){

            int deltaX = event.getXOnScreen() - getLocationOnScreen().x - ANCHOL / 2; // Cambio relativo en X
            int deltaY = event.getYOnScreen() - getLocationOnScreen().y - ALTOL / 2; // Cambio relativo en Y
            setLocation(getX() + deltaX, getY() + deltaY); // Actualizar la posición del componente
        }
        // Verificar si el objeto está dentro de la Caja
        if (getBounds().intersects(caja.getBounds())){

            objetoEnCaja(true);

            /*Debido a que cada clase tiene su propio local counter que inicia en 0 si se rebasa dicha cantidad por
            el tiempo que pase el mouse sobre el objeto solo se va a poder sumar 1 por cada componente en pantalla*/

            if(localCounter < 1){

                caja.objetosEnCaja++;
                caja.puntaje+= (Math.random() * 500);
            }

            localCounter++;
        }
        else{

            objetoEnCaja(false);
        }

    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {


    }

    @Override
    public void mouseClicked(MouseEvent event) {
    }
}
