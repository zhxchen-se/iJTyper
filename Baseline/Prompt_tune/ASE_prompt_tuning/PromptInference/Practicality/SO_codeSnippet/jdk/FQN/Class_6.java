/**
 *
 */
public class Class_6 implements java.lang.Runnable {
    public static void main(java.lang.String[] args) {
        java.awt.EventQueue.invokeLater(new Class_.Class_6());
    }

    @java.lang.Override
    public void run() {
        javax.swing.JFrame f = new javax.swing.JFrame();
        f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        f.add(new Class_.MainPanel());
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

/**
 * Control panel
 */
class Control extends javax.swing.JPanel {
    private Class_.Model model;

    private Class_.View view;

    private javax.swing.JButton reset = new javax.swing.JButton("Reset");

    public Control(Class_.Model model, Class_.View view) {
        this.model = model;
        this.view = view;
        this.add(reset);
        reset.addActionListener(new Class_.Control.ButtonHandler());
    }

    private class ButtonHandler implements java.awt.event.ActionListener {
        @java.lang.Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            java.lang.String cmd = e.getActionCommand();
            if ("Reset".equals(cmd)) {
                model.reset();
            }
        }
    }
}

class MainPanel extends javax.swing.JPanel {
    public MainPanel() {
        super(new java.awt.BorderLayout());
        Class_.Model model = new Class_.Model();
        Class_.View view = new Class_.View(model);
        Class_.Control control = new Class_.Control(model, view);
        javax.swing.JLabel label = new javax.swing.JLabel("Guess what color!", javax.swing.JLabel.CENTER);
        this.add(label, java.awt.BorderLayout.NORTH);
        this.add(view, java.awt.BorderLayout.CENTER);
        this.add(control, java.awt.BorderLayout.SOUTH);
    }
}

/**
 * Model
 */
class Model extends java.util.Observable {
    private static final java.util.Random rnd = new java.util.Random();

    private static final Class_.Piece[] pieces = Class_.Piece.values();

    private Class_.Piece hidden = init();

    private Class_.Piece init() {
        return Class_.Model.pieces[Class_.Model.rnd.nextInt(Class_.Model.pieces.length)];
    }

    public void reset() {
        hidden = init();
        setChanged();
        notifyObservers();
    }

    public void check(Class_.Piece guess) {
        setChanged();
        notifyObservers(guess.equals(hidden));
    }
}

enum Piece {

    Red(java.awt.Color.red),
    Green(java.awt.Color.green),
    Blue(java.awt.Color.blue);
    public java.awt.Color color;

    private Piece(java.awt.Color color) {
        this.color = color;
    }
}

/**
 * View
 */
class View extends javax.swing.JPanel {
    private static final java.lang.String s = "Click a button.";

    private Class_.Model model;

    private Class_.View.ColorIcon icon = new Class_.View.ColorIcon(80, java.awt.Color.gray);

    private javax.swing.JLabel label = new javax.swing.JLabel(Class_.View.s, icon, javax.swing.JLabel.CENTER);

    public View(Class_.Model model) {
        super(new java.awt.BorderLayout());
        this.model = model;
        label.setVerticalTextPosition(javax.swing.JLabel.BOTTOM);
        label.setHorizontalTextPosition(javax.swing.JLabel.CENTER);
        this.add(label, java.awt.BorderLayout.CENTER);
        this.add(genButtonPanel(), java.awt.BorderLayout.SOUTH);
        model.addObserver(new Class_.View.ModelObserver());
    }

    private javax.swing.JPanel genButtonPanel() {
        javax.swing.JPanel panel = new javax.swing.JPanel();
        for (Class_.Piece p : Class_.Piece.values()) {
            Class_.View.PieceButton pb = new Class_.View.PieceButton(p);
            pb.addActionListener(new Class_.View.ButtonHandler());
            panel.add(pb);
        }
        return panel;
    }

    private class ModelObserver implements java.util.Observer {
        @java.lang.Override
        public void update(java.util.Observable o, java.lang.Object arg) {
            if (arg == null) {
                label.setText(Class_.View.s);
                icon.color = java.awt.Color.gray;
            } else if (((java.lang.Boolean) (arg))) {
                label.setText("Win!");
            } else {
                label.setText("Keep trying.");
            }
        }
    }

    private class ButtonHandler implements java.awt.event.ActionListener {
        @java.lang.Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            Class_.View.PieceButton pb = ((Class_.View.PieceButton) (e.getSource()));
            icon.color = pb.piece.color;
            label.repaint();
            model.check(pb.piece);
        }
    }

    private static class PieceButton extends javax.swing.JButton {
        Class_.Piece piece;

        public PieceButton(Class_.Piece piece) {
            this.piece = piece;
            this.setIcon(new Class_.View.ColorIcon(16, piece.color));
        }
    }

    private static class ColorIcon implements javax.swing.Icon {
        private int size;

        private java.awt.Color color;

        public ColorIcon(int size, java.awt.Color color) {
            this.size = size;
            this.color = color;
        }

        @java.lang.Override
        public void paintIcon(java.awt.Component c, java.awt.Graphics g, int x, int y) {
            java.awt.Graphics2D g2d = ((java.awt.Graphics2D) (g));
            g2d.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color);
            g2d.fillOval(x, y, size, size);
        }

        @java.lang.Override
        public int getIconWidth() {
            return size;
        }

        @java.lang.Override
        public int getIconHeight() {
            return size;
        }
    }
}

