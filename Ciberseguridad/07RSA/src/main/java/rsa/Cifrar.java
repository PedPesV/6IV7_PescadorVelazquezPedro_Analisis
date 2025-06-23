package rsa;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.math.BigInteger;

public class Cifrar extends JFrame {

    private JButton btnRegresar;
    private JButton btnCifrar;
    private JLabel txtresp, txtresq, txtresn, txtresfi, txtrese, txtresd;
    private JTextField numacifrar;
    private JTextArea numcifrado;
    BigInteger n, p, q;
    BigInteger fi; 
    BigInteger e, d;
    String mensaje;
    

    public Cifrar() {
        setTitle("Cifrar");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Parte superior con el botón regresar y título
        mainPanel.add(crearPanelSuperior(), BorderLayout.NORTH);
        // Parte central con parámetros RSA y campos de entrada/salida
        mainPanel.add(crearPanelContenido(), BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel crearPanelSuperior() {
        JPanel topPanel = new JPanel(new BorderLayout());

        // Botón regresar
        JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnRegresar = new JButton("Regresar");
        topButtonPanel.add(btnRegresar);
        topPanel.add(topButtonPanel, BorderLayout.NORTH);
        btnRegresar.addActionListener(e -> regresarVentana());

        // Título
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Cifrar", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(title);
        topPanel.add(titlePanel, BorderLayout.CENTER);
        
        return topPanel;
    }

    private JPanel crearPanelContenido() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(30, 0, 0, 0));

        // Parámetros RSA (3x2 grid)
        JPanel rsaPanel = new JPanel(new GridLayout(2, 3, 50, 30));
        rsaPanel.setBorder(new EmptyBorder(0, 50, 40, 50));

        rsaPanel.add(crearCampoRSA("p", txtresp = new JLabel("", JLabel.CENTER)));
        rsaPanel.add(crearCampoRSA("q", txtresq = new JLabel("", JLabel.CENTER)));
        rsaPanel.add(crearCampoRSA("n", txtresn = new JLabel("", JLabel.CENTER)));
        rsaPanel.add(crearCampoRSA("fi", txtresfi = new JLabel("", JLabel.CENTER)));
        rsaPanel.add(crearCampoRSA("e", txtrese = new JLabel("", JLabel.CENTER)));
        rsaPanel.add(crearCampoRSA("d", txtresd = new JLabel("", JLabel.CENTER)));

        contentPanel.add(rsaPanel, BorderLayout.NORTH);

        // Campo "Número a Cifrar"
        JPanel inputSection = new JPanel(new BorderLayout());
        inputSection.setBorder(new EmptyBorder(20, 50, 20, 50));

        JLabel lblNumeroCifrar = new JLabel("Número a Cifrar");
        inputSection.add(lblNumeroCifrar, BorderLayout.NORTH);

        JPanel textFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        numacifrar = new JTextField(20);
        numacifrar.setFont(new Font("Arial", Font.PLAIN, 18));
        textFieldPanel.add(numacifrar);
        inputSection.add(textFieldPanel, BorderLayout.CENTER);

        contentPanel.add(inputSection, BorderLayout.CENTER);

        // Panel inferior con botón Cifrar y resultado
        JPanel bottomSection = new JPanel(new BorderLayout());
        bottomSection.setBorder(new EmptyBorder(10, 50, 0, 50));

        // Botón Cifrar
        JPanel cifrarButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCifrar = new JButton("Cifrar");
        cifrarButtonPanel.add(btnCifrar);
        bottomSection.add(cifrarButtonPanel, BorderLayout.NORTH);
        btnCifrar.addActionListener(e -> cifrarNumero());

        // Resultado
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(new EmptyBorder(20, 0, 0, 0));

        JLabel lblNumeroCifrado = new JLabel("Número cifrado");
        resultPanel.add(lblNumeroCifrado, BorderLayout.NORTH);

        JPanel resultFieldPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        numcifrado = new JTextArea(1, 20);
        numcifrado.setLineWrap(true);
        numcifrado.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(numcifrado);
        resultFieldPanel.add(scrollPane2);
        resultPanel.add(resultFieldPanel, BorderLayout.CENTER);

        bottomSection.add(resultPanel, BorderLayout.CENTER);
        contentPanel.add(bottomSection, BorderLayout.SOUTH);

        return contentPanel;
    }

    private JPanel crearCampoRSA(String label, JLabel valueLabel) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel(label, JLabel.CENTER), BorderLayout.NORTH);
        panel.add(valueLabel, BorderLayout.CENTER);
        return panel;
    }

    public void cifrarNumero(){
        mensaje = numacifrar.getText().trim();
        try {
            int numero = Integer.parseInt(mensaje);
            if (numero < 0 || numero > 999) {
            JOptionPane.showMessageDialog(this, "El número debe tener máximo 3 dígitos (0 - 999)");
            return;
            }
        }catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Debes ingresar un número válido");
        return;
        }
        FuncionRSA a = new FuncionRSA();
        a.generarPrimos();
        a.generarClaves();
        
        p = a.getP();
        q = a.getQ();
        n = a.getN();
        fi = a.getFi();
        e = a.getE();
        d = a.getD();
        
        txtresp.setText(p.toString());
        txtresq.setText(q.toString());
        txtresn.setText(n.toString());
        txtresfi.setText(fi.toString());
        txtrese.setText(e.toString());
        txtresd.setText(d.toString());
        
        BigInteger[] mensajeCifrado = a.cifrar(mensaje);
        
        StringBuilder cifradoStr = new StringBuilder();
        for (BigInteger num : mensajeCifrado) {
        cifradoStr.append(num.toString()).append(" ");
        }
        numcifrado.setText(cifradoStr.toString());
        
    }
    
    private void regresarVentana() {
        new Menu();
        this.setVisible(false);
    }
}
