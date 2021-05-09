/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package withoutpbo;

/**
 *
 * @author BimoElsaIndira
 */
import javax.swing.JOptionPane;
public class Apotek3 {
   public static void main(String[] args) {

//Perintah meginputkan data
        String kode = "";
        kode=JOptionPane.showInputDialog("Inputkan Kode Obat  : ");
        String nama = "";
        nama=JOptionPane.showInputDialog("Inputkan Nama : ");
        String jenis = "";
        jenis=JOptionPane.showInputDialog("Inputkan Jenis : ");
        String stok = "";
        stok=JOptionPane.showInputDialog("Inputkan Stok : ");
        String kategori = "";
        kategori=JOptionPane.showInputDialog("Inputkan Kategori : ");
        String harga = "";
        harga=JOptionPane.showInputDialog("Inputkan Harga : ");
        //Menampilkan data yang telah di input
        javax.swing.JOptionPane.showMessageDialog(null,"Kode Obat : "+kode
                +"\nNama    : "+nama
                +"\nJenis   : "+jenis
                +"\nStok    : "+stok
                +"\nKategori: "+kategori
                +"\nHarga   : "+harga);

    } 
}
