import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import com.google.gson.Gson;

public class CadastroAlunoAcademia extends JFrame {
    private JTextField nomeField, idadeField, pesoField, alturaField, objetivoField;
    private Connection con;

    public CadastroAlunoAcademia() {
        setTitle("Cadastro de Aluno de Academia");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(50, 30, 80, 25);
        panelPrincipal.add(nomeLabel);

        nomeField = new JTextField(20);
        nomeField.setBounds(150, 30, 200, 25);
        panelPrincipal.add(nomeField);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(50, 60, 80, 25);
        panelPrincipal.add(idadeLabel);

        idadeField = new JTextField(20);
        idadeField.setBounds(150, 60, 200, 25);
        panelPrincipal.add(idadeField);

        JLabel pesoLabel = new JLabel("Peso:");
        pesoLabel.setBounds(50, 90, 80, 25);
        panelPrincipal.add(pesoLabel);

        pesoField = new JTextField(20);
        pesoField.setBounds(150, 90, 200, 25);
        panelPrincipal.add(pesoField);

        JLabel alturaLabel = new JLabel("Altura:");
        alturaLabel.setBounds(50, 120, 80, 25);
        panelPrincipal.add(alturaLabel);

        alturaField = new JTextField(20);
        alturaField.setBounds(150, 120, 200, 25);
        panelPrincipal.add(alturaField);

        JLabel objetivoLabel = new JLabel("Objetivo:");
        objetivoLabel.setBounds(50, 150, 80, 25);
        panelPrincipal.add(objetivoLabel);

        objetivoField = new JTextField(20);
        objetivoField.setBounds(150, 150, 200, 25);
        panelPrincipal.add(objetivoField);

        JButton incluirButton = new JButton("Incluir");
        incluirButton.setBounds(50, 200, 80, 25);
        incluirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jsonString = "{nome: " + nomeField.getText() + ", idade: " + idadeField.getText() + ", peso: " + pesoField.getText() + ", altura: " + alturaField.getText() + ", objetivo: " + objetivoField.getText() + "}";
                try {
                    String url = "jdbc:sqlserver://127.0.0.1:\\\\SQLEXPRESS;databaseName=TrabalhoCadastro;integratedSecurity=true";
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    Connection conn = DriverManager.getConnection(url);
                    String sql = "INSERT INTO TrabalhoCadastro VALUES (?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, jsonString);

                    stmt.executeUpdate();
                    
                    stmt.close();
                    conn.close();
                    
                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Aluno incluído no banco de dados.");
                
            }
        });
        panelPrincipal.add(incluirButton);

        JButton limparButton = new JButton("Limpar");
        limparButton.setBounds(150, 200, 80, 25);
        limparButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeField.setText("");
                idadeField.setText("");
                pesoField.setText("");
                alturaField.setText("");
                objetivoField.setText("");
            }
        });
        panelPrincipal.add(limparButton);

        JButton apresentarButton = new JButton("Apresentar Dados");
        apresentarButton.setBounds(250, 200, 150, 25);
        apresentarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Gson gson = new Gson();
                String json = gson.toJson(a1);                
                Aluno a1 = new Aluno(nomeField.getText(), idadeField.getText(), pesoField.getText(), alturaField.getText(), objetivoField.getText());
                JOptionPane.showMessageDialog(null, a1.mostraAluno(), "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panelPrincipal.add(apresentarButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setBounds(150, 230, 80, 25);
        sairButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelPrincipal.add(sairButton);

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        CadastroAlunoAcademia cadastro = new CadastroAlunoAcademia();
        cadastro.setVisible(true);
    }
}

class Aluno {
    private String nome, idade, altura, peso, objetivo;

    public Aluno(String n, String i, String p, String a, String o) {
        this.nome = n;
        this.idade = i;
        this.peso = p;
        this.altura = a;
        this.objetivo = o;
    }

    public String mostraAluno() {
        return "{\n   nome: " + nome + ",\n   idade: " + idade + ",\n   peso: " + peso + ",\n   altura: " + altura + ",\n   objetivo: " + objetivo + "\n}";
    }
}
