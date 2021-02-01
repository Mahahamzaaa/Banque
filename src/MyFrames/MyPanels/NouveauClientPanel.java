/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyFrames.MyPanels;
        
import GestionBancaire.ConnectionBD;
import static MyFrames.MyPanels.VisionnerClientPanel.fillTable;
import static MyFrames.MyPanels.VisionnerClientPanel.model;
import gestionbancaire3.Authentification;
import static gestionbancaire3.Authentification.code_agence;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import jdk.internal.org.xml.sax.ErrorHandler;

        
/**
 *
 * @author asus pro
 */
public class NouveauClientPanel extends javax.swing.JPanel {
            JFileChooser fc = new JFileChooser();

    
    /**
     * Creates new form NouveauClientPanel
     */
    public NouveauClientPanel() {
        initComponents();
        String requete;
        ResultSet rs;
        
    try {
        ConnectionBD conn = new ConnectionBD();
        if(Authentification.code_agence != 1)
        {
            requete = "select * from agences where code_agence=?";
            rs = conn.initRequetePreparee(requete,true,Authentification.code_agence).executeQuery();
            
           
        }
        else{
            
            requete = "select * from agences;";
            rs = conn.Select(requete);
        }


            
             

            while(rs.next())
            {
                liste_agences.addItem(rs.getString("nom_agence"));
            }

            conn.disconnect();
        } catch (Exception e) {
            System.err.println(e);
        }
            
        if(Authentification.code_agence == 1)
        {
            liste_agences.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cin_field = new javax.swing.JTextField();
        nom_field = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        prenom_field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        liste_agences = new javax.swing.JComboBox<String>();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(586, 343));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel1.setText("CIN : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Nom :");

        jButton1.setBackground(new java.awt.Color(255, 204, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Ajouter");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("Prenom :");

        prenom_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenom_fieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel4.setText("Agence :");

        liste_agences.setEnabled(false);
        liste_agences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liste_agencesActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 204, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton2.setText("Image");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cin_field)
                    .addComponent(nom_field)
                    .addComponent(prenom_field)
                    .addComponent(liste_agences, 0, 150, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(153, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cin_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nom_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenom_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(liste_agences, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String cin = cin_field.getText();
        String nom = nom_field.getText();
        String prenom = prenom_field.getText();
        String nom_agence = liste_agences.getSelectedItem().toString();
         
        String requete = "insert into clients(cin_client,nom_client,prenom_client,code_agence,image) values(?,?,?,?,?)";
        try {
            FileInputStream fis = new FileInputStream(fc.getSelectedFile());
            ConnectionBD conn = new ConnectionBD();
           PreparedStatement preparedStm = null;
           if(Authentification.code_agence != 1)
                 preparedStm = conn.initRequetePreparee(requete, true, cin,nom,prenom,Authentification.code_agence,fis);
           else {
               String sql = "select code_agence from agences where nom_agence = ?";
               ResultSet rs = conn.initRequetePreparee(sql, true, nom_agence).executeQuery();
               if(rs.next())
               {
                   preparedStm =conn.initRequetePreparee(requete, true,  cin,nom,prenom,rs.getInt("code_agence"),fis);
               }
           }
            preparedStm.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "client ajouté");

            //actualiser la table des clients
            VisionnerClientPanel.model.setRowCount(0);
              String sql = "select * from clients where code_agence=?;";
                fillTable(sql,Authentification.code_agence);
                
         
               
                
              
               
                
               
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void liste_agencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liste_agencesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_liste_agencesActionPerformed

    private void prenom_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenom_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenom_fieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        choosePicture();
        
    }//GEN-LAST:event_jButton2ActionPerformed
    private boolean imageValide=false;
    private void choosePicture() {

        FileFilter imageFilter = new FileNameExtensionFilter(
                "Image files", ImageIO.getReaderFileSuffixes());
        fc.setFileFilter(imageFilter);
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File picture = fc.getSelectedFile();
            String absolutePath = picture.getAbsolutePath();
            String extension = picture.getName().substring(picture.getName().lastIndexOf('.') + 1);
            if (!extension.equalsIgnoreCase("jpg") && !extension.equalsIgnoreCase("png")) {
                imageValide = false;
               
                
            } else {
                try {
                    BufferedImage bimg = ImageIO.read(fc.getSelectedFile());
                    int width = bimg.getWidth();
                    int height = bimg.getHeight();
                    if (!(width >= 70 && width <= 800) || !(height >= 70 && height <= 800)) {
                        throw new Exception();
                    }
                    imageValide = true;
                    
                } catch (Exception e) {
                    imageValide = false;
                   
                   
                }
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cin_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> liste_agences;
    private javax.swing.JTextField nom_field;
    private javax.swing.JTextField prenom_field;
    // End of variables declaration//GEN-END:variables

    public JComboBox<String> getListe_agences() {
        return liste_agences;
    }
}