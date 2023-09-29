class WhereToPutTheGui {
  public static void initGui() {
    for (int ii = 1; ii < 4; ii++) {
      javax.swing.JFrame f = new javax.swing.JFrame("Frame " + ii);
      javax.swing.JFrame.setDefaultCloseOperation(int)
      java.lang.String s = (("os.name: " + java.lang.System.getProperty(java.lang.String)) + "\nos.version: ") + java.lang.System.getProperty(java.lang.String);
      java.awt.Container.add(java.awt.Component)
      java.awt.Window.pack()
      java.awt.Window.setLocationByPlatform(boolean)
      java.awt.Window.setVisible(boolean)
    }
  }

  public static void main(java.lang.String[] args) {
    javax.swing.SwingUtilities.invokeLater(java.lang.Runnable)
  }
}
