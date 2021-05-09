/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoteknonpbo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO LEGION Y540
 */
public class Apotek extends javax.swing.JFrame {

    /**
     * Creates new form Apotek
     */
    public Apotek() {
        initComponents();
    }
    
    public void reset(){
        txtKode.setEditable(true);
        txtKode.setText(null);
        txtNama.setText(null);
        txtHarga.setText(null);
        txtStok.setText(null);
        cbJenis.setSelectedItem(this);
        cbKategori.setSelectedItem(this);
    }
    public void tampil(){
        DefaultTableModel kolom = new DefaultTableModel();
        kolom.addColumn("No");
        kolom.addColumn("Kode");
        kolom.addColumn("Nama");
        kolom.addColumn("Jenis");
        kolom.addColumn("Stock");
        kolom.addColumn("Kategori");
        kolom.addColumn("Harga");
        try{
            int n = 1;
            String query = "SELECT * FROM obat";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(query);
            
            while(res.next()){
                kolom.addRow(new Object[]{n++,res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            tabelObat.setModel(kolom);
        }
        catch(SQLException e){
            System.out.println("System anda error karena "+e.getMessage());
        }
    }
    public void tambah(){
        try{
            String query = "INSERT INTO obat VALUES('"+txtKode.getText()+"','"+txtNama.getText()+"','"+cbJenis.getSelectedItem()+"','"+txtStok.getText()+"','"+cbKategori.getSelectedItem()+"','"+txtHarga.getText()+"')";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan!");
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void edit(){
        try{
            String query = "UPDATE obat SET kode = '"+txtKode.getText()+"', nama = '"+txtNama.getText()+"', jenis = '"+cbJenis.getSelectedItem()+"', stok = '"+txtStok.getText()+"', kategori = '"+cbKategori.getSelectedItem()+"', harga = '"+txtHarga.getText()+"' WHERE kode = '"+txtKode.getText()+"'";
            java.sql.Connection conn = (Connection)KoneksiDB.connDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            JOptionPane.showMessageDialog(null,"Data berhasil diedit!");
        }
        catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void delete(){
        try{
            String query = "DELETE FROM obat WHERE kode = '"+txtKode.getText()+"'";
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
        btTambah = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtStok = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        cbJenis = new javax.swing.JComboBox<>();
        cbKategori = new javax.swing.JComboBox<>();
        btReset = new javax.swing.JButton();
        btHapus = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelObat = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("DATA OBAT");

        btTambah.setBackground(new java.awt.Color(143, 194, 146));
        btTambah.setText("Tambah");
        btTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTambahActionPerformed(evt);
            }
        });

        btEdit.setBackground(new java.awt.Color(143, 161, 194));
        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        jLabel3.setText("Kode");

        jLabel4.setText("Nama");

        jLabel5.setText("Jenis Obat");

        jLabel6.setText("Stok");

        jLabel7.setText("Kategori");

        jLabel8.setText("Harga");

        cbJenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Obat Luar", "Obat Dalam", "Vitamin" }));
        cbJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisActionPerformed(evt);
            }
        });

        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anak-Anak", "Dewasa", "Semua Usia" }));

        btReset.setBackground(new java.awt.Color(252, 246, 119));
        btReset.setText("Reset");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        btHapus.setBackground(new java.awt.Color(237, 83, 83));
        btHapus.setText("Delete");
        btHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHapusActionPerformed(evt);
            }
        });

        tabelObat.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelObatMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelObat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(200, 200, 200)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btTambah)
                            .addGap(11, 11, 11)
                            .addComponent(btEdit)
                            .addGap(17, 17, 17)
                            .addComponent(btHapus)
                            .addGap(311, 311, 311)
                            .addComponent(btReset))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(106, 106, 106)
                                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(101, 101, 101)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(75, 75, 75)
                                    .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(109, 109, 109)
                                    .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(87, 87, 87)
                                    .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(97, 97, 97)
                                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel3))
                        .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel4))
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel5))
                        .addComponent(cbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel6))
                        .addComponent(txtStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel7))
                        .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel8))
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btTambah)
                        .addComponent(btEdit)
                        .addComponent(btHapus)
                        .addComponent(btReset))
                    .addGap(5, 5, 5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTambahActionPerformed
        // TODO add your handling code here:
        tambah();
        tampil();
        reset();

    }//GEN-LAST:event_btTambahActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        edit();
        tampil();
        reset();
    }//GEN-LAST:event_btEditActionPerformed

    private void cbJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btResetActionPerformed

    private void btHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHapusActionPerformed
        // TODO add your handling code here:
        delete();
        tampil();
        reset();
    }//GEN-LAST:event_btHapusActionPerformed

    private void tabelObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelObatMouseClicked
        // TODO add your handling code here:
        int rows = tabelObat.rowAtPoint(evt.getPoint());
        String kode = tabelObat.getValueAt(rows,1).toString();
        txtKode.setText(kode);
        String nama = tabelObat.getValueAt(rows,2).toString();
        txtNama.setText(nama);
        String jenis = tabelObat.getValueAt(rows,3).toString();
        cbJenis.setSelectedItem(jenis);
        String stok = tabelObat.getValueAt(rows,4).toString();
        txtStok.setText(stok);
        String kategori = tabelObat.getValueAt(rows,5).toString();
        cbKategori.setSelectedItem(kategori);
        String harga = tabelObat.getValueAt(rows,6).toString();
        txtHarga.setText(harga);
    }//GEN-LAST:event_tabelObatMouseClicked

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
            java.util.logging.Logger.getLogger(Apotek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apotek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apotek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apotek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apotek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btHapus;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btTambah;
    private javax.swing.JComboBox<String> cbJenis;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelObat;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStok;
    // End of variables declaration//GEN-END:variables

    private static class KoneksiDB {

        public KoneksiDB() {
        }
        private static Connection SQLconn;
        public static Connection connDB()throws SQLException{
        
        try{
           String url = "jdbc:mysql://localhost:3306/apotek";
           String user = "root";
           String password = "";
           
           DriverManager.registerDriver(new com.mysql.jdbc.Driver());
           SQLconn = DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            System.out.println("Gagal koneksi : "+e.getMessage());
        }
        return SQLconn;
    }
    }
}
