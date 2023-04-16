import javax.swing.*;
import java.awt.*;

public final class Items extends Objeto{

    static int subCategoria = 9;

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
}
