package com.example.sara.loginregistera.repository;

import com.example.sara.loginregistera.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ReservationRepository  extends JpaRepository<Reservation, Long> {
        List<Reservation> findAllByUserId(Long userId);
    }


