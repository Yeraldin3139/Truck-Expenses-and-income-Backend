package com.truckapp.repository;

import com.truckapp.model.TripTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripTransactionRepository extends JpaRepository<TripTransaction, Long> {
    List<TripTransaction> findByTripId(Long tripId);
    void deleteByTripId(Long tripId);
}
