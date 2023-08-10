@java.lang.SuppressWarnings("serial")
public class Class_1 {
  private static void createBinaryApplet() throws java.io.IOException {
    java.applet.Applet applet = new java.applet.Applet() {
      @java.lang.Override
      public void paint(java.awt.Graphics g) {
        java.awt.Container.paint(java.awt.Graphics)
        java.awt.Graphics.fillRect(int,int,int,int)
      }
    };
    java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("applet.dat"));
    java.io.ObjectOutputStream.writeObject(java.lang.Object)
    java.io.ObjectOutputStream.close()
  }

  public static void main(java.lang.String[] args) {
    final java.awt.Frame frame = new java.awt.Frame("Applet Test");
    java.awt.Window.addWindowListener(java.awt.event.WindowListener)
    final int prefHeight = 50;
    final int prefWidth = 50;
    java.awt.Container container = new java.awt.Container() {
      @java.lang.Override
      public void paint(java.awt.Graphics g) {
        java.awt.Container.paint(java.awt.Graphics)
        java.awt.Graphics2D graphs = ((java.awt.Graphics2D) (g));
        java.awt.Graphics2D.setBackground(java.awt.Color)
        java.awt.Graphics.clearRect(int,int,int,int)
        java.awt.Graphics.setColor(java.awt.Color)
        java.awt.Graphics.fillRect(int,int,int,int)
      }
    };
    java.awt.Component.setPreferredSize(java.awt.Dimension)
    java.awt.Container.add(java.awt.Component)
    java.awt.Window.pack()
    java.awt.Window.setVisible(boolean)
    java.awt.image.BufferedImage bufImage = new java.awt.image.BufferedImage(prefWidth, prefHeight, java.awt.image.BufferedImage.TYPE_INT_RGB);
    java.awt.Container.paint(java.awt.Graphics)
    try {
      Class_.Class_1.createBinaryApplet()
      java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream("applet.dat"));
      java.applet.Applet applet = java.io.ObjectInputStream.readObject();
      java.io.ObjectInputStream.close()
      java.awt.Container.add(java.awt.Component)
      java.awt.Component.setBounds(int,int,int,int)
      java.applet.Applet.init()
      java.awt.Graphics g = java.awt.Component.getGraphics();
      java.awt.Graphics.drawImage(java.awt.Image,int,int,java.awt.image.ImageObserver)
      java.awt.Container.paint(java.awt.Graphics)
    } catch (java.lang.ClassNotFoundException | java.io.IOException e) {
      java.io.PrintStream.println(java.lang.String)
    }
  }
}
