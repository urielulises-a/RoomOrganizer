import javax.swing.*;
import java.awt.*;

public final class Enemigos extends Objeto{

    static int subCategoria = 3;
    public Enemigos(Caja caja) {
        super();
        setCaja(caja);
        grupo+= 2;
        subCategoria++;

        setIcon(new ImageIcon(new ImageIcon("src/main/resources/" + (grupo) + "/" + subCategoria + ".png")
                .getImage().getScaledInstance(ANCHOL, ALTOL, Image.SCALE_SMOOTH)));

        addMouseListener(this);
        addMouseMotionListener(this);

    }
}
