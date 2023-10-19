package examenParcial2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorPerfiles {
    private List<Jugador> jugadores;
    private String archivoJugadores;

    public GestorPerfiles(String archivoJugadores) {
        this.archivoJugadores = archivoJugadores;
        jugadores = new ArrayList<>();
        cargarJugadores();
    }

    private void cargarJugadores() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(archivoJugadores))) {
            jugadores = (List<Jugador>) input.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de jugadores no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void guardarJugadores() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(archivoJugadores))) {
            output.writeObject(jugadores);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void crearPerfil(String nombre) {
        Jugador jugador = new Jugador(nombre);
        jugadores.add(jugador);
        guardarJugadores();
    }

    public Jugador seleccionarPerfil(String nombre) {
        for (Jugador jugador : jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
        return null;
    }

    public List<Jugador> obtenerTodosLosPerfiles() {
        return jugadores;
    }
}

