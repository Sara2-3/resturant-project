package com.example.sara.loginregistera.service;

import com.example.sara.loginregistera.model.Career;
import com.example.sara.loginregistera.model.Reservation;
import com.example.sara.loginregistera.repository.CareerRepository;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerService {

    @Autowired
    private CareerRepository careerRepository;

    public Career saveNewForm(Career newForm) {
        return careerRepository.save(newForm);
    }
    public List<Career> findCareerByUserId(Long userId) {
        return careerRepository.findAllByUserId(userId);
    }
    public Career findById(Long id) {
        return careerRepository.findById(id).orElse(null);
    }
    public Career updateCareer(Career careerToEdit) {
        return careerRepository.save(careerToEdit);
    }

    public void deleteForm(Long id) {
      careerRepository.deleteById(id);
    }

}
