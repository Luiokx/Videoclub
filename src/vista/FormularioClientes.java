package vista;

import controlador.FormularioClientesController;
import controlador.LoadDataController;
import modelo.Clientes;
import modelo.Personas;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormularioClientes extends JFrame {
    private ArrayList<Personas> item;
    private String nan;
    private JPanel panel;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDireccion;
    private JComboBox ComboAnyo;
    private JButton btnAccion;
    private JButton btnCerrar;
    private JTextField txtnan;

    public FormularioClientes(boolean modificar, ArrayList<Personas> item) {
        this.item = item;

        if (!modificar)
            loadDefault();

        (new FormularioClientesController()).refillComboYear(ComboAnyo);
        btnCerrar.addActionListener(v -> {
            dispose();
        });
    }

    protected void setNan(String nan) {
        this.nan = nan;
    }

    /***
     * Metodo para insertar clientes
     */
    private void loadDefault() {
        setTitle("Insertar clientes");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 300);

        btnAccion.setText("Insertar");

        btnAccion.addActionListener(v -> {
            String nan = txtnan.getText().toString();

            if (!new FormularioClientesController().validarDNI(nan)) {
                JOptionPane.showMessageDialog(null, "El dni es incorrecto");
                return;
            }

            String nombre = txtNombre.getText().toString();
            String apellidos = txtApellido.getText().toString();
            String direccion = txtDireccion.getText().toString();

            if (nombre.trim().isEmpty() && apellidos.trim().isEmpty() && direccion.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellena todos los campos");
                return;
            }

            String anyo = ComboAnyo.getSelectedItem().toString();
            String actual = String.valueOf((LocalDate.now().getYear()));

            item.add(new Clientes(nan, nombre, apellidos, anyo, direccion, actual));

            LoadDataController.saveObjectClientes(item, "clientes2.txt");
        });
    }

    protected void loadModificar() {
        setTitle("Modificar cliente");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 300);

        int index = (new FormularioClientesController()).getIndex(nan, item);

        txtnan.setText(item.get(index).getNan());
        txtNombre.setText(item.get(index).getNombre());
        txtApellido.setText(item.get(index).getApellidos());

        ComboAnyo.setSelectedItem(item.get(index).getAnyo());

        btnAccion.setText("Modificar");
        btnAccion.addActionListener(v -> {

        });
    }
}
