package des;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.HeadlessException;
import java.awt.Toolkit;

public class DESInterfaz extends JFrame {
    private JTextField txtArchivoCifrar, txtArchivoDescifrar, txtRutaGenerada, txtRutaDescifrada;
    private JTextArea txtMensaje, txtTextoDescifrado;
    private File archivoProcesado;
    private File archivoDescifrado;

    public DESInterfaz() {
        setTitle("Cifrado y Descifrado DES");
        setSize(800, 600); // Aumenté el tamaño para acomodar los nuevos elementos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 130, 255));

        JLabel titulo = new JLabel("CIFRADO Y DESCIFRADO DES", SwingConstants.CENTER);
        titulo.setBounds(250, 10, 300, 30);
        titulo.setForeground(Color.WHITE);

        // Sección de cifrado (izquierda)
        JLabel lblCifrar = new JLabel("Carga el archivo a cifrar (.txt)");
        lblCifrar.setBounds(50, 50, 200, 20);
        lblCifrar.setForeground(Color.WHITE);
        
        txtArchivoCifrar = new JTextField();
        txtArchivoCifrar.setBounds(50, 80, 200, 25);
        
        JButton btnCargarCifrar = new JButton("Cargar .txt");
        btnCargarCifrar.setBounds(260, 80, 100, 25);
        btnCargarCifrar.addActionListener(e -> seleccionarArchivo(txtArchivoCifrar));

        JButton btnCifrar = new JButton("Cifrar");
        btnCifrar.setBounds(50, 120, 100, 25);
        btnCifrar.addActionListener(e -> cifrarArchivo());

        txtRutaGenerada = new JTextField();
        txtRutaGenerada.setBounds(50, 160, 310, 25);
        txtRutaGenerada.setEditable(false);

        JButton btnAbrir = new JButton("Abrir");
        btnAbrir.setBounds(50, 190, 100, 25);
        btnAbrir.addActionListener(e -> abrirArchivo());

        // Sección de descifrado (derecha)
        JLabel lblDescifrar = new JLabel("Carga el archivo a descifrar (.txt)");
        lblDescifrar.setBounds(450, 50, 200, 20);
        lblDescifrar.setForeground(Color.WHITE);

        txtArchivoDescifrar = new JTextField();
        txtArchivoDescifrar.setBounds(450, 80, 200, 25);

        JButton btnCargarDescifrar = new JButton("Cargar .txt");
        btnCargarDescifrar.setBounds(660, 80, 100, 25);
        btnCargarDescifrar.addActionListener(e -> seleccionarArchivo(txtArchivoDescifrar));

        JButton btnDescifrar = new JButton("Descifrar");
        btnDescifrar.setBounds(450, 120, 100, 25);
        btnDescifrar.addActionListener(e -> descifrarArchivo());

        txtRutaDescifrada = new JTextField();
        txtRutaDescifrada.setBounds(450, 160, 310, 25);
        txtRutaDescifrada.setEditable(false);

        JButton btnAbrirDescifrado = new JButton("Abrir");
        btnAbrirDescifrado.setBounds(450, 190, 100, 25);
        btnAbrirDescifrado.addActionListener(e -> abrirArchivoDescifrado());

        txtMensaje = new JTextArea();
        txtMensaje.setBounds(300, 120, 120, 25);
        txtMensaje.setEditable(false);
        txtMensaje.setBackground(new Color(50, 130, 255));
        txtMensaje.setForeground(Color.WHITE);

        txtTextoDescifrado = new JTextArea();
        txtTextoDescifrado.setBounds(50, 230, 700, 300); // Ajusté la posición y tamaño
        txtTextoDescifrado.setEditable(false);
        txtTextoDescifrado.setLineWrap(true);
        txtTextoDescifrado.setWrapStyleWord(true);

        panel.add(titulo);
        panel.add(lblCifrar);
        panel.add(txtArchivoCifrar);
        panel.add(btnCargarCifrar);
        panel.add(btnCifrar);
        panel.add(txtRutaGenerada);
        panel.add(btnAbrir);
        panel.add(lblDescifrar);
        panel.add(txtArchivoDescifrar);
        panel.add(btnCargarDescifrar);
        panel.add(btnDescifrar);
        panel.add(txtRutaDescifrada);
        panel.add(btnAbrirDescifrado);
        panel.add(txtMensaje);
        panel.add(txtTextoDescifrado);

        add(panel);
        setVisible(true);
    }

    private void seleccionarArchivo(JTextField campoTexto) {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            campoTexto.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void cifrarArchivo() {
        try {
            String ruta = txtArchivoCifrar.getText();
            if (ruta.isEmpty()) {
                mostrarMensaje("Seleccione un archivo", Color.RED);
                return;
            }
            File archivo = new File(ruta);
            String rutaCifrada = DES.ciFrar(archivo);
            archivoProcesado = new File(rutaCifrada);
            txtRutaGenerada.setText(rutaCifrada);
            mostrarMensaje("Cifrado exitoso", Color.GREEN);
        } catch (Exception e) {
            mostrarMensaje("Error al cifrar", Color.RED);
            e.printStackTrace();
        }
    }

    private void descifrarArchivo() {
        try {
            String ruta = txtArchivoDescifrar.getText();
            if (ruta.isEmpty()) {
                mostrarMensaje("Seleccione un archivo", Color.RED);
                return;
            }
            File archivo = new File(ruta);
            String rutaDescifrada = DES.desCifrar(archivo);
            archivoDescifrado = new File(rutaDescifrada);
            txtRutaDescifrada.setText(rutaDescifrada);
            
            // Leer el contenido del archivo descifrado y mostrarlo en el área de texto
            FileInputStream fis = new FileInputStream(archivoDescifrado);
            byte[] data = new byte[(int) archivoDescifrado.length()];
            fis.read(data);
            fis.close();
            String contenido = new String(data, StandardCharsets.UTF_8);
            txtTextoDescifrado.setText(contenido);
            
            mostrarMensaje("Descifrado exitoso", Color.GREEN);
        } catch (Exception e) {
            mostrarMensaje("Error al descifrar", Color.RED);
            e.printStackTrace();
        }
    }

    private void abrirArchivo() {
        if (archivoProcesado != null && archivoProcesado.exists()) {
            try {
                Desktop.getDesktop().open(archivoProcesado);
            } catch (IOException e) {
                mostrarMensaje("No se pudo abrir", Color.RED);
            }
        }
    }

    private void abrirArchivoDescifrado() {
        if (archivoDescifrado != null && archivoDescifrado.exists()) {
            try {
                Desktop.getDesktop().open(archivoDescifrado);
            } catch (IOException e) {
                mostrarMensaje("No se pudo abrir", Color.RED);
            }
        }
    }

    private void mostrarMensaje(String mensaje, Color color) {
        txtMensaje.setForeground(color);
        txtMensaje.setText(mensaje);
    }

    public static void main(String[] args) {
        new DESInterfaz();
    }
}