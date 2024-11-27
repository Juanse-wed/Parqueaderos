package redparqueaderos.vehiculos;

public abstract class Vehiculo {
    protected String placa;
    protected String propietario;

    public Vehiculo(String placa, String propietario) {
        this.placa = placa;
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getPropietario() {
        return propietario;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + ", Propietario: " + propietario;
    }
}
