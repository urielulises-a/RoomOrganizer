import javax.swing.*;
import java.awt.*;

public final class Items extends Objeto{

    static int subCategoria;
    public Items(Caja caja) {

        super();
        setCaja(caja);
        grupo+= 4;
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
