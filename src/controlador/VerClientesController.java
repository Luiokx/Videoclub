package controlador;

import modelo.Personas;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class VerClientesController {
    private String[] getClientesArray(Personas item) {
        String response[] = new String[3];


        response[0] = item.getNan();
        response[1] = item.getNombre();
        response[2] = item.getApellidos();


        return response;
    }

    public DefaultTableModel getModel(ArrayList<Personas> item) {
        DefaultTableModel response = new DefaultTableModel();
        String[] tabla = new String[]{"DNI", "Nombre", "Apellidos"};

        response.addColumn(tabla[0]);
        response.addColumn(tabla[1]);
        response.addColumn(tabla[2]);

        for (int i = 0; i < item.size(); i++) {
            response.addRow(getClientesArray(item.get(i)));
        }

        return response;
    }
}
