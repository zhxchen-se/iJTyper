public class Class_22 {
  // @see http://stackoverflow.com/questions/4637215
  public class TwoRoot extends javax.swing.JFrame {
    private static final java.lang.String s = "0.000000000000000";

    private javax.swing.JProgressBar progressBar = new javax.swing.JProgressBar(0, 100);

    private javax.swing.JLabel label = new javax.swing.JLabel(Class_.Class_22.TwoRoot.s, javax.swing.JLabel.CENTER);

    public TwoRoot() {
      javax.swing.JFrame.setLayout(java.awt.LayoutManager)
      java.awt.Frame.setTitle(java.lang.String)
      javax.swing.JFrame.setDefaultCloseOperation(int)
      java.awt.Container.add(java.awt.Component)
      java.awt.Container.add(java.awt.Component)
      java.awt.Window.setSize(int,int)
      java.awt.Window.setLocationRelativeTo(java.awt.Component)
      java.awt.Window.setVisible(boolean)
    }

    public void runCalc() {
      javax.swing.JProgressBar.setIndeterminate(boolean)
      Class_.Class_22.TwoRoot.TwoWorker task = new Class_.Class_22.TwoRoot.TwoWorker();
      javax.swing.SwingWorker.addPropertyChangeListener(java.beans.PropertyChangeListener)
      javax.swing.SwingWorker.execute()
    }

    private class TwoWorker extends javax.swing.SwingWorker<java.lang.Double, java.lang.Double> {
      private static final int N = 5;

      private final java.text.DecimalFormat df = new java.text.DecimalFormat(Class_.Class_22.TwoRoot.s);

      double x = 1;

      @java.lang.Override
      protected java.lang.Double doInBackground() throws java.lang.Exception {
        for (int i = 1; i <= Class_.Class_22.TwoRoot.TwoWorker.N; i++) {
          x = x - (((x * x) - 2) / (2 * x));
          javax.swing.SwingWorker.setProgress(int)
          javax.swing.SwingWorker.publish(java.lang.Object[])
          java.lang.Thread.sleep(long)
        }
        return java.lang.Double.valueOf(double);
      }

      @java.lang.Override
      protected void process(java.util.List<java.lang.Double> chunks) {
        for (double d : chunks) {
          javax.swing.JLabel.setText(java.lang.String)
        }
      }
    }

    public void main(java.lang.String[] args) {
      java.awt.EventQueue.invokeLater(java.lang.Runnable)
    }
  }

  javax.swing.JFrame progressFrame;

  javax.swing.JProgressBar progressBar;

  javax.swing.JLabel label = new javax.swing.JLabel("Calculating...");

  java.awt.Container pane;

  double amountSaved = 0;

  int i = 0;

  int iterations;

  public void createGui(int iterations) {
    // Create all components
    progressFrame = new javax.swing.JFrame("Calculation Progress");
    java.awt.Window.setSize(int,int)
    pane = javax.swing.JFrame.getContentPane();
    java.awt.Container.setLayout(java.awt.LayoutManager)
    label = new javax.swing.JLabel("Calculating...");
    java.awt.Component.setBounds(int,int,int,int)
    progressBar = new javax.swing.JProgressBar(0, iterations);
    java.awt.Component.setBounds(int,int,int,int)
    javax.swing.JProgressBar.setStringPainted(boolean)
    java.awt.Container.add(java.awt.Component)
    java.awt.Container.add(java.awt.Component)
    javax.swing.JFrame.setDefaultCloseOperation(int)
    java.awt.Frame.setResizable(boolean)
    java.awt.Window.setLocationRelativeTo(java.awt.Component)
    java.awt.Window.setVisible(boolean)
  }

  public void runCalcs(double MP, double StepAmt, double L1, double L2, double C1, double C2, double IM1, double IM2, double M1Start, double M2Start) {
    javax.swing.JProgressBar.setIndeterminate(boolean)
    Class_.Class_22.TwoWorker task = new Class_.Class_22.TwoWorker(MP, StepAmt, L1, L2, C1, C2, IM1, IM2, M1Start, M2Start);
    javax.swing.SwingWorker.addPropertyChangeListener(java.beans.PropertyChangeListener)
    javax.swing.SwingWorker.execute()
  }// end method runCalcs


  public class TwoWorker extends javax.swing.SwingWorker<java.lang.Double, java.lang.Double> {
    private final double MP;

    private final double StepAmt;

    private final double L1;

    private final double L2;

    private final double C1;

    private final double C2;

    private final double IM1;

    private final double IM2;

    private final double M1Start;

    private final double M2Start;

    public TwoWorker(double MPa, double StepAmta, double L1a, double L2a, double C1a, double C2a, double IM1a, double IM2a, double M1Starta, double M2Starta) {
      MP = MPa;
      StepAmt = StepAmta;
      L1 = L1a;
      L2 = L2a;
      C1 = C1a;
      C2 = C2a;
      IM1 = IM1a;
      IM2 = IM2a;
      M1Start = M1Starta;
      M2Start = M2Starta;
    }

    @java.lang.Override
    protected java.lang.Double doInBackground() {
      double M1 = M1Start;
      double M2 = M2Start;
      // Set MinLoop as maximum to start
      // Loan 1
      double N1 = (java.lang.Math.log10(double) * (-1)) / java.lang.Math.log10(double);
      double M1Sum = M1 * N1;
      // Loan 2
      double N2 = (java.lang.Math.log10(double) * (-1)) / java.lang.Math.log10(double);
      double M2Sum = M2 * N2;
      double minLoop = M1Sum + M2Sum;
      double MTotal = 0;
      // Define variables for mins
      double MP1 = 0;
      double MP2 = 0;
      double NP1 = 0;
      double NP2 = 0;
      double MP1Sum = 0;
      double MP2Sum = 0;
      while ((M1 <= (MP - M2Start)) && (M2 >= M2Start)) {
        N1 = (java.lang.Math.log10(double) * (-1)) / java.lang.Math.log10(double);
        M1Sum = N1 * M1;
        N2 = (java.lang.Math.log10(double) * (-1)) / java.lang.Math.log10(double);
        M2Sum = N2 * M2;
        MTotal = M1Sum + M2Sum;
        if (MTotal < minLoop) {
          minLoop = MTotal;
          MP1 = M1;
          MP2 = M2;
          NP1 = N1;
          NP2 = N2;
          MP1Sum = M1Sum;
          MP2Sum = M2Sum;
        }// end if

        i++;
        javax.swing.JProgressBar.setValue(int)
        M1 = M1 + StepAmt;
        M2 = MP - M1;
        // Reset monthly sums
        M1Sum = 0;
        M2Sum = 0;
      } // end while

      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      java.io.PrintStream.printf(java.lang.String,java.lang.Object[])
      // if there's a value for current payments, calculate amount saved
      if (C1 > 0) {
        double CN1 = (java.lang.Math.log10(double) * (-1)) / java.lang.Math.log10(double);
        double CT1 = CN1 * C1;
        double CN2 = (java.lang.Math.log10(double) * (-1)) / java.lang.Math.log10(double);
        double CT2 = CN2 * C2;
        double CTotal = CT1 + CT2;
        amountSaved = CTotal - minLoop;
      }// end if

      return null;
    }// end doInBackGround


    @java.lang.Override
    protected void done() {
      java.awt.Component.setBounds(int,int,int,int)
      javax.swing.JLabel.setText(java.lang.String)
    }
  }

  public double savedReturn() {
    return amountSaved;
  }
}
