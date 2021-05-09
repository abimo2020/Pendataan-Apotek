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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Apotek2 {
public static void main(String[] args) {
// TODO code application logic here
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
int data =0;
int[]    kode           = new int[30];
String[] nama           = new String[15];
String[] jenis          = new String[10];
int[]    stok           = new int[50];
String[] kategori       = new String[50];
int[]    harga          = new int[10];

System.out.println("TABEL OBAT");
System.out.println("+===============INPUTAN============================+");
try{
    System.out.println("Masukkan banyak data = ");
    data = Integer.parseInt(input.readLine());
    for (int a=1;a<=data;a++){
         System.out.println("------Data ke-"+ a +"------");
         System.out.println("Masukan Kode Obat        = ");
            kode[a] = Integer.parseInt(input.readLine());
         System.out.println("Masukan Nama Obat        = ");
            nama[a] = input.readLine();
         System.out.println("Masukan Jenis Obat       = ");
            jenis[a] = input.readLine();
         System.out.println("Masukan Stok Obat        = ");
            stok[a] = Integer.parseInt(input.readLine());
         System.out.println("Masukan Kategori         = ");
            kategori[a] = input.readLine();
         System.out.println("Masukan Harga            = ");
            harga[a] = Integer.parseInt(input.readLine());
     }
} catch (IOException e ){
  System.out.println("Error");
}
 
System.out.println("+==============HASIL OUTPUT========================+");
System.out.println("Banyak data : " + data);
for (int a=1; a<=data;a++){
    System.out.println("Data Obat ke- " + a);
    System.out.println("Kode    : "+ kode[a]);
    System.out.println("Nama    : "+ nama[a]);
    System.out.println("Jenis   : "+ jenis[a]);
    System.out.println("Stok    : "+ stok[a]);
    System.out.println("Kategori: "+ kategori[a]);
    System.out.println("Harga   : "+ harga[a]);
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}
}    
}
