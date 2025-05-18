package com.mycompany.ammar_project;

public class PricingCalculator {
    public static double calculatePrice(Device device) {
        if (device instanceof Fridge) {
            return calculateFridgePrice((Fridge) device);
        } else if (device instanceof Ac) {
            return calculateAcPrice((Ac) device);
        } else if (device instanceof Monitors) {
            return calculateMonitorPrice((Monitors) device);
        } else if (device instanceof Phones) {
            return calculatePhonePrice((Phones) device);
        } else {
            return 0;
        }
    }

    private static double calculateFridgePrice(Fridge fridge) {
        double basePrice = fridge.getPrice();
        double heightFactor = fridge.getHeight() * 50;
        double doorFactor = fridge.getDoors() * 100;
        return basePrice + heightFactor + doorFactor;
    }

    private static double calculateAcPrice(Ac ac) {
        double basePrice = ac.getPrice();
        double weightFactor = ac.getWeight() * 20;
        return basePrice + weightFactor;
    }

    private static double calculateMonitorPrice(Monitors monitor) {
        double basePrice = monitor.getPrice();
        double sizeFactor = monitor.getSize() * 10;
        return basePrice + sizeFactor;
    }

    private static double calculatePhonePrice(Phones phone) {
        double basePrice = phone.getPrice();
        double storageFactor = phone.getStorage() * 5;
        return basePrice + storageFactor;
    }
}
