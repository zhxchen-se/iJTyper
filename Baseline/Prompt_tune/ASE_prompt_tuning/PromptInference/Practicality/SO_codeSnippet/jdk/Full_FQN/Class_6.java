/**
 * // @see http://stackoverflow.com/q/3066590/230513
 * 15-Mar-2011 r8 http://stackoverflow.com/questions/5274962
 * 26-Mar-2013 r17 per comment
 */
public class Class_6 implements java.lang.Runnable {
  public static void main(java.lang.String[] args) {
    java.awt.EventQueue.invokeLater(java.lang.Runnable)
  }

  @java.lang.Override
  public void run() {
    javax.swing.JFrame f = new javax.swing.JFrame();
    javax.swing.JFrame.setDefaultCloseOperation(int)
    java.awt.Container.add(java.awt.Component)
    java.awt.Window.pack()
    java.awt.Window.setLocationRelativeTo(java.awt.Component)
    java.awt.Window.setVisible(boolean)
  }
}/**
 * Control panel
 */
class Control extends javax.swing.JPanel {
  private Class_.Model model;

  private Class_.View view;

  private javax.swing.JButton reset = new javax.swing.JButton("Reset");

  public Control(Class_.Model model, Class_.View view) {
    this.model = model;
    this.view = view;
    java.awt.Container.add(java.awt.Component)
    javax.swing.AbstractButton.addActionListener(java.awt.event.ActionListener)
  }

  private class ButtonHandler implements java.awt.event.ActionListener {
    @java.lang.Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
      java.lang.String cmd = java.awt.event.ActionEvent.getActionCommand();
      if (java.lang.String.equals(java.lang.Object)) {
        Class_.Model.reset()
      }
    }
  }
}class MainPanel extends javax.swing.JPanel {
  public MainPanel() {
    javax.swing.JPanel.javax.swing.JPanel(java.awt.LayoutManager)
    Class_.Model model = new Class_.Model();
    Class_.View view = new Class_.View(model);
    Class_.Control control = new Class_.Control(model, view);
    javax.swing.JLabel label = new javax.swing.JLabel("Guess what color!", javax.swing.JLabel.CENTER);
    java.awt.Container.add(java.awt.Component,java.lang.Object)
    java.awt.Container.add(java.awt.Component,java.lang.Object)
    java.awt.Container.add(java.awt.Component,java.lang.Object)
  }
}/**
 * Model
 */
class Model extends java.util.Observable {
  private static final java.util.Random rnd = new java.util.Random();

  private static final Class_.Piece[] pieces = Class_.Piece.values();

  private Class_.Piece hidden = Class_.Model.init();

  private Class_.Piece init() {
    return Class_.Model.pieces[java.util.Random.nextInt(int)];
  }

  public void reset() {
    hidden = Class_.Model.init();
    java.util.Observable.setChanged()
    java.util.Observable.notifyObservers()
  }

  public void check(Class_.Piece guess) {
    java.util.Observable.setChanged()
    java.util.Observable.notifyObservers(java.lang.Object)
  }
}enum Piece {

  Red(java.awt.Color.red),
  Green(java.awt.Color.green),
  Blue(java.awt.Color.blue);
  public java.awt.Color color;

  private Piece(java.awt.Color color) {
    this.color = color;
  }
}/**
 * View
 */
class View extends javax.swing.JPanel {
  private static final java.lang.String s = "Click a button.";

  private Class_.Model model;

  private Class_.View.ColorIcon icon = new Class_.View.ColorIcon(80, java.awt.Color.gray);

  private javax.swing.JLabel label = new javax.swing.JLabel(Class_.View.s, icon, javax.swing.JLabel.CENTER);

  public View(Class_.Model model) {
    javax.swing.JPanel.javax.swing.JPanel(java.awt.LayoutManager)
    this.model = model;
    javax.swing.JLabel.setVerticalTextPosition(int)
    javax.swing.JLabel.setHorizontalTextPosition(int)
    java.awt.Container.add(java.awt.Component,java.lang.Object)
    java.awt.Container.add(java.awt.Component,java.lang.Object)
    java.util.Observable.addObserver(java.util.Observer)
  }

  private javax.swing.JPanel genButtonPanel() {
    javax.swing.JPanel panel = new javax.swing.JPanel();
    for (Class_.Piece p : Class_.Piece.values()) {
      Class_.View.PieceButton pb = new Class_.View.PieceButton(p);
      javax.swing.AbstractButton.addActionListener(java.awt.event.ActionListener)
      java.awt.Container.add(java.awt.Component)
    }
    return panel;
  }

  private class ModelObserver implements java.util.Observer {
    @java.lang.Override
    public void update(java.util.Observable o, java.lang.Object arg) {
      if (arg == null) {
        javax.swing.JLabel.setText(java.lang.String)
        icon.color = java.awt.Color.gray;
      } else if (((java.lang.Boolean) (arg))) {
        javax.swing.JLabel.setText(java.lang.String)
      } else {
        javax.swing.JLabel.setText(java.lang.String)
      }
    }
  }

  private class ButtonHandler implements java.awt.event.ActionListener {
    @java.lang.Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
      Class_.View.PieceButton pb = java.util.EventObject.getSource();
      icon.color = pb.piece.color;
      java.awt.Component.repaint()
      Class_.Model.check(Class_.Piece)
    }
  }

  private static class PieceButton extends javax.swing.JButton {
    Class_.Piece piece;

    public PieceButton(Class_.Piece piece) {
      this.piece = piece;
      javax.swing.AbstractButton.setIcon(javax.swing.Icon)
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
      java.awt.Graphics2D.setRenderingHint(java.awt.RenderingHints$Key,java.lang.Object)
      java.awt.Graphics.setColor(java.awt.Color)
      java.awt.Graphics.fillOval(int,int,int,int)
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
