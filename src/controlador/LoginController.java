package controlador;

import vista.VerClientes;

import javax.swing.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginController {
    public boolean isExist(String user, String password) {
        boolean response = false;
        FileReader reader = null;
        BufferedReader bf = null;

        try {
            reader = new FileReader("setup.txt");
            bf = new BufferedReader(reader);
            String line;

            while ((line = bf.readLine()) != null) {
                String[] data = line.split("=");

                if (data[0].equals(user)) {
                    if (data[1].equals(password))
                        response = true;

                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException e) {
            System.out.println("Error en las variables");
        } finally {
            try {
                if (reader != null)
                    reader.close();
                if (bf != null)
                    bf.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar controladores");
            }
        }

        return response;
    }
}
