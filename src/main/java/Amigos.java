import javax.swing.*;
import java.awt.*;

public final class Amigos extends Objeto{

    static int subCategoria = 12;
    public Amigos(Caja caja) {
        super();
        setCaja(caja);
        grupo+= 5;
        subCategoria++;

        setIcon(new ImageIcon(new ImageIcon("src/main/resources/" + (grupo) + "/" + subCategoria + ".png")
                .getImage().getScaledInstance(ANCHOL, ALTOL, Image.SCALE_SMOOTH)));

        addMouseListener(this);
        addMouseMotionListener(this);

    }
}
