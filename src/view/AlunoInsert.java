package view;

import controller.AlunoCTRL;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import model.Aluno;


public class AlunoInsert extends JFrame{

    private JLabel lbNome,lbCpf , lbFone;
    private JTextField tfNome;
    private JFormattedTextField tfCpf;
    private JFormattedTextField ftFone;
    private MaskFormatter mask;
    private DefaultTableModel model;
    private JButton btSalvar;
    private Aluno aluno;

    public AlunoInsert(Aluno aluno, DefaultTableModel model) {
        this.aluno = aluno;
        this.model = model;
        setConponents();
        setEvents();
    }

    private void setConponents() {
        setLayout(null);
        setResizable(false);
        setBounds(0,0,380,380);
        lbNome = new JLabel("Nome");
        lbNome.setBounds(10,10,80,25);
        add(lbNome);
        tfNome = new JTextField();
        tfNome.setBounds(10,35,150,32);
        add(tfNome);
        
        lbCpf = new JLabel("Nome");
        lbCpf.setBounds(10,10,80,25);
        add(lbCpf);
        try{
        mask = new MaskFormatter("###.###.###-##");
        }catch(ParseException erro){
            System.out.println("ERRO: "+ erro.toString());
        }
        tfCpf = new JFormattedTextField(mask);
        tfCpf.setBounds(10,35,150,32);
        add(tfCpf);
        
        lbFone = new JLabel("Fone");
        lbFone.setBounds(170,10,80,25);
        add(lbFone);
        try{
        mask = new MaskFormatter("(##) #####-####");
        }catch(ParseException erro){
            System.out.println("ERRO: "+ erro.toString());
        }
        
        ftFone = new JFormattedTextField(mask);
        ftFone.setBounds(170,35,130,32);
        add(ftFone);
        
        
        btSalvar = new  JButton(new ImageIcon("images/icons/save.png"));
        btSalvar.setBounds(320,35,32,32);
        btSalvar.setBackground(new Color(238,238,238));
        btSalvar.setBorder(null);
        add(btSalvar);
        if(aluno == null){
            setIconImage(new ImageIcon("images/icons/add.png").getImage());
            setTitle("Novo Aluno");
        }else{
            setIconImage(new ImageIcon("images/icons/edit.png").getImage());
            setTitle("Editar Aluno");
            tfNome.setText(aluno.getNome());
            ftFone.setText(aluno.getTelefone1());
        }
    }

    private void setEvents() {
        btSalvar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfNome.getText().equals("")){
                JOptionPane.showMessageDialog(null, "campos obrigatorios");
            }else{
              AlunoCTRL aluno = new AlunoCTRL();
                if(aluno == null){
                    if(aluno.insert(tfNome.getText(),tfCpf.getTexT(),ftFone.getText()){
                        loadTable();
                        setVisible(false);
                    }else{
                     JOptionPane.showMessageDialog(null, "Falha ao tentar adcionar");
                    }
                }else{
                   if(aluno.update(aluno.getMatricula(), tfNome.getText()){
                   loadTable();
                    setVisible(false);
                   }else{
                   JOptionPane.showMessageDialog(null, "Falha ao tentar atualizar");
                   }
                }
            }      
                    
                }            
        });
    }
    
    private void loadTable() {
        model.setRowCount(0);
        for(Aluno aluno: new AlunoCTRL().selectAll(null)){
        model.addRow(new Object[] {aluno.getMatricula(),aluno.getNome(),aluno.getCpf()});
        }
            }
    
    public void open(){
            AlunoInsert frame = new AlunoInsert(aluno, model);
            Dimension window = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (window.width - frame.getSize().width)/2;
            int y = (window.height - frame.getSize().height)/2;
            frame.setLocation(x,y);
            frame.setVisible(true);
        }
        
    
    
}
