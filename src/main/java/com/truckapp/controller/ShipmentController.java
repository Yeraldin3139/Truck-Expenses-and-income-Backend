package com.truckapp.controller;

import com.truckapp.model.Shipment;
import com.truckapp.repository.ShipmentRepository;
import com.truckapp.service.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {
    @Autowired
    private ShipmentRepository shipmentRepository;

    private final PricingService pricing = PricingService.getInstance();

    @PostMapping
    public ResponseEntity<Shipment> create(@RequestBody ShipmentDTO dto){
        Shipment s = new Shipment();
        s.setSenderName(dto.getSenderName());
        s.setRecipientName(dto.getRecipientName());
        s.setFromAddress(dto.getFromAddress());
        s.setToAddress(dto.getToAddress());
        s.setWeightKg(dto.getWeightKg());
        s.setPriceCOP(pricing.priceForKg(dto.getWeightKg()));
        s.setPaidByRecipient(dto.isPaidByRecipient());
        Shipment saved = shipmentRepository.save(s);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Shipment> all(){ return shipmentRepository.findAll(); }
}

class ShipmentDTO {
    private String senderName;
    private String recipientName;
    private String fromAddress;
    private String toAddress;
    private double weightKg;
    private boolean paidByRecipient;
    // getters and setters
    public String getSenderName(){ return senderName; }
    public void setSenderName(String s){ senderName = s; }
    public String getRecipientName(){ return recipientName; }
    public void setRecipientName(String r){ recipientName = r; }
    public String getFromAddress(){ return fromAddress; }
    public void setFromAddress(String a){ fromAddress = a; }
    public String getToAddress(){ return toAddress; }
    public void setToAddress(String a){ toAddress = a; }
    public double getWeightKg(){ return weightKg; }
    public void setWeightKg(double w){ weightKg = w; }
    public boolean isPaidByRecipient(){ return paidByRecipient; }
    public void setPaidByRecipient(boolean p){ paidByRecipient = p; }
}
