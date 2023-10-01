
class ComponentImageCapture {
    static final java.lang.String HELP = "Type Ctrl-0 to get a screenshot of the current GUI.\n" + ("The screenshot will be saved to the current " + "directory as 'screenshot.png'.");

    public static java.awt.image.BufferedImage getScreenShot(java.awt.Component component) {
        java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(component.getWidth(), component.getHeight(), java.awt.image.BufferedImage.TYPE_INT_RGB);

        component.paint(image.getGraphics());

        return image;
    }

    public static void main(java.lang.String[] args) {
        java.lang.Runnable r = new java.lang.Runnable() {
            public void run() {
                final javax.swing.JFrame f = new javax.swing.JFrame("Test Screenshot");
                javax.swing.JMenuItem screenshot = new javax.swing.JMenuItem("Screenshot");
                screenshot.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.CTRL_DOWN_MASK));
                screenshot.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        java.awt.image.BufferedImage img = Class_.ComponentImageCapture.getScreenShot(f.getContentPane());
                        javax.swing.JOptionPane.showMessageDialog(null, new javax.swing.JLabel(new javax.swing.ImageIcon(img.getScaledInstance(img.getWidth(null) / 2, img.getHeight(null) / 2, java.awt.Image.SCALE_SMOOTH))));
                        try {

                            javax.imageio.ImageIO.write(img, "png", new java.io.File("screenshot.png"));
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                javax.swing.JMenu menu = new javax.swing.JMenu("Other");
                menu.add(screenshot);
                javax.swing.JMenuBar mb = new javax.swing.JMenuBar();
                mb.add(menu);
                f.setJMenuBar(mb);
                javax.swing.JPanel p = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
                p.setBorder(new javax.swing.border.TitledBorder("Main GUI"));
                p.add(new javax.swing.JScrollPane(new javax.swing.JTree()), java.awt.BorderLayout.WEST);
                p.add(new javax.swing.JScrollPane(new javax.swing.JTextArea(Class_.ComponentImageCapture.HELP, 10, 30)), java.awt.BorderLayout.CENTER);
                f.setContentPane(p);
                f.pack();
                f.setLocationRelativeTo(null);
                f.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
            }
        };
        javax.swing.SwingUtilities.invokeLater(r);
    }
}

