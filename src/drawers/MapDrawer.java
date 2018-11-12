package drawers;

import containers.ActionsContainer;
import containers.ImageContainer;
import npc.Victim;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.List;


public class MapDrawer extends JPanel implements ActionListener, KeyListener, MouseListener, MouseMotionListener {

    private int[][] map;
    private static final int tileSize = 64;
    private ImageContainer images;

    private Rectangle firstActionArea;
    private Rectangle secondActionArea;
    private Rectangle thirdActionArea;

    private List<String> actions;

    private BufferedImage bufferedImage;

    private Boolean moveUp = false;
    private Boolean moveDown = false;
    private Boolean moveRight = false;
    private Boolean moveLeft = false;
    private Boolean printWarning = false;

    private Boolean isRequestFocusSent= false;
    private int playerX = 1000;
    private int playerY = 500;
    private int playerSpeed = 5;
    private int delay = 5;

    private Rectangle playerFeet;
    private Rectangle mouse;

    private Victim victim1;

    private Timer timer;

    public MapDrawer(int[][] map, ImageContainer images) {
        this.map = map;
        this.images = images;

        setFocusTraversalKeysEnabled(false);
        setFocusable(true);

        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        victim1 = new Victim("Unconscious", Color.yellow, new Rectangle(200, 250, 100, 50), Color.green);
        actions = new ActionsContainer(1).getAllActions();

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        //background
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < getMapHeight(map); j++) {
                if (map[i][j] == 0) {
                    bufferedImage = images.getGrassImg();
                }
                if (map[i][j] == 1) {
                    bufferedImage = images.getPavementImg();
                }
                if (map[i][j] == 2) {
                    bufferedImage = images.getRockiesImg();
                }
                if (map[i][j] == 3) {
                    bufferedImage = images.getWaterImg();
                }
                if (map[i][j] == 4) {
                    bufferedImage = images.getRocksImg();
                }
                g.drawImage(bufferedImage, i * tileSize, j * tileSize, tileSize, tileSize, null);
            }
        }


        //player
        g.setColor(Color.red);
        g.fillRect(playerX, playerY, 50, 100);

        //victim1
        g.setColor(victim1.getVictimColor());
        g.fillRect((int) victim1.getVictim().getX(), (int) victim1.getVictim().getY(), (int) victim1.getVictim().getWidth(), (int) victim1.getVictim().getHeight());

        //victim1sState
        g.setColor(victim1.getStatusColor());
        g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 15));
        g.drawString(victim1.getStatus(), (int) victim1.getVictim().getX(), (int) victim1.getVictim().getY() - 20);

        //steppingOnAVictimWarning
        if (printWarning) {
            g.setColor(Color.white);
            g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 45));
            g.drawString("You're stepping on a victim!", 300, 90);
        }

        //actions
        if (playerFeet.intersects(victim1.getVictimArea())) {
            if (actions.size() >= 1) {
                //firstAction
                g.setColor(Color.black);
                g.fillRect(playerX + 70, playerY - 40, 100, 30);

                g.setColor(Color.white);
                g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 12));
                g.drawString(actions.get(0), centerTextVertically(100, actions.get(0)), playerY - 21);
            }
            if (actions.size() >= 2) {
                //secondAction
                g.setColor(Color.black);
                g.fillRect(playerX + 70, playerY, 100, 30);

                g.setColor(Color.white);
                g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 12));
                g.drawString(actions.get(1), centerTextVertically(100, actions.get(1)), playerY + 19);
            }
            if (actions.size() >= 3) {
                //thirdAction
                g.setColor(Color.black);
                g.fillRect(playerX + 70, playerY + 40, 100, 30);

                g.setColor(Color.white);
                g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 12));
                g.drawString(actions.get(2), centerTextVertically(100, actions.get(2)), playerY + 59);
            }
        }

        g.dispose();
    }

    private int getMapHeight(int[][] tileMap) {
        return tileMap[0].length;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (SceneObserver.currentScene.equals("game")) {
            if (!isRequestFocusSent) {
                requestFocusInWindow();
                isRequestFocusSent = true;
            }

            timer.start();
            repaint();
            onUpdate();

            if (moveUp) {
                playerY -= playerSpeed;
            }

            if (moveDown) {
                playerY += playerSpeed;
            }

            if (moveRight) {
                playerX += playerSpeed;
            }

            if (moveLeft) {
                playerX -= playerSpeed;
            }

            if (playerFeet.intersects(victim1.getVictim())) {
                printWarning = true;
            } else {
                printWarning = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_W)
            moveUp = true;

        if (e.getKeyCode() == KeyEvent.VK_S)
            moveDown = true;

        if (e.getKeyCode() == KeyEvent.VK_D)
            moveRight = true;

        if (e.getKeyCode() == KeyEvent.VK_A)
            moveLeft = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W)
            moveUp = false;

        if (e.getKeyCode() == KeyEvent.VK_S)
            moveDown = false;

        if (e.getKeyCode() == KeyEvent.VK_D)
            moveRight = false;

        if (e.getKeyCode() == KeyEvent.VK_A)
            moveLeft = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        manageClickedAction();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouse = new Rectangle(e.getX(), e.getY(), 1, 1);

    }

    public int centerTextVertically(int boxWidth, String text) {
        return (int) (playerX + 70 + ((boxWidth - (text.length() * 7)) * 0.5));
    }

    public void onUpdate() {
        firstActionArea = new Rectangle(playerX + 70, playerY - 40, 100, 30);
        secondActionArea = new Rectangle(playerX + 70, playerY, 100, 30);
        thirdActionArea = new Rectangle(playerX + 70, playerY + 40, 100, 30);

        playerFeet = new Rectangle(playerX, playerY + 90, 50, 10);
    }

    public void changeScene(String actionText) {

        switch (actionText) {
            case "Check Breathe":
                SceneObserver.currentScene = "checkBreathe";
                isRequestFocusSent = false;
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "CheckBreatheDrawer");

                break;
            case "Search":
                SceneObserver.currentScene = "search";

                CardLayout cardLayout1 = (CardLayout) getParent().getLayout();
                cardLayout1.show(getParent(), "SearchDrawer");

                break;
            case "Right Pos":

                break;
            case "Use NRC":

                break;
            default:
        }
    }

    public void manageClickedAction() {

        String actionText = null;

        if (mouse.intersects(firstActionArea) && playerFeet.intersects(victim1.getVictimArea()) && actions.size() >= 1) {
            actionText = actions.get(0);
            actions.remove(0);
        }
        if (mouse.intersects(secondActionArea) && playerFeet.intersects(victim1.getVictimArea()) && actions.size() >= 2) {
            actionText = actions.get(1);
            actions.remove(1);
        }
        if (mouse.intersects(thirdActionArea) && playerFeet.intersects(victim1.getVictimArea()) && actions.size() >= 3) {
            actionText = actions.get(2);
            actions.remove(2);
        }

        if (actionText != null)
            changeScene(actionText);

    }

}