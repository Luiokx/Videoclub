import controlador.LoadDataController;
import modelo.Clientes;
import modelo.Personas;
import vista.Login;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        generateDataClientes();

        Login login = new Login();
        login.setVisible(true);
    }

    private static void generateDataClientes() {
        ArrayList<Personas> item = new ArrayList<Personas>();

        item.add(new Clientes("20221491y", "Luis", "Salvatierra", "25/02/2000", "zUBRANRAB",
                "15/5/1900"));

        LoadDataController.saveObjectClientes(item, "clientes2.txt");
    }
}
