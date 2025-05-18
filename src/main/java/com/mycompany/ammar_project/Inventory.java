package com.mycompany.ammar_project;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Device> devices;

    public Inventory() {
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
    }

    public void displayAllDevices() {
        if (devices.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }
        System.out.println("Displaying all devices in your cart:");
        for (Device device : devices) {
            device.displayInfo(); // Assuming each device has a displayInfo method
        }
    }

    public ArrayList<Device> getDevices() {
        return devices;
    }

   
}
