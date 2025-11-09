package com.truckapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truckapp.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
