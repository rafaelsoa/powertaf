package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Imc;
import model.Indice;



public class IndiceDAO {
    
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public IndiceDAO(){
       db = new DataBase();
       
    }
    
    public boolean insert(Indice indice) {
       if (db.open()){
           sql= "INSERT INTO tb_indice (IND_DATA, IND_INDICE, IND_OBSERVACAO) VALUES (?, ?,?)";
           try{
              ps= db.connection.prepareStatement(sql);
              ps.setDate(1, (Date) indice.getData().getTime());
              ps.setString(2, indice.getIndice());
              ps.setString(3,indice.getObservacao());
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
   public boolean delete (Indice indice){
       if (db.open()){
        sql= "DELETE FROM tb_indice WHERE Ind_ID = ? ";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setInt(1,indice.getId());
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
   
   public boolean update (Indice indice){
       if (db.open()){
        sql= "UPDATE tb_indice SET ind_data = ?, ind_indice=? ind_observacao WHERE ind_id = ?";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setDate(1, (Date) indice.getData().getTime());
               ps.setString(2, indice.getIndice());
               ps.setString(3,indice.getObservacao());
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
   
   
    public List<Indice> selectAll(){
     if (db.open()){
       List<Indice> indices = new ArrayList();
       sql = "SELECT * FROM tb_indice";
       try {
           ps = db.connection.prepareStatement(sql);
           rs= ps.executeQuery();
           while (rs.next()){
                 Indice indice = new Indice();
                 indice.setId(rs.getInt(1));
                 indice.setIndice(rs.getString(2));
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate(3));
                 indice.setData(data);
                 indices.add(indice);    
                 indice.setObservacao(rs.getString(4));
           }
           rs.close();
           ps.close();
           db.close();
           return indices;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
       
   }
   

    
}
