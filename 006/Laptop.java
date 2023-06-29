public class Laptop {
    private String brand;
    private double screenSize;
    private int ram;
    private int hdd;
    private String opSystem;
    private String color;

    public Laptop(String brand, double screenSize, int ram, int hdd, String opSystem, String color) {
        this.brand = brand;
        this.screenSize = screenSize;
        this.ram = ram;
        this.hdd = hdd;
        this.opSystem = opSystem;
        this.color = color;
    }

    @Override
    public String toString() {
        return brand + " " + screenSize + "\", ОЗУ (RAM) = " + ram + "Gb, HDD = " + hdd + "Gb, Операц Система = "
                + opSystem + ", ЦВЕТ = " + color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getOpSystem() {
        return opSystem;
    }

    public void setOpSystem(String opSystem) {
        this.opSystem = opSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
