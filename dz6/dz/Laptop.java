package dz6.dz;
public class Laptop {
    private String brand;
    private int ram;
    private int storageSize;
    private String os;
    private String color;

    public Laptop(String brand, int ram, int storageSize, String os, String color) {
        this.brand = brand;
        this.ram = ram;
        this.storageSize = storageSize;
        this.os = os;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorageSize() {
        return storageSize;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}
