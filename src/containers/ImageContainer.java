package containers;

import java.awt.image.BufferedImage;

public class ImageContainer {

    private BufferedImage gameIcon;
    private BufferedImage victimImg;
    private BufferedImage victim1Img;
    private BufferedImage victim2Img;
    private BufferedImage victim3Img;
    private BufferedImage waterImg;
    private BufferedImage wallImg;
    private BufferedImage grassImg;
    private BufferedImage pavementImg;
    private BufferedImage rocksImg;
    private BufferedImage rockiesImg;

    public ImageContainer(BufferedImage gameIcon, BufferedImage victimImg, BufferedImage victim1Img, BufferedImage victim2Img, BufferedImage victim3Img, BufferedImage waterImg, BufferedImage wallImg, BufferedImage grassImg, BufferedImage pavementImg, BufferedImage rocksImg, BufferedImage rockiesImg) {
        this.gameIcon = gameIcon;
        this.victimImg = victimImg;
        this.victim1Img = victim1Img;
        this.victim2Img = victim2Img;
        this.victim3Img = victim3Img;
        this.waterImg = waterImg;
        this.wallImg = wallImg;
        this.grassImg = grassImg;
        this.pavementImg = pavementImg;
        this.rocksImg = rocksImg;
        this.rockiesImg = rockiesImg;
    }

    public BufferedImage getGameIcon() {
        return gameIcon;
    }

    public void setGameIcon(BufferedImage gameIcon) {
        this.gameIcon = gameIcon;
    }

    public BufferedImage getVictimImg() {
        return victimImg;
    }

    public void setVictimImg(BufferedImage victimImg) {
        this.victimImg = victimImg;
    }

    public BufferedImage getVictim1Img() {
        return victim1Img;
    }

    public void setVictim1Img(BufferedImage victim1Img) {
        this.victim1Img = victim1Img;
    }

    public BufferedImage getVictim2Img() {
        return victim2Img;
    }

    public void setVictim2Img(BufferedImage victim2Img) {
        this.victim2Img = victim2Img;
    }

    public BufferedImage getVictim3Img() {
        return victim3Img;
    }

    public void setVictim3Img(BufferedImage victim3Img) {
        this.victim3Img = victim3Img;
    }

    public BufferedImage getWaterImg() {
        return waterImg;
    }

    public void setWaterImg(BufferedImage waterImg) {
        this.waterImg = waterImg;
    }

    public BufferedImage getWallImg() {
        return wallImg;
    }

    public void setWallImg(BufferedImage wallImg) {
        this.wallImg = wallImg;
    }

    public BufferedImage getGrassImg() {
        return grassImg;
    }

    public void setGrassImg(BufferedImage grassImg) {
        this.grassImg = grassImg;
    }

    public BufferedImage getPavementImg() {
        return pavementImg;
    }

    public void setPavementImg(BufferedImage pavementImg) {
        this.pavementImg = pavementImg;
    }

    public BufferedImage getRocksImg() {
        return rocksImg;
    }

    public void setRocksImg(BufferedImage rocksImg) {
        this.rocksImg = rocksImg;
    }

    public BufferedImage getRockiesImg() {
        return rockiesImg;
    }

    public void setRockiesImg(BufferedImage rockiesImg) {
        this.rockiesImg = rockiesImg;
    }




}
