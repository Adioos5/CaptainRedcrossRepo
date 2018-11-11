package drawers;

import containers.ImageContainer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;

public class SearchDrawer extends JPanel {

    private int tileSize = 128;
    int[][] map;
    private ImageContainer images;

    public SearchDrawer(int[][] map, ImageContainer images) throws IOException, URISyntaxException {
        this.map = map;
        this.images = images;
    }

    public void paint(Graphics g) {

        //background
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < getMapHeight(map); j++) {

                g.drawImage(images.getPavementImg(), i * tileSize, j * tileSize, tileSize, tileSize, null);
            }
        }
        //victim
        g.drawImage(images.getVictimImg(),130,30,1100,600,null);

        g.setColor(Color.WHITE);
        g.drawOval(560,70,150,150);

        g.drawOval(540,210,60,60);

    }
    private int getMapHeight(int[][] tileMap) {
        return tileMap[0].length;
    }
}
