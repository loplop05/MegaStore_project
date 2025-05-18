package com.mycompany.ammar_project;

public class Monitors extends Device {
    private int size;

    public Monitors(int price, String type, String serialNo, int model, double weight, int size, int brandChoice) {
        super(type, price, serialNo, model, weight);
        setSize(size);  // Using setter for size validation
    }

    @Override
    public double calculatePrice() {
        return price * (size / 24);  // Price based on monitor size
    }

    // Getters and Setters with Validation
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size >= 15 && size <= 65) {
            this.size = size;
        } else {
            System.out.println("Invalid size! Please choose a size between 15 and 65 inches.");
            this.size = 15;  
        }
    }
}
