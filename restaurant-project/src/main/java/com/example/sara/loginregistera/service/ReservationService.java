package com.example.sara.loginregistera.service;


import com.example.sara.loginregistera.model.Reservation;
import com.example.sara.loginregistera.repository.ReservationRepository;
import com.example.sara.loginregistera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Reservation> readAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation createReservation) {
        return reservationRepository.save(createReservation);
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation updateReservation(Reservation reservationToEdit) {
        return reservationRepository.save(reservationToEdit);
    }


    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
    public List<Reservation> findReservationsByUserId(Long userId) {
        return reservationRepository.findAllByUserId(userId);
    }
}
