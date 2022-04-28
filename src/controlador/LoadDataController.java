package controlador;

import modelo.Personas;

import java.io.*;
import java.util.ArrayList;

public class LoadDataController {
    public ArrayList<Personas> getClientes(String filePath) {
        ArrayList<Personas> item = null;
        FileInputStream fi = null;
        ObjectInputStream oi = null;

        try {
            fi = new FileInputStream(filePath);
            oi = new ObjectInputStream(fi);

            item = (ArrayList<Personas>) oi.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oi != null)
                    oi.close();
                if (fi != null)
                    fi.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return item;
    }

    public static void saveObjectClientes(ArrayList<Personas> item, String url) {
        ObjectOutputStream obj = null;
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream(url);
            obj = new ObjectOutputStream(fo);

            obj.writeObject(item);
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido iniciar.");
        } catch (IOException e) {
            System.out.println("No se ha podido crear el objeto.");
        } finally {
            try {
                if (obj != null)
                    obj.close();
                if (fo != null)
                    fo.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
