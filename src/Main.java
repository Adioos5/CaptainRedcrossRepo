import containers.FrameContainer;
import containers.ImageContainer;
import mechanics.TileMapReader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    private static BufferedImage grass;
    private static BufferedImage pavement;
    private static BufferedImage rockies;
    private static BufferedImage water;
    private static BufferedImage rocks;
    private static BufferedImage victim;
    private static BufferedImage victim1;
    private static BufferedImage victim2;
    private static BufferedImage victim3;
    private static BufferedImage wall;
    private static BufferedImage gameIcon;

    private static int[][] map;
    private static int[][] searchMap;

    public static void main(String[] args) throws IOException, URISyntaxException {
        readImages();
    }

    public static void readImages() throws URISyntaxException, IOException {
        rocks = ImageIO.read(new File(ClassLoader.getSystemResource("images/kamienie.jpg").toURI()));
        water = ImageIO.read(new File(ClassLoader.getSystemResource("images/woda.jpg").toURI()));
        victim = ImageIO.read(new File(ClassLoader.getSystemResource("images/searching.png").toURI()));
        victim1 = ImageIO.read(new File(ClassLoader.getSystemResource("images/onlyHandSleeveCut.png").toURI()));
        victim2 = ImageIO.read(new File(ClassLoader.getSystemResource("images/victimWithCutSleeve.png").toURI()));
        victim3 = ImageIO.read(new File(ClassLoader.getSystemResource("images/victimWithHandSleeveAndLegSleeve.png").toURI()));
        wall = ImageIO.read(new File(ClassLoader.getSystemResource("images/ściana.jpg").toURI()));
        rockies = ImageIO.read(new File(ClassLoader.getSystemResource("images/kamyczki.jpg").toURI()));
        pavement = ImageIO.read(new File(ClassLoader.getSystemResource("images/kostka.jpg").toURI()));
        grass = ImageIO.read(new File(ClassLoader.getSystemResource("images/trawa.jpg").toURI()));
        gameIcon = ImageIO.read(new File(ClassLoader.getSystemResource("images/game icon.jpeg").toURI()));

        readMaps();
    }

    public static void readMaps() throws IOException, URISyntaxException {
        map = new TileMapReader(1).readMap();
        searchMap= new TileMapReader(2).readMap();


        initializeFrame();
    }

    public static void initializeFrame() throws IOException, URISyntaxException {
        new FrameContainer(map, searchMap, new ImageContainer(gameIcon,victim,victim1,victim2,victim3,water,wall,grass,pavement,rocks,rockies)).createFrame();
    }
}
