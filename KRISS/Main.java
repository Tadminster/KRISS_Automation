package KRISS;

import java.awt.EventQueue;

public class Main {
  /**
   * Launch the application.
   */
  public static void main(String[] args) {

    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Windows windows = new Windows();
          windows.getFrmNull().setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
