/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Panel;

/**
 *
 * @author COMPAQ
 */
public class MarcoInicial extends javax.swing.JFrame {

    /**
     * Creates new form MarcoInicial
     */
    public MarcoInicial() {
        initComponents();
        setLocationRelativeTo(null);
      this.FlechaScore.setVisible(false);
         this.FlechaGame1.setVisible(false);
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        NewGame = new javax.swing.JLabel();
        FlechaScore = new javax.swing.JLabel();
        Scores = new javax.swing.JLabel();
        FlechaGame1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pan1 = new Vista.Pan();

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Menu2.jpg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewGame.setName("NewGame"); // NOI18N
        NewGame.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NewGameFocusGained(evt);
            }
        });
        NewGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewGameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NewGameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NewGameMouseExited(evt);
            }
        });
        getContentPane().add(NewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 160, 60));

        FlechaScore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/flecha.png"))); // NOI18N
        FlechaScore.setName("FlechaScore"); // NOI18N
        getContentPane().add(FlechaScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        Scores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ScoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScoresMouseExited(evt);
            }
        });
        getContentPane().add(Scores, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 100, 60));

        FlechaGame1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/flecha.png"))); // NOI18N
        FlechaGame1.setName("FlechaGame"); // NOI18N
        getContentPane().add(FlechaGame1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Salir");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));
        getContentPane().add(pan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewGameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGameMouseEntered
this.FlechaGame1.setVisible(true);
    }//GEN-LAST:event_NewGameMouseEntered

    private void NewGameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGameMouseExited
this.FlechaGame1.setVisible(false);     
    }//GEN-LAST:event_NewGameMouseExited

    private void NewGameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NewGameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_NewGameFocusGained

    private void ScoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoresMouseEntered
 this.FlechaScore.setVisible(true);
 // TODO add your handling code here:
    }//GEN-LAST:event_ScoresMouseEntered

    private void ScoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScoresMouseExited
this.FlechaScore.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_ScoresMouseExited

    private void NewGameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewGameMouseClicked
this.dispose();
MarcoNick marco=new MarcoNick();
marco.show();
        

// TODO add your handling code here:
    }//GEN-LAST:event_NewGameMouseClicked

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
            java.util.logging.Logger.getLogger(MarcoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarcoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarcoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarcoInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarcoInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FlechaGame1;
    private javax.swing.JLabel FlechaScore;
    private javax.swing.JLabel NewGame;
    private javax.swing.JLabel Scores;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private Vista.Pan pan1;
    // End of variables declaration//GEN-END:variables
}
