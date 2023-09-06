// Gabriel Martins - CB3021521

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InterfaceTP02 {
    public static void main(String[] args) {
        Frame interfacePrograma = new Frame("Trabalho Prático 2");
        interfacePrograma.setSize(400, 180);
        interfacePrograma.addWindowListener(new FechaJanela());

        // Lista em Memória de Alunos
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        
        // Componente 1
        Container form = new Container();
        form.setLayout(new GridLayout(3, 2, 10, 10));

        Label lblNome = new Label("Nome:");
        TextField boxNome = new TextField(30);

        Label lblIdade = new Label("Idade:");
        TextField boxIdade = new TextField();

        Label lblEndereco = new Label("Endereço:");
        TextField boxEndereco = new TextField();
        
        form.add(lblNome);
        form.add(boxNome);

        form.add(lblIdade);
        form.add(boxIdade);

        form.add(lblEndereco);
        form.add(boxEndereco);
        
        interfacePrograma.add(form, BorderLayout.NORTH);

        // Componente 2
        Container bttns = new Container();
        bttns.setLayout(new GridLayout(1, 4, 1, 0));

        Button btnOk = new Button("Ok");
        Button btnLimpar = new Button("Limpar");
        Button btnMostrar = new Button("Mostrar");
        Button btnSair = new Button("Sair");


        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Aluno aluno = new Aluno(boxNome.getText(), Integer.parseInt(boxIdade.getText()), boxEndereco.getText());
                listaAlunos.add(aluno);
                // listaAlunos.get(0) mostra A POSIÇÃO EM MEMÓRIA do 0 
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boxNome.setText(" ");
                boxIdade.setText(" ");
                boxEndereco.setText(" ");
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mensagem = "";

                for (int i = 0; i < listaAlunos.size(); i++) {
                    if (listaAlunos.get(i) != null) {
                        mensagem += "UUID: " + listaAlunos.get(i).getUUID() + " Nome: " + listaAlunos.get(i).getNome() + "\n";
                    }
                }
                JOptionPane.showMessageDialog(interfacePrograma, mensagem);
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        bttns.add(btnOk);
        bttns.add(btnLimpar);
        bttns.add(btnMostrar);
        bttns.add(btnSair);
        
        interfacePrograma.add(bttns, BorderLayout.SOUTH);
        
        // Mostrando o programa na tela
        interfacePrograma.setVisible(true);   
    }
}
