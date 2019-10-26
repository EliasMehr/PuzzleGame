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
                    checkIfEmptyTileIsAdjacent(tile);
                });
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // takes an index parameter and swaps the tile in that index with the empty tile.
    public void moveTile(int index) {
        Collections.swap(tileList, index, getEmptyTilePosition());
        renderTiles(tileList);
        tilePanel.updateUI();
        checkIfGameWon();
    }

    // receives the clicked tile and checks if blank tile is adjacent via indexes. Calls on moveTile and sends index.
    public void checkIfEmptyTileIsAdjacent(Tile clickedTile) {
        switch (tileList.lastIndexOf(clickedTile)) {
            case 0:
                if (tileList.get(4).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(0);
                } else if (tileList.get(1).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(0);
                }
                break;
            case 1:
                if (tileList.get(0).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(1);
                } else if (tileList.get(2).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(1);
                } else if (tileList.get(5).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(1);
                }
                break;
            case 2:
                if (tileList.get(1).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(2);
                } else if (tileList.get(3).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(2);
                } else if (tileList.get(6).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(2);
                }
                break;
            case 3:
                if (tileList.get(2).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(3);
                } else if (tileList.get(7).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(3);
                }
                break;
            case 4:
                if (tileList.get(0).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(4);
                } else if (tileList.get(5).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(4);
                } else if (tileList.get(8).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(4);
                }
                break;
            case 5:
                if (tileList.get(1).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(5);
                } else if (tileList.get(6).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(5);
                } else if (tileList.get(4).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(5);
                } else if (tileList.get(9).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(5);
                }
                break;
            case 6:
                if (tileList.get(2).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(6);
                } else if (tileList.get(7).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(6);
                } else if (tileList.get(10).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(6);
                } else if (tileList.get(5).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(6);
                }
                break;
            case 7:
                if (tileList.get(3).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(7);
                } else if (tileList.get(6).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(7);
                } else if (tileList.get(11).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(7);
                }
                break;
            case 8:
                if (tileList.get(12).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(8);
                } else if (tileList.get(4).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(8);
                } else if (tileList.get(9).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(8);
                }
                break;
            case 9:
                if (tileList.get(5).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(9);
                } else if (tileList.get(10).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(9);
                } else if (tileList.get(8).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(9);
                } else if (tileList.get(13).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(9);
                }
                break;
            case 10:
                if (tileList.get(6).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(10);
                } else if (tileList.get(11).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(10);
                } else if (tileList.get(9).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(10);
                } else if (tileList.get(14).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(10);
                }
                break;
            case 11:
                if (tileList.get(7).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(11);
                } else if (tileList.get(10).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(11);
                } else if (tileList.get(15).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(11);
                }
                break;
            case 12:
                if (tileList.get(8).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(12);
                } else if (tileList.get(13).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(12);
                }
                break;
            case 13:
                if (tileList.get(12).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(13);
                } else if (tileList.get(9).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(13);
                } else if (tileList.get(14).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(13);
                }
                break;
            case 14:
                if (tileList.get(13).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(14);
                } else if (tileList.get(10).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(14);
                } else if (tileList.get(15).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(14);
                }
                break;
            case 15:
                if (tileList.get(11).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(15);
                } else if (tileList.get(14).equals(tileList.get(getEmptyTilePosition()))) {
                    moveTile(15);
                }
                break;

        }
    }

    public void checkIfGameWon() {
        int correctlyPlacedTile = 0;
        int tileID = 1;
        int i = 0;
        for (Tile tile : tileList) {
            if (tile.getTileID() == tileID && tileList.get(i) == tile){
                tileID++;
                i++;
                correctlyPlacedTile++;
                if (correctlyPlacedTile == 15)
                    System.out.println("You win");
            }
        }
    }
}



