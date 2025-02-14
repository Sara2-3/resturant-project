package com.example.sara.loginregistera.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotEmpty(message = "Please select a number")
//    @Min(1)
//    @Max(20)
//    private Integer person;
//
//    @NotNull(message = "Please select a date")
//    @FutureOrPresent(message = "Date must be today or in the future")
//    private LocalDate date;
//
//    @NotNull(message = "Please select a time")
//    // Apply the custom validation
//    private LocalTime time;

    @NotNull(message = "Number of people is required")
    @Min(value = 1, message = "At least 1 person is required")
    @Max(value = 10, message = "Maximum 10 people allowed")
    private Integer person;

    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Date must be today or in the future")
    private LocalDate date;

    @NotNull(message = "Time is required")
    private LocalTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}