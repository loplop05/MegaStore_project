/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ammar_project;

/**
 *
 * @author HP
 */


public abstract class Device {
    protected String type;
    protected int price;
    protected String serialNo;
    protected int model;
    protected double weight;

    public Device(String type, int price, String serialNo, int model, double weight) {
        this.type = type;
        setPrice(price);
        setSerialNo(serialNo);
        setModel(model);
        setWeight(weight);
    }

    public String getType() {
        return type;
    }

    public abstract double calculatePrice();

    public void displayInfo() {
        System.out.printf("%-20s %-15s $%-10.2f%n", this.getClass().getSimpleName(), getType(), calculatePrice());
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price <= 0) {
            System.out.println("Invalid price. Please enter a positive value.");
            return;
        }
        this.price = price;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        if (serialNo == null || serialNo.trim().isEmpty()) {
            System.out.println("Invalid serial number. Please enter a valid serial number.");
            return;
        }
        this.serialNo = serialNo;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        if (model <= 0) {
            System.out.println("Invalid model number. Please enter a valid model number.");
            return;
        }
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("Invalid weight. Please enter a positive weight.");
            return;
        }
        this.weight = weight;
    }
}
