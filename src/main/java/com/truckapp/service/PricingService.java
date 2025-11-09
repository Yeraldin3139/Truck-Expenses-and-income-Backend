package com.truckapp.service;

public class PricingService {
    private static PricingService instance;
    private final double pricePerKg;

    private PricingService(){
        this.pricePerKg = 25000.0 / 50.0; // 500 COP/kg
    }

    public static synchronized PricingService getInstance(){
        if(instance == null) instance = new PricingService();
        return instance;
    }

    public long priceForKg(double kg){
        if(kg <= 0) return 0;
        return Math.round(kg * pricePerKg);
    }
}
