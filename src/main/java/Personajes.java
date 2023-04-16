import javax.swing.*;
import java.awt.*;

public final class Personajes extends Objeto{

    static int subCategoria;

    public Personajes(Caja caja) {
        super();
        setCaja(caja);
        grupo+= 1;
        subCategoria++;

        setIcon(new ImageIcon(new ImageIcon("src/main/resources/" + (grupo) + "/" + subCategoria + ".png")
                .getImage().getScaledInstance(ANCHOL, ALTOL, Image.SCALE_SMOOTH)));


        addMouseListener(this);
        addMouseMotionListener(this);

    }

}
