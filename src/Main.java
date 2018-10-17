import javax.swing.*;
import java.awt.*;
import Sapper.Box;
import Sapper.Coord;
import Sapper.Ranges;

public class Main extends JFrame {

    private JPanel panel;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int IMAGE_SIZE = 50;

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        Ranges.setSize(new Coord(COLS, ROWS));
        setImage();
        initPanel();
        initFrame();
    }

    private void initFrame() {
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sapper");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(getImage("icon"));
    }

    private void initPanel() {
        panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord: Ranges.getAllCoords()) {

                    g.drawImage((Image) Box.BOMB.image, coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * IMAGE_SIZE, Ranges.getSize().y * IMAGE_SIZE ));
        add(panel);
    }

    private Image getImage(String name){
        String filename = "img/" + name.toLowerCase() + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

    private void setImage(){
        for (Box box: Box.values())
            box.image = getImage(box.name());
    }
}
