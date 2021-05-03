/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BimoElsaIndira;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author LENOVO LEGION Y540
 */
public class KoneksiDB {
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
