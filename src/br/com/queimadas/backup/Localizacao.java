package br.com.queimadas.model;

public class Localizacao {
    private double latitude;
    private double longitude;

    public Localizacao(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Lat:" + latitude + ", Lon:" + longitude;
    }
}
