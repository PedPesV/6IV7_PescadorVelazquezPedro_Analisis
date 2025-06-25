package rsa;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.math.BigInteger;

public class Descifrar extends JFrame {
    
    private JButton btnRegresar;
    private JButton btnDescifrar;
    private JTextField contd, contn;
    private JTextField contcif;
    private JTextArea contdes;
    String cadenacifrada; 
    BigInteger d, n;
    
    public Descifrar() {
        this.setTitle("Descifrar");
        this.setSize(600, 600); // Aumenté la altura para acomodar todos los campos
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Panel principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        // 1. Panel superior con botón regresar y título
        JPanel topPanel = new JPanel(new BorderLayout());
        
        // Panel para botón regresar
        JPanel topButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnRegresar = new JButton("Regresar");
        topButtonPanel.add(btnRegresar);
        topPanel.add(topButtonPanel, BorderLayout.NORTH);
        
        // Panel para título
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Descifrar", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.add(title);
        topPanel.add(titlePanel, BorderLayout.CENTER);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // 2. Panel central con contenido - Usamos BoxLayout para apilar verticalmente
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(new EmptyBorder(30, 0, 0, 0));
        
        // 2.1 Panel para "Ingrese d"
        JPanel dSection = new JPanel(new BorderLayout());
        dSection.setBorder(new EmptyBorder(10, 50, 10, 50));
        
        JLabel lblIngreseD = new JLabel("Ingrese d:");
        dSection.add(lblIngreseD, BorderLayout.NORTH);
        
        contd = new JTextField();
        contd.setFont(new Font("Arial", Font.PLAIN, 14));
        contd.setPreferredSize(new Dimension(0, 30)); // Altura fija
        dSection.add(contd, BorderLayout.CENTER);
        
        contentPanel.add(dSection);
        
        // 2.2 Panel para "Ingrese n"
        JPanel nSection = new JPanel(new BorderLayout());
        nSection.setBorder(new EmptyBorder(10, 50, 10, 50));
        
        JLabel lblIngreseN = new JLabel("Ingrese n:");
        nSection.add(lblIngreseN, BorderLayout.NORTH);
        
        contn = new JTextField();
        contn.setFont(new Font("Arial", Font.PLAIN, 14));
        contn.setPreferredSize(new Dimension(0, 30)); // Altura fija
        nSection.add(contn, BorderLayout.CENTER); // CORREGIDO: era dSection.add
        
        contentPanel.add(nSection);
        
        // 2.3 Panel para "Número a descifrar"
        JPanel inputSection = new JPanel(new BorderLayout());
        inputSection.setBorder(new EmptyBorder(10, 50, 10, 50));
        
        JLabel lblNumeroDescifrar = new JLabel("Ingrese el numero a descifrar:");
        inputSection.add(lblNumeroDescifrar, BorderLayout.NORTH);
        
        contcif = new JTextField();
        contcif.setFont(new Font("Arial", Font.PLAIN, 14));
        contcif.setPreferredSize(new Dimension(0, 30)); // Altura fija
        inputSection.add(contcif, BorderLayout.CENTER);
        
        contentPanel.add(inputSection);
        
        // 2.4 Panel con botón descifrar
        JPanel descifrarButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        descifrarButtonPanel.setBorder(new EmptyBorder(20, 0, 20, 0));
        btnDescifrar = new JButton("Descifrar");
        descifrarButtonPanel.add(btnDescifrar);
        btnDescifrar.addActionListener(e -> descifrarNumero());
        
        contentPanel.add(descifrarButtonPanel);
        
        // 2.5 Panel para el resultado
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.setBorder(new EmptyBorder(10, 50, 20, 50));
        
        JLabel lblNumeroDescifrado = new JLabel("Numero descifrado");
        resultPanel.add(lblNumeroDescifrado, BorderLayout.NORTH);
        
        contdes = new JTextArea();
        contdes.setEditable(false);
        contdes.setRows(4); // Altura específica para el área de resultado
        contdes.setFont(new Font("Arial",Font.PLAIN,20));
        JScrollPane scrollPane = new JScrollPane(contdes);
        resultPanel.add(scrollPane, BorderLayout.CENTER);
        
        contentPanel.add(resultPanel);
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        this.add(mainPanel);
        btnRegresar.addActionListener(e -> regresarVentana());
        this.setVisible(true);
    }
    
    public void descifrarNumero(){
        cadenacifrada = contcif.getText().trim();
        String[] dividir = cadenacifrada.split(" ");
        BigInteger[] cifrado = new BigInteger[dividir.length];
        
        for(int i = 0; i < dividir.length; i++){
            cifrado[i] = new BigInteger(dividir[i]);
        }
        
        d = new BigInteger(contd.getText());
        n = new BigInteger(contn.getText());
        
        FuncionRSA a = new FuncionRSA();
        String descifrado = a.descifrar(cifrado,d,n);
        
        contdes.setText(descifrado);
        
    }
    
    public void regresarVentana() {
        new Menu();
        this.setVisible(false);
    }
}