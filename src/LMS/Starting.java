package LMS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HackMe
 */
public class Starting {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        SplashScreen screen = new SplashScreen();
        WelcomeScreen start = new WelcomeScreen();
        screen.setVisible(true);
        try {
            for (int row = 0; row <= 100; row++) {
                Thread.sleep(40);
                screen.loadingnumber.setText(Integer.toString(row) + "%");
                screen.loadingprogress.setValue(row);
                if (row == 100) {

                    screen.setVisible(false);
//                    screen.dispose();
                    //new Home();
                    start.setVisible(true);
                }
            }

        } catch (Exception e) {
        }
    }
}
