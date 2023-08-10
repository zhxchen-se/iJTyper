class WhereToPutTheGui {
    public static void initGui() {
        for (int ii = 1; ii < 4; ii++) {
            javax.swing.JFrame f = new javax.swing.JFrame("Frame " + ii);
            f.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
            java.lang.String s = (("os.name: " + java.lang.System.getProperty("os.name")) + "\nos.version: ") + java.lang.System.getProperty("os.version");
            f.add(new javax.swing.JTextArea(s, 3, 28));// suggest a size

            f.pack();
            // Let the OS handle the positioning!
            f.setLocationByPlatform(true);
            f.setVisible(true);
        }
    }

    public static void main(java.lang.String[] args) {
        javax.swing.SwingUtilities.invokeLater(new java.lang.Runnable() {
            public void run() {
                try {
                    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
                } catch (java.lang.Exception useDefault) {
                }
                Class_.WhereToPutTheGui.initGui();
            }
        });
    }
}

