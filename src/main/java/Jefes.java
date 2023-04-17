import javax.swing.*;
import java.awt.*;

public final class Jefes extends Objeto{

    static int subCategoria;
    public Jefes(Caja caja) {

        super();
        grupo+= 3;
        setCaja(caja);
        subCategoria++;

        setIcon(new ImageIcon(new ImageIcon("src/main/resources/" + (grupo) + "/" + subCategoria + ".png")
                .getImage().getScaledInstance(ANCHOL, ALTOL, Image.SCALE_SMOOTH)));

        addMouseListener(this);
        addMouseMotionListener(this);

    }
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        if (dificultad) {

            graphics.setColor(Color.white);
            graphics.drawString(String.valueOf(valor), 55, getHeight() - 20);
        }
    }
}
