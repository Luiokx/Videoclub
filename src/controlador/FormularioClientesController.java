package controlador;

import modelo.Personas;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FormularioClientesController {
    private final String dniChars="TRWAGMYFPDXBNJZSQVHLCKE";
    public void refillComboYear(JComboBox comboBox) {
        for (int i = 1900; i < LocalDate.now().getYear() + 1; i++) {
            comboBox.addItem(i);
        }
    }


    public boolean validarDNI(String itDNI) {
        String intPartDNI = itDNI.trim().replaceAll(" ", "").substring(0, 7);
        char ltrDNI = itDNI.charAt(8);
        int valNumDni = Integer.parseInt(intPartDNI) % 23;
        if (itDNI.length()!= 9 && isNumeric(intPartDNI) == false && dniChars.charAt(valNumDni)!= ltrDNI) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getIndex(String nan, ArrayList<Personas> item) {
        int response = 0;

        for (int i = 0; i < item.size(); i++) {
            if (nan.equals(item.get(i).getNan())) {
                response = i;
                break;
            }
        }

        return response;
    }

    public void setYear() {

    }
}
