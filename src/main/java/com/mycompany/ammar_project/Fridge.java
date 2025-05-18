package com.mycompany.ammar_project;

public class Fridge extends Device {
    private String brand;
    private double height;
    private int doors;

    public Fridge(int price, String type, String serialNo, int model, double weight, double height, int doors, int doors1) {
        super(type, price, serialNo, model, weight);
        setBrand(brand);  // Using setter for brand validation
        setHeight(height);  // Using setter for height validation
        setDoors(doors);  // Using setter for doors validation
    }

    @Override
    public double calculatePrice() {
        return price * (weight / 100);  // Simple calculation for price based on weight
    }

    // Getters and Setters with Validation
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand != null && (brand.equals("Beko") || brand.equals("LG") || brand.equals("Samsung"))) {
            this.brand = brand;
        } else {
            System.out.println("Invalid brand! Please choose from Beko, LG, or Samsung.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Invalid height! Please enter a positive value.");
            this.height = 0;  // Default value if invalid
        }
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        if (doors == 1 || doors == 2) {
            this.doors = doors;
        } else {
            System.out.println("Invalid door number! Please choose between 1 or 2 doors.");
            this.doors = 1;  // Default value if invalid
        }
    }
}
