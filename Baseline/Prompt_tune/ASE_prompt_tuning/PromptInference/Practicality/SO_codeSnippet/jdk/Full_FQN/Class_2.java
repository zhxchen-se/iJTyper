class Class_2 {
  public static void main(java.lang.String[] args) {
    java.lang.Runnable r = new java.lang.Runnable() {
      public void run() {
        final javax.swing.JFrame frame = new javax.swing.JFrame("Nested Layout Example");
        javax.swing.JFrame.setDefaultCloseOperation(int)
        final javax.swing.JPanel gui = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
        javax.swing.JComponent.setBorder(javax.swing.border.Border)
        // JToolBar tb = new JToolBar();
        javax.swing.JPanel plafComponents = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 3));
        javax.swing.JComponent.setBorder(javax.swing.border.Border)
        final javax.swing.UIManager.LookAndFeelInfo[] plafInfos = javax.swing.UIManager.getInstalledLookAndFeels();
        java.lang.String[] plafNames = new java.lang.String[plafInfos.length];
        for (int ii = 0; ii < plafInfos.length; ii++) {
          plafNames[ii] = javax.swing.UIManager$LookAndFeelInfo.getName();
        }
        final javax.swing.JComboBox plafChooser = new javax.swing.JComboBox(plafNames);
        java.awt.Container.add(java.awt.Component)
        final javax.swing.JCheckBox pack = new javax.swing.JCheckBox("Pack on PLAF change", true);
        java.awt.Container.add(java.awt.Component)
        javax.swing.JComboBox.addActionListener(java.awt.event.ActionListener)
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        javax.swing.JPanel dynamicLabels = new javax.swing.JPanel(new java.awt.BorderLayout(4, 4));
        javax.swing.JComponent.setBorder(javax.swing.border.Border)
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        final javax.swing.JPanel labels = new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 3, 3));
        javax.swing.JComponent.setBorder(javax.swing.border.Border)
        javax.swing.JButton addNew = new javax.swing.JButton("Add Another Label");
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        javax.swing.AbstractButton.addActionListener(java.awt.event.ActionListener)
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        java.lang.String[] header = new java.lang.String[]{ "Name", "Value" };
        java.lang.String[] a = new java.lang.String[0];
        java.lang.String[] names = java.lang.System.getProperties()###java.util.Properties.stringPropertyNames()###java.util.Set.toArray(java.lang.Object[]);
        java.lang.String[][] data = new java.lang.String[names.length][2];
        for (int ii = 0; ii < names.length; ii++) {
          data[ii][0] = names[ii];
          data[ii][1] = java.lang.System.getProperty(java.lang.String);
        }
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, header);
        javax.swing.JTable table = new javax.swing.JTable(model);
        try {
          javax.swing.JTable.setAutoCreateRowSorter(boolean)
        } catch (java.lang.Exception continuewithNoSort) {
        }
        javax.swing.JScrollPane tableScroll = new javax.swing.JScrollPane(table);
        java.awt.Dimension tablePreferred = javax.swing.JComponent.getPreferredSize();
        javax.swing.JComponent.setPreferredSize(java.awt.Dimension)
        javax.swing.JPanel imagePanel = new javax.swing.JPanel(new java.awt.GridBagLayout());
        javax.swing.JComponent.setBorder(javax.swing.border.Border)
        java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(200, 200, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        java.awt.Graphics2D g = java.awt.image.BufferedImage.createGraphics();
        java.awt.GradientPaint gp = new java.awt.GradientPaint(20.0F, 20.0F, java.awt.Color.red, 180.0F, 180.0F, java.awt.Color.yellow);
        java.awt.Graphics2D.setPaint(java.awt.Paint)
        java.awt.Graphics.fillRect(int,int,int,int)
        javax.swing.ImageIcon ii = new javax.swing.ImageIcon(bi);
        javax.swing.JLabel imageLabel = new javax.swing.JLabel(ii);
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        javax.swing.JSplitPane splitPane = new javax.swing.JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT, tableScroll, new javax.swing.JScrollPane(imagePanel));
        java.awt.Container.add(java.awt.Component,java.lang.Object)
        javax.swing.JFrame.setContentPane(java.awt.Container)
        java.awt.Window.pack()
        java.awt.Window.setLocationRelativeTo(java.awt.Component)
        try {
          java.awt.Window.setLocationByPlatform(boolean)
          java.awt.Window.setMinimumSize(java.awt.Dimension)
        } catch (java.lang.Throwable ignoreAndContinue) {
        }
        java.awt.Window.setVisible(boolean)
      }
    };
    javax.swing.SwingUtilities.invokeLater(java.lang.Runnable)
  }
}
