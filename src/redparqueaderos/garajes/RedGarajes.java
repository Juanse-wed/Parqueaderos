package redparqueaderos.garajes;

import java.util.ArrayList;
import java.util.List;

public class RedGarajes {
    private List<Garaje> listaGarajes;

    public RedGarajes() {
        listaGarajes = new ArrayList<>();
    }

    public void agregarGaraje(Garaje garaje) {
        listaGarajes.add(garaje);
    }

    public Garaje buscarGaraje(String nombre) {
        for (Garaje garaje : listaGarajes) {
            if (garaje.getNombre().equalsIgnoreCase(nombre)) {
                return garaje;
            }
        }
        return null; // Si no se encuentra el garaje, retorna null
    }

    public void mostrarOcupacion() {
        for (Garaje garaje : listaGarajes) {
            System.out.println("Garaje: " + garaje.getNombre() + ", Espacios ocupados: " +
                    garaje.retirarVehiculo() + "/" + garaje.getEspaciosTotales());
        }
    }
}
