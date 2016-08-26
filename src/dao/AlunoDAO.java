
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Aluno;
import model.Imc;
import model.Indice;
import model.Modalidade;


public class AlunoDAO {
    
    private DataBase db;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    public AlunoDAO(){
       db = new DataBase();
       
    }
    
    public boolean insert(Aluno aluno) {
       if (db.open()){
           sql= "INSERT INTO tb_alunos (ALU_NOME, ALU_CPF, ALU_ENDERECO, ALU_SEXO, ALU_TELEFONE1, ALU_TELEFONE2, ALU_EMAIL, "
                   + "ALU_DATANASC, ALU_OBSERVACAO, ALU_ALTURA) VALUES (?, ?, ?, ?,?, ?,?,?,?,?);";
           try{
              ps= db.connection.prepareStatement(sql);
              ps.setString(1, aluno.getNome());
              ps.setString(2,aluno.getCpf());
              ps.setString(3,aluno.getEndereco());
              ps.setString(4,aluno.getSexo());
              ps.setString(5,aluno.getTelefone1());
              ps.setString(6,aluno.getTelefone2());
              ps.setString(7,aluno.getEmail());
              ps.setDate(8, (Date) aluno.getDatanasc().getTime());
              ps.setString(9,aluno.getObservacao());
              ps.setInt(10,aluno.getAltura());
              
              
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
   public boolean delete (Aluno aluno){
       if (db.open()){
        sql= "DELETE FROM tb_alunos WHERE ALU_ID = ? ";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setInt(1,aluno.getMatricula());
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
   
   public boolean update (Aluno aluno){
       if (db.open()){
        sql= "UPDATE tb_alunos SET ALU_NOME = ?, ALU_CPF=?, ALU_ENDERECO=?, ALU_SEXO=?, ALU_TELEFONE1=?, ALU_TELEFONE2=?, "
                + "ALU_EMAIL=?, ALU_DATANASC=?, ALU_OBSERVACAO=?, ALU_ALTURA=? WHERE ALU_ID = ?;";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setString(1, aluno.getNome());
               ps.setString(2,aluno.getCpf());
               ps.setString(3,aluno.getEndereco());
               ps.setString(4,aluno.getSexo());
               ps.setString(5,aluno.getTelefone1());
               ps.setString(6,aluno.getTelefone2());
               ps.setString(7,aluno.getEmail());
               ps.setDate(8, (Date) aluno.getDatanasc().getTime());
               ps.setString(9,aluno.getObservacao());
               ps.setInt(10,aluno.getAltura());
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
   
   public List<Aluno> selectAll(){
     if (db.open()){
       List<Aluno> alunos = new ArrayList();
       sql = "SELECT * FROM tb_alunos";
       try {
           ps = db.connection.prepareStatement(sql);
           rs= ps.executeQuery();
           while (rs.next()){
                 Aluno aluno = new Aluno();
                 aluno.setMatricula(rs.getInt(1));
                 aluno.setNome(rs.getString(2));
                 aluno.setCpf(rs.getString(3));
                 aluno.setEndereco(rs.getString(4));
                 aluno.setSexo(rs.getString(5));
                 aluno.setTelefone1(rs.getString(6));
                 aluno.setTelefone2(rs.getString(7));
                 aluno.setEmail(rs.getString(8));
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate(9));
                 aluno.setDatanasc(data);
                 aluno.setObservacao(rs.getString(10));
                 aluno.setAltura(rs.getInt(11));
                 
                 alunos.add(aluno);    
           
           }
           rs.close();
           ps.close();
           db.close();
           return alunos;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
       
   }
   public List<Aluno> selectFilter(String filter){
   if (db.open()){
       List<Aluno> alunos = new ArrayList();
       String filtro = "%"+filter +"%";
       sql = "SELECT * FROM tb_alunos WHERE ALU_NOME LIKE ? OR ALU_CPF LIKE ? OR ALU_SEXO LIKE ? "
               + "OR ALU_ENDERECO LIKE? OR ALU_EMAIL LIKE ? OR ALU_OBSERVACAO LIKE ?;";
       try {
           ps = db.connection.prepareStatement(sql);
           ps.setString(1, filtro);
           ps.setString(2, filtro);
           ps.setString(3, filtro);
           ps.setString(4, filtro);
           ps.setString(5, filtro);
           ps.setString(6, filtro);
           rs= ps.executeQuery();
           while (rs.next()){
                 Aluno aluno = new Aluno();
                 aluno.setMatricula(rs.getInt(1));
                 aluno.setNome(rs.getString(2));
                 aluno.setCpf(rs.getString(3));
                 aluno.setEndereco(rs.getString(4));
                 aluno.setSexo(rs.getString(5));
                 aluno.setTelefone1(rs.getString(6));
                 aluno.setTelefone2(rs.getString(7));
                 aluno.setEmail(rs.getString(8));
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate(9));
                 aluno.setDatanasc(data);
                 aluno.setObservacao(rs.getString(10));
                 aluno.setAltura(rs.getInt(11));
                 alunos.add(aluno);       
           
           }
           rs.close();
           ps.close();
           db.close();
           return alunos;
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
   
   }
   
   public Aluno select(int id){
   if (db.open()){
       sql = "SELECT * FROM tb_alunos WHERE ALU_ID = ?;";
       
       try {
           ps = db.connection.prepareStatement(sql);
           ps.setInt(1, id);
           rs= ps.executeQuery();  
           if (rs.next()){
                 Aluno aluno = new Aluno();
                 aluno.setMatricula(rs.getInt(1));
                 aluno.setNome(rs.getString(2));
                 aluno.setCpf(rs.getString(3));
                 aluno.setEndereco(rs.getString(4));
                 aluno.setSexo(rs.getString(5));
                 aluno.setTelefone1(rs.getString(6));
                 aluno.setTelefone2(rs.getString(7));
                 aluno.setEmail(rs.getString(8));
                 Calendar data = Calendar.getInstance();
                 data.setTime(rs.getDate(9));
                 aluno.setDatanasc(data);
                 aluno.setObservacao(rs.getString(10));
                 aluno.setAltura(rs.getInt(11));
                  
                 rs.close();
                 ps.close();
                 db.close();    
                 return aluno;
           }
         
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
   
   }
   
    public boolean insertmoda(Aluno aluno) {
       if (db.open()){
           sql= "INSERT INTO tb_alunos_modalidades (AMD_ALU_ID, AMD_MOD_ID) VALUES (?, ?);";
           try{
              ps= db.connection.prepareStatement(sql);
              ModalidadeDAO dao = new ModalidadeDAO();
             for (Modalidade m : dao.selectAll()) {
                 ps.setInt(1, aluno.getMatricula());
                 ps.setInt(2, m.getId());
             }
              
              
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
    
            
        public boolean insertimc(Aluno aluno) {
       if (db.open()){
           sql= "INSERT INTO tb_imc_alunos (IAL_ALU_ID, IAL_IMC_ID) VALUES (?, ?);";
           try{
              ps= db.connection.prepareStatement(sql);
              ImcDAO dao = new ImcDAO();
             for (Imc i : dao.selectAll()) {
                 ps.setInt(1, aluno.getMatricula());
                 ps.setInt(2, i.getId());
             }
              
              
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

    public boolean insertindice(Aluno aluno) {
       if (db.open()){
           sql= "INSERT INTO tb_alunos_indices (AID_ALU_ID, AID_IND_ID) VALUES (?, ?); ";
           try{
              ps= db.connection.prepareStatement(sql);
              IndiceDAO dao = new IndiceDAO();
             for (Indice in : dao.selectAll()) {
                 ps.setInt(1, aluno.getMatricula());
                 ps.setInt(2, in.getId());
             }
              
              
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
    
     public boolean deletemodindaluno (Aluno aluno){
       if (db.open()){
        sql= "DELETE FROM tb_alunos_modalidades join tb_alunos on alu_id = amd_alu_id "
                + " WHERE alu_ID = ?; DELETE FROM tb_alunos_indices "
                + "join tb_alunos on alu_id = ain_alu_id where alu_id = ?;";
           try{
               ps = db.connection.prepareStatement(sql);
               ps.setInt(1,aluno.getMatricula());
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
    
    public Aluno selectAlModaInd(int id){
   if (db.open()){
       sql = "SELECT alu_id, alu_nome, alu_observacao, mod_nome, ind_indice FROM tb_alunos join tb_alunos_modalidades \n" +
"on amd_alu_id = alu_id join tb_modalidades on amd_mod_id = mod_id join tb_modalidades_indices \n" +
"on mid_mod_id = mod_id join tb_indices \n" +
"on mid_ind_id = ind_id join tb_alunos_indices \n" +
"on ain_ind_id = ind_id  WHERE ALU_ID = ?;";
                
       try {
           ps = db.connection.prepareStatement(sql);
           ps.setInt(1, id);
           rs= ps.executeQuery();  
           if (rs.next()){
                 Aluno aluno = new Aluno();
                 aluno.setMatricula(rs.getInt(1));
                 aluno.setNome(rs.getString(2));
                 aluno.setObservacao(rs.getString(3));
                 Modalidade modalidade = new Modalidade();
                 modalidade.setModalidade(rs.getString(4));
                 Indice indice = new Indice();
                 indice.setIndice(rs.getString(5));
                 
                 rs.close();
                 ps.close();
                 db.close();    
                 return aluno;
           }
         
       }catch (SQLException error){
          System.out.println("ERRO: "+ error.toString());
       
       }
     
     }
       db.close();
         return null;
   
   }
    
    
    
}
    
    

