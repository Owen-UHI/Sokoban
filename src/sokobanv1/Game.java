/*
 * 21005686
 * Owen Ross
 * Object Oriented Programming
 */
package sokobanv1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import java.util.HashMap;
import javax.swing.ImageIcon;

public class Game extends javax.swing.JFrame implements KeyListener {   //01:53 on final vid: https://brightspace.uhi.ac.uk/d2l/le/content/374391/viewContent/3389172/View

    private JLabel [][] myElements = new JLabel[12][12];
    private Map tmpMap;
    private HashMap<String, ImageIcon> imageHashMap;
    
    
    public Game() {
        initComponents();
        for (int i = 0; i < myElements.length; i++) { //When working with graphics, use myElements
            for (int j = 0; j < myElements.length; j++) {
                myElements[i][j] = new JLabel();
                //myElements[i][j].setText(".");
                pnl_game.add(myElements[i][j]);
                
            }
            
        }
        this.addKeyListener(this);
        setFocusable(true);
        tmpMap = new Map();
        drawMap();
    }

    
    
    
    public ImageIcon getImage(String filename){
        //filename = MapElement.getImgFileName();
        //use mapelements display thingy here with the file path specified as variable filename
        
        return null;
    }

    public HashMap<String, ImageIcon> getImageHashMap() {
        return imageHashMap;
    }

 
    

    
    
    
    
    private void drawMap(){
        for (int i = 0; i < myElements.length; i++) {
            for (int j = 0; j < myElements.length; j++) {
                //myElements[i][j].setText(tmpMap.getMyMap()[i][j].getSymbol());
                //maybe put really big if statement in here (ie, if symbol = f, set image icon for floor
                myElements[i][j].setIcon(new ImageIcon(getClass().getResource(tmpMap.getMyMap()[i][j].getImgFileName())));
                
                
               // myElements[i][j].setIcon(tmpMap.getMyMap()[i][j].new ImageIcon(getClass().getResource(Map.getImgFileName)));
                //myElements[i][j].setIcon(new ImageIcon(getClass().getResource(getImgFileName())));
            } 
        }
     }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_status = new javax.swing.JPanel();
        lbl_output = new javax.swing.JLabel();
        pnl_game = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_status.setPreferredSize(new java.awt.Dimension(400, 30));

        lbl_output.setText("jLabel1");

        javax.swing.GroupLayout pnl_statusLayout = new javax.swing.GroupLayout(pnl_status);
        pnl_status.setLayout(pnl_statusLayout);
        pnl_statusLayout.setHorizontalGroup(
            pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_statusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_output, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        pnl_statusLayout.setVerticalGroup(
            pnl_statusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_statusLayout.createSequentialGroup()
                .addComponent(lbl_output, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(pnl_status, java.awt.BorderLayout.PAGE_END);

        pnl_game.setPreferredSize(new java.awt.Dimension(400, 400));
        pnl_game.setLayout(new java.awt.GridLayout(12, 12));
        getContentPane().add(pnl_game, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_output;
    private javax.swing.JPanel pnl_game;
    private javax.swing.JPanel pnl_status;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyChar() == 'w' || e.getKeyCode() == KeyEvent.VK_UP){
            tmpMap.movePlayer(1);
            lbl_output.setText("You pressed up");
        } else if (e.getKeyChar() == 's'|| e.getKeyCode() == KeyEvent.VK_DOWN) {
                tmpMap.movePlayer(2);
                lbl_output.setText("You pressed down");
        } else if (e.getKeyChar() == 'a'|| e.getKeyCode() == KeyEvent.VK_LEFT) {
            tmpMap.movePlayer(3);
            lbl_output.setText("You pressed left");
        } else if (e.getKeyChar() == 'd'|| e.getKeyCode() == KeyEvent.VK_RIGHT) {
            tmpMap.movePlayer(4);
            lbl_output.setText("You pressed Right");
        }  else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            tmpMap.resetMap();
        }
        tmpMap.checkForWin();
        boolean hasWon = tmpMap.checkForWin();
        if(hasWon != false){
            lbl_output.setText("You have Won!");
        }
        
        drawMap();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
