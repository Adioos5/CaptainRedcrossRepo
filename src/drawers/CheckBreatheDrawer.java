package drawers;

import containers.ImageContainer;
import containers.NumbersContainer;
import elements.MoveableText;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class CheckBreatheDrawer extends JPanel implements ActionListener, KeyListener {

    private ImageContainer images;
    private List<Integer> listOfNumbers;
    private List<MoveableText> listOfMoveableTexts;
    private int delay = 2;
    private Timer timer;
    private boolean isRequestFocusSent = false;
    private Rectangle hitLine;
    private boolean showTip = true;
    private boolean playable = true;

    public CheckBreatheDrawer(ImageContainer images) {
        this.images = images;

        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
        setRequestFocusEnabled(true);
        addKeyListener(this);

        listOfNumbers = new NumbersContainer().getListOfNumbers();
        listOfMoveableTexts = new ArrayList<>();
        hitLine = new Rectangle(639, 60, 2, 60);

        int i = 8;
        for (Integer number : listOfNumbers) {
            listOfMoveableTexts.add(new MoveableText(String.valueOf(number), 150 * i, 100, Color.WHITE, "neutral"));
            i++;
        }

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        //background
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 1280, 680);

        if(playable) {
            //numbers
            g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 35));

            for (MoveableText text : listOfMoveableTexts) {
                g.setColor(text.getColor());
                g.drawString(text.getText(), text.getX(), text.getY());
            }

            //hitLine
            g.setColor(Color.white);
            g.fillRect((int) hitLine.getX(), (int) hitLine.getY(), (int) hitLine.getWidth(), (int) hitLine.getHeight());

            //info
            if (showTip) {
                g.setColor(Color.white);
                g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 40));
                g.drawString("Click \"SPACE\" when numbers encounter the line", 100, 300);
            }
        } else {
            g.setColor(Color.white);
            g.setFont(new Font("Monospaced", Font.TYPE1_FONT, 45));
            g.drawString("Victim is breathing", 410, 300);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (SceneObserver.currentScene.equals("checkBreathe")) {
            if (!isRequestFocusSent) {
                requestFocusInWindow();
                isRequestFocusSent = true;
            }
            timer.start();
            repaint();
            if(playable) {
                for (MoveableText text : listOfMoveableTexts) {
                    text.setX(text.getX() - 4);
                    if ((text.getX() + text.getText().length() * 22) < hitLine.getX() && text.getStatus().equals("neutral")) {
                        text.setColor(Color.red);
                    }
                }
            }
            if(listOfMoveableTexts.get(listOfMoveableTexts.size()-1).getX()+(listOfMoveableTexts.get(listOfMoveableTexts.size()-1).getText().length() * 22)<(hitLine.getX())){
                playable = false;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_W){
            SceneObserver.currentScene = "game";
            CardLayout cardLayout = (CardLayout) getParent().getLayout();
            cardLayout.show(getParent(), "MapDrawer");

        }


        if (SceneObserver.currentScene.equals("checkBreathe")) {
            for (MoveableText text : listOfMoveableTexts) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && new Rectangle(text.getX(), text.getY() - 40, text.getText().length() * 22, 40).intersects(hitLine)) {
                    showTip = false;
                    text.setColor(Color.green);
                    text.setStatus("clicked");
                }
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
