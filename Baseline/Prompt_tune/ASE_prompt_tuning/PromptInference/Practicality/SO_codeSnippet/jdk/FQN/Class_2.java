class Class_2 {
    public static void main(java.lang.String[] args) {
        java.lang.Runnable r = new java.lang.Runnable() {
            public void run() {
                final javax.swing.JFrame frame = new javax.swing.JFrame("Nested Layout Example");
                frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
                final javax.swing.JPanel gui = new javax.swing.JPanel(new java.awt.BorderLayout(5, 5));
                gui.setBorder(new javax.swing.border.TitledBorder("BorderLayout(5,5)"));
                // JToolBar tb = new JToolBar();
                javax.swing.JPanel plafComponents = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 3, 3));
                plafComponents.setBorder(new javax.swing.border.TitledBorder("FlowLayout(FlowLayout.RIGHT, 3,3)"));
                final javax.swing.UIManager.LookAndFeelInfo[] plafInfos = javax.swing.UIManager.getInstalledLookAndFeels();
                java.lang.String[] plafNames = new java.lang.String[plafInfos.length];
                for (int ii = 0; ii < plafInfos.length; ii++) {
                    plafNames[ii] = plafInfos[ii].getName();
                }
                final javax.swing.JComboBox plafChooser = new javax.swing.JComboBox(plafNames);
                plafComponents.add(plafChooser);
                final javax.swing.JCheckBox pack = new javax.swing.JCheckBox("Pack on PLAF change", true);
                plafComponents.add(pack);
                plafChooser.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        int index = plafChooser.getSelectedIndex();
                        try {
                            javax.swing.UIManager.setLookAndFeel(plafInfos[index].getClassName());
                            javax.swing.SwingUtilities.updateComponentTreeUI(frame);
                            if (pack.isSelected()) {
                                frame.pack();
                                frame.setMinimumSize(frame.getSize());
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                gui.add(plafComponents, java.awt.BorderLayout.NORTH);
                javax.swing.JPanel dynamicLabels = new javax.swing.JPanel(new java.awt.BorderLayout(4, 4));
                dynamicLabels.setBorder(new javax.swing.border.TitledBorder("BorderLayout(4,4)"));
                gui.add(dynamicLabels, java.awt.BorderLayout.WEST);
                final javax.swing.JPanel labels = new javax.swing.JPanel(new java.awt.GridLayout(0, 2, 3, 3));
                labels.setBorder(new javax.swing.border.TitledBorder("GridLayout(0,2,3,3)"));
                javax.swing.JButton addNew = new javax.swing.JButton("Add Another Label");
                dynamicLabels.add(addNew, java.awt.BorderLayout.NORTH);
                addNew.addActionListener(new java.awt.event.ActionListener() {
                    private int labelCount = 0;

                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        labels.add(new javax.swing.JLabel("Label " + (++labelCount)));
                        frame.validate();
                    }
                });
                dynamicLabels.add(new javax.swing.JScrollPane(labels), java.awt.BorderLayout.CENTER);
                java.lang.String[] header = new java.lang.String[]{ "Name", "Value" };
                java.lang.String[] a = new java.lang.String[0];
                java.lang.String[] names = java.lang.System.getProperties().stringPropertyNames().toArray(a);
                java.lang.String[][] data = new java.lang.String[names.length][2];
                for (int ii = 0; ii < names.length; ii++) {
                    data[ii][0] = names[ii];
                    data[ii][1] = java.lang.System.getProperty(names[ii]);
                }
                javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(data, header);
                javax.swing.JTable table = new javax.swing.JTable(model);
                try {
                    // 1.6+
                    table.setAutoCreateRowSorter(true);
                } catch (java.lang.Exception continuewithNoSort) {
                }
                javax.swing.JScrollPane tableScroll = new javax.swing.JScrollPane(table);
                java.awt.Dimension tablePreferred = tableScroll.getPreferredSize();
                tableScroll.setPreferredSize(new java.awt.Dimension(tablePreferred.width, tablePreferred.height / 3));
                javax.swing.JPanel imagePanel = new javax.swing.JPanel(new java.awt.GridBagLayout());
                imagePanel.setBorder(new javax.swing.border.TitledBorder("GridBagLayout()"));
                java.awt.image.BufferedImage bi = new java.awt.image.BufferedImage(200, 200, java.awt.image.BufferedImage.TYPE_INT_ARGB);
                java.awt.Graphics2D g = bi.createGraphics();
                java.awt.GradientPaint gp = new java.awt.GradientPaint(20.0F, 20.0F, java.awt.Color.red, 180.0F, 180.0F, java.awt.Color.yellow);
                g.setPaint(gp);
                g.fillRect(0, 0, 200, 200);
                javax.swing.ImageIcon ii = new javax.swing.ImageIcon(bi);
                javax.swing.JLabel imageLabel = new javax.swing.JLabel(ii);
                imagePanel.add(imageLabel, null);
                javax.swing.JSplitPane splitPane = new javax.swing.JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT, tableScroll, new javax.swing.JScrollPane(imagePanel));
                gui.add(splitPane, java.awt.BorderLayout.CENTER);
                frame.setContentPane(gui);
                frame.pack();
                frame.setLocationRelativeTo(null);
                try {
                    // 1.6+
                    frame.setLocationByPlatform(true);
                    frame.setMinimumSize(frame.getSize());
                } catch (java.lang.Throwable ignoreAndContinue) {
                }
                frame.setVisible(true);
            }
        };
        javax.swing.SwingUtilities.invokeLater(r);
    }
}

