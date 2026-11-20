package cl.duoc.isidora_farias.dao;

import cl.duoc.isidora_farias.model.Gato;
import cl.duoc.isidora_farias.model.Mascota;
import cl.duoc.isidora_farias.model.Perro;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MascotaDao {

    private static final String ARCHIVO_PERROS = "perros.json";
    private static final String ARCHIVO_GATOS = "gatos.json";

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public List<Mascota>cargarTodas() throws IOException{

        List<Mascota> mascotas = new ArrayList<>();
        mascotas.addAll(cargarPerros());
        mascotas.addAll(cargarGatos());
        return mascotas;
    }

    private List<Perro> cargarPerros()throws IOException{
        File archivo = new File(ARCHIVO_PERROS);
        if (!archivo.exists()){
            return new ArrayList<>();
        }
        try(FileReader lector = new FileReader(archivo)){
            Type tipoLista = new TypeToken<List<Perro>>() {}.getType();
            List<Perro> perros = gson.fromJson(lector, tipoLista);
            if(perros ==null){
                return new ArrayList<>();
            }
            return perros;
        }
    }
    private List<Gato> cargarGatos()throws IOException{
        File archivo = new File(ARCHIVO_GATOS);
        if (!archivo.exists()){
            return new ArrayList<>();
        }
        try(FileReader lector = new FileReader(archivo)){
            Type tipoLista = new TypeToken<List<Gato>>() {}.getType();
            List<Gato> gatos = gson.fromJson(lector, tipoLista);
            if(gatos ==null){
                return new ArrayList<>();
            }
            return gatos;
        }
    }

    public void guardarTodas(List<Mascota>mascotas) throws IOException{
    List <Perro> perros = new ArrayList<>();
    List <Gato> gatos = new ArrayList<>();
    for (Mascota m : mascotas){
        if (m instanceof Perro){
            perros.add((Perro)m);
        }else if (m instanceof Gato){
            gatos.add((Gato)m);
        }
    }
    escribir(ARCHIVO_PERROS, perros);
    escribir(ARCHIVO_GATOS, gatos);
    }
    private void escribir(String nombreArchivo, Object datos)throws IOException{
    try(FileWriter escritor = new FileWriter(nombreArchivo)){
        gson.toJson(datos, escritor);
    }
    }
}
