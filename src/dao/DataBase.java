
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataBase {
    

    public Connection connection = null;
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE = "powertaf";
    private final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private final String USER = "root";
    private final String PASSWORD = "senac";

    public boolean open() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONNECTADO");
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("DRIVER NÃO ENCONTRADO");
            System.out.println("ERRO: " + erro.toString());
            return false;
        } catch (SQLException erro) {
            System.out.println("PROBLEMAS COM A CONECÇÃO");
            System.out.println("ERRO: " + erro.toString());
            return false;
        }
    }
    
    public boolean close(){
       try{
          connection.close();
          System.out.println("DISCONNECTADO");
          return true;
       }catch(SQLException error){
           System.out.println("PROBLEMAS COM A DISCONECTIÇÃO");
           System.out.println("ERRO: " + error.toString());
       }
         return false;
    }
}
    
    
 
