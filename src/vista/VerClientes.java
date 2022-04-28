package vista;

import controlador.LoadDataController;
import controlador.VerClientesController;
import modelo.Personas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class VerClientes extends JFrame {
    private JPanel panel;
    private JTable tableClientes;
    private JButton buttonModificar;
    private JButton btnCerrar;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private ArrayList<Personas> dataItem;


    public VerClientes() {
        setTitle("Ver clientes");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);

        //Obtenemos la informacion para el arraylist y creamos el modelo para la tabla
        dataItem = (new LoadDataController()).getClientes("clientes2.txt");
        DefaultTableModel model = new VerClientesController().getModel(dataItem);

        tableClientes.setModel(model);
        tableClientes.setFillsViewportHeight(true);

        buttonModificar.addActionListener(v -> {
            int row = tableClientes.getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Selecciona una opcion");
                return;
            }

            FormularioClientes window = new FormularioClientes(true, dataItem);
            window.setNan(tableClientes.getModel().getValueAt(row, 0).toString());
            window.loadModificar();
            window.setVisible(true);
        });

        btnInsertar.addActionListener(v -> {
            FormularioClientes window = new FormularioClientes(false, dataItem);
            window.setVisible(true);
        });
    }
}
