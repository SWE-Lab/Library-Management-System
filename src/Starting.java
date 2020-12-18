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
        SplashScreen screen = new SplashScreen();
        Home start = new Home();
        screen.setVisible(true);
        try {
            for (int row = 0; row <=100; row++) {
                Thread.sleep(10);
                screen.loadingnumber.setText(Integer.toString(row)+"%");
                screen.loadingprogress.setValue(row);
                if (row == 100) {
         
                    screen.setVisible(false);
                    //screen.dispose();
                    //new Home();
                    start.setVisible(true);
                }
            }
            
        } catch (Exception e) {
        }
    }
}
