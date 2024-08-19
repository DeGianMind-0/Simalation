import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;

class GamePanel extends JPanel implements ActionListener {
    private GameBoard board;
    private Timer timer;

    public GamePanel(GameBoard board) {
        this.board = board;
        this.timer = new Timer(1000, this);
        this.timer.start();
        setupMouseListeners();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Entity entity : board.getEntities()) {
            g.setColor(entity.getColor());
            g.fillOval(entity.getX(), entity.getY(), Entity.ENTITY_SIZE, Entity.ENTITY_SIZE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        board.update();
        repaint();
    }

    private void setupMouseListeners() {
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                updateHoveredEntity(e.getPoint());
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
//                hoveredEntity = null;
                setToolTipText(null);
            }
        });
    }

    private void updateHoveredEntity(Point p) {
        for (Entity entity : board.getEntities()) {
            if (contains(entity, p)) {
//                hoveredEntity = entity;
                setToolTipText(entity.getTooltipText());
                return;
            }
        }
//        hoveredEntity = null;
        setToolTipText(null);
    }

    private boolean contains(Entity entity, Point p) {
        return p.x >= entity.x && p.x < entity.x + Entity.ENTITY_SIZE && p.y >= entity.y && p.y < entity.y + Entity.ENTITY_SIZE;
    }

}
