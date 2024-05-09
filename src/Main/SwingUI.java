package Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import connection.Conexion;
import models.Moneda;

public class SwingUI {
    private JPanel mainPanel;
    private JLabel tBase;
    private JLabel tConvertir;
    private JComboBox cBBase;
    private JComboBox cBAConvertir;
    private JLabel jLTitulo;
    private JLabel lMonto;
    private JTextField tFMonto;
    private JButton btConvertir;
    private JLabel jLResultado;

    public SwingUI() {
        btConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<String> mon = new ArrayList<String>();
                mon.add("ARS"); mon.add("USD"); mon.add("EUR"); mon.add("BRL");
                int monedaBase = cBBase.getSelectedIndex();
                int monedaAConvertir = cBAConvertir.getSelectedIndex();
                double monto = Double.parseDouble(tFMonto.getText());
                Conexion con = new Conexion();
                try {
                    Moneda resultado = con.convertir(mon.get(monedaBase), mon.get(monedaAConvertir),monto);
                    jLResultado.setText("La conversion a "+mon.get(monedaAConvertir)+" es : "+resultado.conversion_result());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingUI");
        frame.setContentPane(new SwingUI().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Conversor Online");
    }
}
