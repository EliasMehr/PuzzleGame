import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class GameBoard extends JFrame implements ActionListener {
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
        addActionListener();

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

    // Find the index of the empty tile.
    public int getEmptyTilePosition() {
        int position = 0;
        for (Tile tile : tileList) {
            if (tile.getTileID() == 16) {
                position = tileList.indexOf(tile);
            }
        }
        return position;
    }

    // Adding action listeners to every tile in our game.
    public void addActionListener() {
        for (Tile tile : tileList) {
            if (tile instanceof Tile) {
                tile.getTiles().addActionListener(l -> {
                    System.out.println(tileList.indexOf(tile));
                    moveTile(tile);
                });
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // receives the clicked tile switches with the blank tile (IF the blank tile is in the right index on the list)
    public void moveTile(Tile clickedTile) {
        switch (tileList.lastIndexOf(clickedTile)) {
            case 0:
                for (Tile tile : tileList) {
                    if (tile.getTileID() == 16) {
                        Collections.swap(tileList, 0, getEmptyTilePosition());
                        renderTiles(tileList);
                        tilePanel.updateUI();
                    }
                }
        }
    }
}


