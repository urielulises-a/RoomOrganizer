import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public final class Ventana extends JPanel {

    final static int ANCHO = 1360;
    final static int ALTO = 768;
    final static int limitePersonajes = 3;
    final static int limiteCajas = 5;


    Objeto[] personajes;
    Objeto[] enemigos;
    Objeto[] jefes;
    Objeto[] items;
    Objeto[] amigos;
    Caja[] cajas;
    Crono crono;
    int puntajeFinalPartida;
    boolean tiempoTerminado;
    BufferedImage backGround;

    public Ventana(){

        setPreferredSize(new Dimension(ANCHO, ALTO));

        tiempoTerminado = false;

        crono = new Crono(1);
        tiempoTerminado = false;

        try {
            backGround = ImageIO.read(new File("src/main/resources/background.png"));
        } catch (IOException event) {
            event.getLocalizedMessage();
        }

        cajas = new Caja[limiteCajas];

        for (int i = 0; i < limiteCajas; i++) {

            cajas[i] = new Caja(i + 1, i + 1);

            add(cajas[i]);

        }

        personajes = new Personajes[limitePersonajes];
        enemigos = new Enemigos[limitePersonajes];
        jefes = new Jefes[limitePersonajes];
        items = new Items[limitePersonajes];
        amigos = new Amigos[limitePersonajes];

        for (int i = 0; i < limitePersonajes; i++) {

            personajes[i] = new Personajes(cajas[0]);
            enemigos[i] = new Enemigos(cajas[1]);
            jefes[i] = new Jefes(cajas[2]);
            items[i] = new Items(cajas[3]);
            amigos[i] = new Amigos(cajas[4]);

            add(enemigos[i]);
            add(personajes[i]);
            add(jefes[i]);
            add(items[i]);
            add(amigos[i]);

        }

        for (int i = 0; i < limitePersonajes; i++) {
            for (int j = 0; j < limiteCajas; j++) {

                personajes[i].objetoEnCaja(cajas[j].siMouseEnCaja);
                enemigos[i].objetoEnCaja(cajas[j].siMouseEnCaja);
                jefes[i].objetoEnCaja(cajas[j].siMouseEnCaja);
                items[i].objetoEnCaja(cajas[j].siMouseEnCaja);
                amigos[i].objetoEnCaja(cajas[j].siMouseEnCaja);
            }

        }

        setLayout(null);
    }
    public void paintComponent(Graphics graphics){

        graphics.drawImage(backGround,  0, 0, ANCHO, ALTO, null);

        graphics.setColor(Color.white);

        int puntajeTotal = 0;

        for (int i = 0; i < limiteCajas; i++) {
            puntajeTotal+= cajas[i].puntaje;
        }

        puntajeFinalPartida = puntajeTotal;

        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));

        graphics.drawString("Puntaje total: " + puntajeTotal, 50, 50);
        crono.paintComponent(graphics);
        if (crono.getTiempoRestante() <= 0 && !tiempoTerminado) {
            tiempoTerminado = true;
            mostrarVentanaEmergente();
        }

    }
    public void mostrarVentanaEmergente() {
        // Código para abrir la ventana emergente con el mensaje y opciones de continuar o salir
        int opcion = JOptionPane.showOptionDialog(this, "¿Desea continuar con otra partida?", "Partida terminada. Puntaje Total:" + puntajeFinalPartida, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (opcion == JOptionPane.YES_OPTION) {
            // Lógica para reiniciar el juego y comenzar una nueva partida
            reiniciarJuego();
        } else {
            // Lógica para salir del juego
            System.exit(0);
        }
    }
    private void reiniciarJuego() {
        // Lógica para reiniciar el juego
        crono.reiniciar(1); // Reiniciar el cronómetro
        // Resetear puntajes y posiciones de objetos en el juego
        for (Caja caja : cajas) {
            caja.reset();
        }
        for (int i = 0; i < limitePersonajes; i++) {
            personajes[i].reset();
            enemigos[i].reset();
            jefes[i].reset();
            items[i].reset();
            amigos[i].reset();

        }
        // Repintar la ventana para comenzar una nueva partida
        repaint();
        tiempoTerminado = false; // Establecer tiempoTerminado a false para futuras partidas
    }


}
