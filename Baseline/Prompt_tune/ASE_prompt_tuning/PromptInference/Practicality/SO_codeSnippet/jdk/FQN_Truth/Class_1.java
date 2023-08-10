@java.lang.SuppressWarnings("serial")
public class Class_1 {
    private static void createBinaryApplet() throws java.io.IOException {
        java.applet.Applet applet = new java.applet.Applet() {
            @java.lang.Override
            public void paint(java.awt.Graphics g) {
                super.paint(g);
                g.fillRect(0, 0, 10, 10);
            }
        };
        java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream("applet.dat"));
        oos.writeObject(applet);
        oos.close();
    }

    public static void main(java.lang.String[] args) {
        final java.awt.Frame frame = new java.awt.Frame("Applet Test");
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent we) {
                frame.dispose();
            }
        });
        final int prefHeight = 50;
        final int prefWidth = 50;
        java.awt.Container container = new java.awt.Container() {
            @java.lang.Override
            public void paint(java.awt.Graphics g) {
                super.paint(g);
                java.awt.Graphics2D graphs = ((java.awt.Graphics2D) (g));
                graphs.setBackground(java.awt.Color.WHITE);
                graphs.clearRect(0, 0, prefWidth, prefHeight);
                g.setColor(java.awt.Color.RED);
                g.fillRect(5, 5, 10, 10);
            }
        };
        container.setPreferredSize(new java.awt.Dimension(prefWidth, prefHeight));
        frame.add(container);
        frame.pack();
        frame.setVisible(true);
        java.awt.image.BufferedImage bufImage = new java.awt.image.BufferedImage(prefWidth, prefHeight, java.awt.image.BufferedImage.TYPE_INT_RGB);
        container.paint(bufImage.createGraphics());
        try {
            Class_.Class_1.createBinaryApplet();
            java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream("applet.dat"));
            java.applet.Applet applet = ((java.applet.Applet) (ois.readObject()));
            ois.close();
            container.add(applet);
            applet.setBounds(0, 0, prefWidth, prefHeight);
            applet.init();
            java.awt.Graphics g = applet.getGraphics();
            g.drawImage(bufImage, 0, 0, applet);
            applet.paint(g);
        } catch (java.lang.ClassNotFoundException | java.io.IOException e) {
            java.lang.System.out.println("Whoops");
        }
    }
}

