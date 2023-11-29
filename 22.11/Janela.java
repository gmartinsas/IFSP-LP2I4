import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Janela implements ActionListener {
    private JFrame jPrincipal = new JFrame("Trabalho Prático 05");

    private JLabel lblMax, lblPri1, lblPri2, lblFinal1, lblFinal2;
    private JTextField campoMax;
    private JSpinner spn1, spn2;
    private JScrollPane srcCampo1, srcCampo2;
    private JButton btnInicio, btnTermino;

    JList<String> strCampo1 = new JList<>();
    JList<String> strCampo2 = new JList<>();

    public Janela() {
        super();

        // Parte de Informações
        JPanel infoPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        lblMax = new JLabel("Máximo:");
        campoMax = new JTextField(20);
        infoPanel.add(lblMax);
        infoPanel.add(campoMax);

        lblPri1 = new JLabel("Prioridade - Thread 1:");
        SpinnerModel m1 = new SpinnerNumberModel(1, 1, 10, 1);
        spn1 = new JSpinner(m1);
        infoPanel.add(lblPri1);
        infoPanel.add(spn1);

        lblPri2 = new JLabel("Prioridade - Thread 2:");
        SpinnerModel m2 = new SpinnerNumberModel(1, 1, 10, 1);
        spn2 = new JSpinner(m2);
        infoPanel.add(lblPri2);
        infoPanel.add(spn2);

        btnInicio = new JButton("Iniciar");
        btnInicio.addActionListener(this);
        infoPanel.add(btnInicio);

        // Parte de Resultados
        JPanel resultPanel = new JPanel(new GridLayout(3,2,10,10));

        srcCampo1 = new JScrollPane(strCampo1);
        srcCampo2 = new JScrollPane(strCampo2);
        resultPanel.add(srcCampo1);
        resultPanel.add(srcCampo2);

        lblFinal1 = new JLabel("");
        lblFinal2 = new JLabel("");
        resultPanel.add(lblFinal1);
        resultPanel.add(lblFinal2);

        btnTermino = new JButton("Limpar");
        btnTermino.addActionListener(this);
        resultPanel.add(btnTermino);

        // Propriedades da Janela
        jPrincipal.add(infoPanel, BorderLayout.NORTH);
        jPrincipal.add(resultPanel, BorderLayout.SOUTH);

        jPrincipal.setSize(600,700);
        jPrincipal.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnInicio) {
            int max = Integer.parseInt(campoMax.getText());
            int p1 = (int) spn1.getValue();
            int p2 = (int) spn2.getValue();

            Thread t01 = new Thread(() -> {
                DefaultListModel<String> m1 = new DefaultListModel<>();
                for (int i = 0; i < max; i++) {
                    m1.addElement("Thread 01 - " + i);
                    strCampo1.setModel(m1);
                    try {
                        Thread.sleep(750);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                lblFinal1.setText("Thread finalizada!");

            });

            t01.setPriority(p1);

            Thread t02 = new Thread(() -> {
                DefaultListModel<String> m2 = new DefaultListModel<>();
                for (int i = 0; i < max; i++) {
                    m2.addElement("Thread 02 - " + i);
                    strCampo2.setModel(m2);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

                lblFinal2.setText("Thread finalizada!");

            });
            
            t02.setPriority(p2);

            t01.start();
            t02.start();

        } else if (e.getSource() == btnTermino) {
            DefaultListModel<String> m1 = new DefaultListModel<>();
            DefaultListModel<String> m2 = new DefaultListModel<>();
            
            strCampo1.setModel(m1);
            strCampo2.setModel(m2);

            campoMax.setText("");
            spn1.setValue(1);
            spn2.setValue(1);

            lblFinal1.setText("");
            lblFinal2.setText("");            
        }
    }
}
