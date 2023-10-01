/**
 * Create a screenshot of a component.
 *
 * @author Andrew Thompson
 */
class ComponentImageCapture {
  static final java.lang.String HELP = "Type Ctrl-0 to get a screenshot of the current GUI.\n" + ("The screenshot will be saved to the current " + "directory as 'screenshot.png'.");

  public static java.awt.image.BufferedImage getScreenShot(java.awt.Component component) {
    java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(java.awt.Component.getWidth(), java.awt.Component.getHeight(), java.awt.image.BufferedImage.TYPE_INT_RGB);
    java.awt.Component.paint(java.awt.Graphics)
    return image;
  }

  public static void main(java.lang.String[] args) {
    java.lang.Runnable r = new java.lang.Runnable() {
      public void run() {
        final javax.swing.JFrame f = new javax.swing.JFrame("Test Screenshot");
        javax.swing.JMenuItem screenshot = new javax.swing.JMenuItem("Screenshot");
        javax.swing.JMenuItem.setAccelerator(javax.swing.KeyStroke)
        javax.swing.AbstractButton.addActionListener(java.awt.event.ActionListener)
        javax.swing.JMenu menu = new javax.swing.JMenu("Other");
        javax.swing.JMenu.add(javax.swing.JMenuItem)
        javax.swing.JMenuBar mb = new javax.swing.JMenuBar();
        javax.swing.JMenuBar.add(javax.swing.JMenu)
        javax.swing.JFrame.setJMenuBar(javax.swing.JMenuBar)
        javax.swing.JPanel p = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        javax.swing.JComponent.setBorder(javax.swing.border.Border)
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        javax.swing.JFrame.setContentPane(java.awt.Container)
        java.awt.Window.pack()
        java.awt.Window.setLocationRelativeTo(java.awt.Component)
        javax.swing.JFrame.setDefaultCloseOperation(int)
        java.awt.Window.setVisible(boolean)
      }
    };
    javax.swing.SwingUtilities.invokeLater(java.lang.Runnable)
  }
}
