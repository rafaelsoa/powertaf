
package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Modalidade;


public class ModalidadeDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public ModalidadeDAO(){
       db = new DataBase();
       
    }
    
    public boolean insert(Modalidade modalidade) {
       if (db.open()){
           sql= "INSERT INTO tb_modalidades (MOD_NOME, MOD_OBSERVACAO) VALUES (?, ?)";
           try{
              ps= db.connection.prepareStatement(sql);
              ps.setString(1, modalidade.getModalidade());
              ps.setString(2,modalidade.getObservacao());
              
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
   public boolean delete (Modalidade modalidade){
       if (db.open()){
        sql= "DELETE FROM tb_modalidades WHERE MOD_ID = ? ";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setInt(1,modalidade.getId());
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
   
   public boolean update (Modalidade modalidade){
       if (db.open()){
        sql= "UPDATE tb_modalidades SET MOD_NOME = ?,  ALU_OBSERVACAO=? WHERE MOD_ID = ?";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setString(1, modalidade.getModalidade());
               ps.setString(2,modalidade.getObservacao());
              
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
   
   public List<Modalidade> selectAll(){
     if (db.open()){
       List<Modalidade> modalidades = new ArrayList();
       sql = "SELECT * FROM tb_modalidades";
       try {
           ps = db.connection.prepareStatement(sql);
           rs= ps.executeQuery();
           while (rs.next()){
                 Modalidade modalidade = new Modalidade();
                 modalidade.setId(rs.getInt(1));
                 modalidade.setModalidade(rs.getString(2));
                 modalidade.setObservacao(rs.getString(3));
                 
                modalidades.add(modalidade);    
           
           }
           rs.close();
           ps.close();
           db.close();
           return modalidades;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
       
   }
   public List<Modalidade> selectFilter(String filter){
   if (db.open()){
       List<Modalidade> modalidades = new ArrayList();
       String filtro = "%"+filter +"%";
       sql = "SELECT * FROM tb_modalidades WHERE MOD_NOME LIKE ?";
       try {
           ps = db.connection.prepareStatement(sql);
           ps.setString(1, filtro);
           rs= ps.executeQuery();
           while (rs.next()){
                 Modalidade modalidade = new Modalidade();
                 modalidade.setId(rs.getInt(1));
                 modalidade.setModalidade(rs.getString(2));
                 modalidade.setObservacao(rs.getString(3));
                 
                 modalidades.add(modalidade);          
           
           }
           rs.close();
           ps.close();
           db.close();
           return modalidades;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
   
   }
   
   public Modalidade select(int id){
   if (db.open()){
       sql = "SELECT * FROM tb_modalidades WHERE MOD_ID = ?";
       
       try {
           ps = db.connection.prepareStatement(sql);
           ps.setInt(1, id);
           rs= ps.executeQuery();  
           if (rs.next()){
                 Modalidade modalidade = new Modalidade();
                 modalidade.setId(rs.getInt(1));
                 modalidade.setModalidade(rs.getString(2));
                 modalidade.setObservacao(rs.getString(3));
                  
                 rs.close();
                 ps.close();
                 db.close();    
                 return modalidade;
           }
         
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
   
   }
    
    
}
