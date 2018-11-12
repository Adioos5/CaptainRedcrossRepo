package containers;

import drawers.CheckBreatheDrawer;
import drawers.MapDrawer;
import drawers.SearchDrawer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class FrameContainer extends JFrame{

    private MapDrawer panel;
    private SearchDrawer search;
    private CheckBreatheDrawer checkBreath;
    private JPanel mainPanel;


    public FrameContainer(int [][]map, int [][]searchMap,ImageContainer images) throws IOException, URISyntaxException {
        panel = new MapDrawer(map,images);
        search = new SearchDrawer(searchMap,images);
        checkBreath = new CheckBreatheDrawer(images);

        mainPanel = new JPanel(new CardLayout());

        mainPanel.add(panel, "MapDrawer");
        mainPanel.add(search, "SearchDrawer");
        mainPanel.add(checkBreath, "CheckBreatheDrawer");



        setSize(1280,680);
        setTitle("Captain Redcross");
        setLocationRelativeTo(null);
        setIconImage(images.getGameIcon());

        add(mainPanel);

    }

    public void createFrame(){
        setVisible(true);
    }

}
