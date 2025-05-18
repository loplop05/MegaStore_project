package com.mycompany.ammar_project;

public class Ac extends Device {
    private String modelName;

    public Ac(int price, String type, String serialNo, int model, double weight, int model2) {
        super(type, price, serialNo, model, weight);
        setModelName(modelName);  // Using setter for model name validation
    }

    @Override
    public double calculatePrice() {
        return price * (weight / 50);  // Price calculation based on weight
    }

    // Getters and Setters with Validation
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (modelName != null && (modelName.equals("LG") || modelName.equals("GoGreen"))) {
            this.modelName = modelName;
        } else {
            System.out.println("Invalid model name! Please choose from LG or GoGreen.");
        }
    }
}
