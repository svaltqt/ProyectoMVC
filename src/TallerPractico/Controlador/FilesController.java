package TallerPractico.Controlador;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilesController {

    private ArrayList<String> users = new ArrayList<String>();
    public void AgregarRegistro(String archivo, String registro) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
            writer.write(registro);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<String> consultarRegistros(String archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                users.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
    public void eliminarRegistro(String archivo, String registroAEliminar) {
        try{
            List<String> lineas = new ArrayList<>();
            String linea;
            BufferedReader reader = new BufferedReader(new FileReader((archivo)));
            while((linea = reader.readLine()) != null){
                if(!linea.equals(registroAEliminar)){
                    lineas.add(linea);
                }
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
            for (String l : lineas){
                writer.write(l);
                writer.newLine();
            }
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void modificarRegistro(String archivo, String registroAModificar, String nuevoContenido) {
        try {
            List<String> lineas = new ArrayList<>();
            String linea;

            BufferedReader reader = new BufferedReader(new FileReader(archivo));
            while ((linea = reader.readLine()) != null) {
                if (linea.equals(registroAModificar)) {
                    lineas.add(nuevoContenido);
                } else {
                    lineas.add(linea);
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
            for (String l : lineas) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
