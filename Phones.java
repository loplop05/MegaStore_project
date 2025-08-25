package com.mycompany.ammar_project;

public class Phones extends Device {
    private int storage;
    private String modelName;

    public Phones(int price, String type, String serialNo, int model, int storage, double weight, int brandChoice) {
        super(type, price, serialNo, model, weight);
        setStorage(storage);  
        setModelName(modelName); 
    }

    @Override
    public double calculatePrice() {
        return price + (storage * 5);  // Price based on storage
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        if (storage > 0) {
            this.storage = storage;
        } else {
            System.out.println("Invalid storage value! Please enter a positive value.");
            this.storage = 0;  // Default value if invalid
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (modelName != null && (modelName.equals("iPhone") || modelName.equals("Samsung"))) {
            this.modelName = modelName;
        } else {
            System.out.println("Invalid model name! Please choose from iPhone or Samsung.");
        }
    }
}
