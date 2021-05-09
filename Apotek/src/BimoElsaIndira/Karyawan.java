package BimoElsaIndira;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BimoElsaIndiraay
 */
public class Karyawan extends javax.swing.JFrame implements FungsiData{

    
    public Karyawan() {
        initComponents();
    }
    @Override
     public void reset(){
        txtID.setEditable(true);
        txtID.setText(null);
        txtNama.setText(null);
        txtUmur.setText(null);
        txtNo.setText(null);
        txtAlamat.setText(null);
    }
    @Override
    public void tampil(){
        DefaultTableModel kolom = new DefaultTableModel();
        kolom.addColumn("No");
        kolom.addColumn("ID");
        kolom.addColumn("Nama");
        kolom.addColumn("Umur");
        kolom.addColumn("No. Telpon");
        kolom.addColumn("Alamat");
        try{
            int n = 1;
            String query = "SELECT * FROM karyawan";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(query);
            
            while(res.next()){
                kolom.addRow(new Object[]{n++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5)});
            }
            tabelKaryawan.setModel(kolom);
        }
        catch(SQLException e){
            System.out.println("System anda error karena "+e.getMessage());
        }
    }
    @Override
    public void tambah(){
        try{
            String query = "INSERT INTO karyawan VALUES('"+txtID.getText()+"','"+txtNama.getText()+"','"+txtUmur.getText()+"','"+txtNo.getText()+"','"+txtAlamat.getText()+"')";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan!");
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @Override
    public void edit(){
        try{
            String query = "UPDATE karyawan SET id = '"+txtID.getText()+"', nama = '"+txtNama.getText()+"', umur = '"+txtUmur.getText()+"', no_telepon = '"+txtNo.getText()+"', alamat = '"+txtAlamat.getText()+"' WHERE id = '"+txtID.getText()+"'";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil diedit!");
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @Override
    public void delete(){
        try{
            String query = "DELETE FROM karyawan WHERE id = '"+txtID.getText()+"'";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus!");
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtNo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKaryawan = new javax.swing.JTable();
        btTambah = new javax.swing.JButton();
        tbEdit = new javax.swing.JButton();
        tbReset = new javax.swing.JButton();
        tbDelete = new javax.swing.JButton();
        txtAlamat = new javax.swing.JTextField();
        txtUmur = new javax.swing.JTextField();
        btOut = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 207, 250));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Data Karyawan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(239, 32, -1, -1));

        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 93, -1, -1));

        jLabel3.setText("Nama");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 137, -1, -1));

        jLabel4.setText("Umur");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 182, -1, -1));

        jLabel5.setText("No Telepon");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 227, -1, -1));

        jLabel6.setText("Alamat");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 303, -1, -1));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 90, 282, -1));
        getContentPane().add(txtNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 134, 285, -1));
        getContentPane().add(txtNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 224, 168, -1));

        tabelKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelKaryawan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 444, 557, 110));

        btTambah.setBackground(new java.awt.Color(143, 194, 146));
        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });
        getContentPane().add(btTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 406, -1, -1));

        tbEdit.setBackground(new java.awt.Color(143, 161, 194));
        tbEdit.setText("Edit");
        tbEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbEditActionPerformed(evt);
            }
        });
        getContentPane().add(tbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 406, -1, -1));

        tbReset.setBackground(new java.awt.Color(252, 246, 119));
        tbReset.setText("Reset");
        tbReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbResetActionPerformed(evt);
            }
        });
        getContentPane().add(tbReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(515, 406, -1, -1));

        tbDelete.setBackground(new java.awt.Color(237, 83, 83));
        tbDelete.setText("Delete");
        tbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(tbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 406, -1, -1));
        getContentPane().add(txtAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 270, 283, 82));
        getContentPane().add(txtUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 179, 41, -1));

        btOut.setBackground(new java.awt.Color(237, 83, 83));
        btOut.setText("Logout");
        btOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOutActionPerformed(evt);
            }
        });
        getContentPane().add(btOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 80, -1));

        btBack.setBackground(new java.awt.Color(143, 161, 194));
        btBack.setText("Kembali");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });
        getContentPane().add(btBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 80, -1));

        jPanel1.setBackground(new java.awt.Color(244, 225, 245));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 620, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        tambah();
        tampil();
        reset();
    }//GEN-LAST:event_btTambahActionPerformed

    private void tbResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_tbResetActionPerformed

    private void tbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDeleteActionPerformed
        // TODO add your handling code here:
        delete();
        tampil();
        reset();
    }//GEN-LAST:event_tbDeleteActionPerformed

    private void tbEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbEditActionPerformed
        // TODO add your handling code here:
        edit();
        tampil();
        reset();

    }//GEN-LAST:event_tbEditActionPerformed

    private void btOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOutActionPerformed
        // TODO add your handling code here:
        Login log = new Login();
        log.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btOutActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        // TODO add your handling code here:
        Index in = new Index();
        in.setVisible(true);
        setVisible(false);
              
    }//GEN-LAST:event_btBackActionPerformed

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btOut;
    private javax.swing.JButton btTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelKaryawan;
    private javax.swing.JButton tbDelete;
    private javax.swing.JButton tbEdit;
    private javax.swing.JButton tbReset;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtUmur;
    // End of variables declaration//GEN-END:variables
}
