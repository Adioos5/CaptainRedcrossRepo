package drawers;

import containers.ImageContainer;

import javax.swing.*;
import java.awt.*;

public class CheckBreatheDrawer extends JPanel {

    private ImageContainer images;

    public CheckBreatheDrawer(ImageContainer images) {
        this.images = images;
    }

    public void paint(Graphics g) {

        //background
        g.setColor(Color.cyan);
        g.fillRect(0,0,1280,680);

    }
}
