import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard extends JFrame {
    private int tileID = 1;
    private int width = 600;
    private int height = 600;
    private List<Tile> tileList;

    Utilities utilities = new Utilities();

    ImageIcon logoType = new ImageIcon("src/LOGOTYPE/logotype.png");
    JLabel logotypeLabel = new JLabel(logoType);
    JPanel logotypePanel = new JPanel();
    JPanel tilePanel = new JPanel();

    GameBoard() {
        GridLayout brickGridLayout = new GridLayout(4, 4);
        brickGridLayout.setHgap(0);
        brickGridLayout.setVgap(0);

        FlowLayout logoLayout = new FlowLayout();
        logoLayout.setHgap(0);
        logoLayout.setVgap(0);

        add(logotypePanel, BorderLayout.NORTH);
        add(tilePanel, BorderLayout.CENTER);

        logotypePanel.add(logotypeLabel);
        logotypePanel.setLayout(logoLayout);
        tilePanel.setLayout(brickGridLayout);

        // Graphic engine
        tileList = initiateTiles();
        shuffleTiles(tileList);
        renderTiles(tileList);

        utilities.startBackgroundMusic("src/SFX/bgMusic.wav");

        setTitle("15 Puzzle Game by Elias & Valle");
        setSize(width, height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Initiating the tiles and giving correct imageIcon, ID and creating JButtons
    public List<Tile> initiateTiles() {
        List<Tile> tiles = new ArrayList();
        for (int i = 0; i < 16; i++) {
            Tile createdTile = new Tile(new JButton(new ImageIcon("src/GFX/brick" + tileID + ".png")), tileID);
            tileID++;
            tiles.add(createdTile);
        }
        return tiles;
    }

    // Renders the Tiles onMouseActionEvent and repaints to JPanel after an update!
    public void renderTiles(List<Tile> tiles) {
        tiles.forEach(tile -> {
            tilePanel.add(tile.getTiles());
        });
    }

    // Shuffle the Tiles after TileInitiate
    public void shuffleTiles(List<Tile> list) {
        Collections.shuffle(list);
    }
}
