///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package LMS;
//import java.awt.GradientPaint;
//import java.awt.Graphics2D;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.Color;
//import javax.swing.Timer;
//import javax.swing.JPanel;
///**
// *
// * @author aniket
// */
//public class GradientPanel extends JPanel
//{
//    static final float HUE_MIN = 0.0f;
//    static final float HUE_MAX = 1.0f;
//    final Timer timer;
//    float hue;
//    private float delta;
//    public Color color1;
//    public Color color2;
//    
//    public GradientPanel() {
//        this.hue = 0.0f;
//        this.delta = 0.001f;
//        this.color1 = Color.white;
//        this.color2 = Color.black;
//        (this.timer = new Timer(30, new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent actionEvent) {
//                final GradientPanel this$0 = GradientPanel.this;
//                this$0.hue += GradientPanel.this.delta;
//                if (GradientPanel.this.hue > 1.0f) {
//                    GradientPanel.this.hue = 0.0f;
//                }
//                GradientPanel.this.color1 = Color.getHSBColor(GradientPanel.this.hue, 1.0f, 1.0f);
//                GradientPanel.this.color2 = Color.getHSBColor(GradientPanel.this.hue + 16.0f * GradientPanel.this.delta, 1.0f, 1.0f);
//                GradientPanel.this.repaint();
//            }
//        })).start();
//    }
//    
//    @Override
//    protected void paintComponent(final Graphics g) {
//        super.paintComponent(g);
//        final Graphics2D graphics2D = (Graphics2D)g;
//        graphics2D.setPaint(new GradientPaint(0.0f, 0.0f, this.color1, (float)this.getWidth(), 0.0f, this.color2));
//        graphics2D.fillRect(0, 0, this.getWidth(), this.getHeight());
//    }
//}