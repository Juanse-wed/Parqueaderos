package redparqueaderos.garajes;

import redparqueaderos.vehiculos.*;
import redparqueaderos.excepciones.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Garaje {
    private String nombre;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String telefono;
    private String email;
    private String administrador;
    private int espaciosTotales;
    List<Vehiculo> vehiculos;

    public Garaje(String nombre, String departamento, String ciudad, String direccion, String telefono, String email, String administrador, int espaciosTotales) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.administrador = administrador;
        this.espaciosTotales = espaciosTotales;
        this.vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) throws ExcepcionGarajeLleno, ExcepcionLimiteCamiones, ExcepcionLimiteMotocicletas, ExcepcionVehiculoExistente {
        if (vehiculos.size() >= espaciosTotales) {
            throw new ExcepcionGarajeLleno("El garaje está lleno.");
        }
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(vehiculo.getPlaca())) {
                throw new ExcepcionVehiculoExistente("El vehículo ya está registrado en este garaje.");
            }
        }
        if (vehiculo instanceof Camion && contarCamiones() >= (espaciosTotales < 100 ? 10 : 20)) {
            throw new ExcepcionLimiteCamiones("Límite de camiones alcanzado.");
        }
        if (vehiculo instanceof Motocicleta && contarMotocicletas() >= (int) (espaciosTotales * 0.2)) {
            throw new ExcepcionLimiteMotocicletas("Límite de motocicletas alcanzado.");
        }
        vehiculos.add(vehiculo);
    }

    public void retirarVehiculo(String placa) {
        vehiculos.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public int contarCamiones() {
        return (int) vehiculos.stream().filter(v -> v instanceof Camion).count();
    }

    public int contarMotocicletas() {
        return (int) vehiculos.stream().filter(v -> v instanceof Motocicleta).count();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Garaje: " + nombre + ", Espacios ocupados: " + vehiculos.size() + "/" + espaciosTotales;
    }

    public abstract String getEspaciosTotales();

    public abstract String retirarVehiculo();
}
