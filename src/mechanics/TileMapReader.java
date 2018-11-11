package mechanics;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TileMapReader {

    private int type;
    private URL mapFileUrl;


    public TileMapReader(int type) {
        this.type = type;
    }

    public int[][] readMap() {
        List<String> lines = readFile();
        return convertListToArray(lines);
    }

    private List<String> readFile() {
        List<String> lines = new ArrayList<>();
        if (type == 1) {
            mapFileUrl = ClassLoader.getSystemResource("maps/gameMap.txt");
        }
        if (type == 2) {
            mapFileUrl = ClassLoader.getSystemResource("maps/searchMap.txt");
        }
        try {
            lines = Files.readAllLines(Paths.get(mapFileUrl.toURI()));
        } catch (IOException e) {
            System.err.println(e);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private int[][] convertListToArray(List<String> lines) {
        int maxSize = getMaxSize(lines);
        int[][] map = new int[maxSize][lines.size()];

        for (int i = 0; i < lines.size(); i++) {
            char[] charArray = lines.get(i).toCharArray();

            for (int k = 0; k < maxSize; k++) {
                if (k >= charArray.length) {
                    map[k][i] = 6;
                } else {
                    map[k][i] = Character.getNumericValue(charArray[k]);
                }
            }
        }
        return map;
    }

    private int getMaxSize(List<String> lines) {
        int maxSize = 0;

        for (String line : lines) {
            if (line.length() > maxSize) {
                maxSize = line.length();
            }
        }
        return maxSize;
    }
}