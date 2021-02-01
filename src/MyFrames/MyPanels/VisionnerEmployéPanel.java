/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrames.MyPanels;

import GestionBancaire.ConnectionBD;
import MyFrames.FrameEmployé;
import gestionbancaire3.Authentification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus pro
 */
public class VisionnerEmployéPanel extends javax.swing.JPanel {

    static DefaultTableModel model = new DefaultTableModel();

    public VisionnerEmployéPanel() {

        initComponents();
        model.addColumn("ID");
        model.addColumn("nom");
        model.addColumn("prenom");
        model.addColumn("Date Naissance");
        model.addColumn("poste");

        String sql = "";
        ResultSet rs;
        try {
            ConnectionBD conn = new ConnectionBD();
            if (Authentification.code_agence == 1) {
                liste_agence.setEnabled(true);
                btnChercher.setEnabled(true);
                sql = "select * from agences;";
                rs = conn.Select(sql);

            } else {
                sql = "select * from agences where code_agence=?;";
                rs = conn.initRequetePreparee(sql, false, Authentification.code_agence).executeQuery();
                fillTable("select * from employes where code_agence=?", Authentification.code_agence);

            }

            while (rs.next()) {
                liste_agence.addItem(rs.getString("nom_agence"));
            }

            conn.disconnect();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void fillTable(String sql, int agence) {

        model.setRowCount(0);
        try {
            ConnectionBD conn = new ConnectionBD();

            ResultSet rs = conn.initRequetePreparee(sql, false, agence).executeQuery();

            conn.disconnect();
        } catch (Exception e) {
            System.err.println(e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmployés = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        liste_agence = new javax.swing.JComboBox<String>();
        btnChercher = new javax.swing.JButton();

        tableEmployés.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tableEmployés.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmployésMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEmployés);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("Agence : ");

        liste_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liste_agenceActionPerformed(evt);
            }
        });

        btnChercher.setBackground(new java.awt.Color(255, 204, 153));
        btnChercher.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnChercher.setText("Rechercher");
        btnChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(liste_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnChercher)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(liste_agence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChercher))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChercherActionPerformed
        String agence = liste_agence.getSelectedItem().toString();

        try {
            ConnectionBD conn = new ConnectionBD();

            String requete = "select code_agence from agences where nom_agence=?";
            ResultSet rs = conn.initRequetePreparee(requete, true, agence).executeQuery();
            if (rs.next()) {
                String sql = "select * from employes where code_agence=?;";
                fillTable(sql, rs.getInt("code_agence"));
                tableEmployés.setModel(model);
            }

            conn.disconnect();
        } catch (Exception e) {
            System.err.println(e);
        }

    }//GEN-LAST:event_btnChercherActionPerformed

    private void tableEmployésMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmployésMouseClicked
    
    }//GEN-LAST:event_tableEmployésMouseClicked

    private void liste_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liste_agenceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_liste_agenceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChercher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> liste_agence;
    private javax.swing.JTable tableEmployés;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getListe_agence() {
        return liste_agence;
    }

}
