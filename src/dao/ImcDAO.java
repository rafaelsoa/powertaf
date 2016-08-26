
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Imc;



public class ImcDAO {
    
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public ImcDAO(){
       db = new DataBase();
       
    }
    
    public boolean insert(Imc imc) {
       if (db.open()){
           sql= "INSERT INTO tb_imc (IMC_PESO, IMC_DATA) VALUES (?, ?)";
           try{
              ps= db.connection.prepareStatement(sql);
              ps.setInt(1, imc.getPeso());
              ps.setDate(2, (Date) imc.getData().getTime());
              
              if (ps.executeUpdate()== 1){
                 ps.close();
                 db.close();
                 return true;
              }
           } catch (SQLException error){
             System.out.println("ERRO: "+ error.toString());
           
           }
      }
       db.close();
       return false;
       
       
    }
   public boolean delete (Imc imc){
       if (db.open()){
        sql= "DELETE FROM tb_imc WHERE IMC_ID = ? ";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setInt(1,imc.getId());
               if(ps.executeUpdate() == 1){
                  ps.close();
                  db.close();
                  return true;
               }
           
           } catch (SQLException error){
             System.out.println("ERRO: "+ error.toString());
           
           }
      }
       db.close();
       return false;
      
   }
   
   public boolean update (Imc imc){
       if (db.open()){
        sql= "UPDATE tb_imc SET imc_peso = ?,  imc_data=? WHERE imc_id = ?";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setInt(1, imc.getPeso());
               ps.setDate(2, (Date) imc.getData().getTime());
               if (ps.executeUpdate() ==1){
                  ps.close();
                  db.close();
                  return true;
           }
           
           } catch (SQLException error){
             System.out.println("ERRO: "+ error.toString());
           
           }
      }
         db.close();
         return false;
       
   }
   
   
    public List<Imc> selectAll(){
     if (db.open()){
       List<Imc> imcs = new ArrayList();
       sql = "SELECT * FROM tb_imc";
       try {
           ps = db.connection.prepareStatement(sql);
           rs= ps.executeQuery();
           while (rs.next()){
                 Imc imc = new Imc();
                 imc.setId(rs.getInt(1));
                 imc.setPeso(rs.getInt(2));
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate(3));
                 imc.setData(data);
                 imcs.add(imc);    
           
           }
           rs.close();
           ps.close();
           db.close();
           return imcs;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
       
   }
   
   
   public List<Imc> selectFilter(String filter){
   if (db.open()){
       List<Imc> imcs = new ArrayList();
       String filtro = "%"+filter +"%";
       sql = "SELECT * FROM tb_imcs WHERE IMC_ID LIKE ?";
       try {
           ps = db.connection.prepareStatement(sql);
           ps.setString(1, filtro);
           rs= ps.executeQuery();
           while (rs.next()){
                 Imc imc = new Imc();
                 imc.setId(rs.getInt(1));
                 imc.setPeso(rs.getInt(2));
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate(3));
                 imc.setData(data);
                 imcs.add(imc);    
                 
                 imcs.add(imc);          
           
           }
           rs.close();
           ps.close();
           db.close();
           return imcs;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
   
   }
   
  
    
}
