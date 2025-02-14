package com.example.sara.loginregistera.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name="careers")
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 255, message = "First Name should be from 3 to 255 characters")
    private String firstName;


    @NotEmpty
    @Size(min = 2, max = 255, message = "Last Name should be from 3 to 255 characters")
    private String lastName;

    @NotEmpty(message="Please enter your email!")
    @Email(message = "Email is in the improper")
    private String email;

    @Column(length = 13, nullable = false)
    @Pattern(regexp="^\\+355\\d{8,9}$", message="Phone number must start with +355 and be 8-9 digits long")
    private String phone;

    @Size(min = 2, max = 255, message = "The Team Name should be from 3 to 255 characters")
    private String address;

    @NotNull(message="Please enter your experience numbers!")
    @Min(1)
    @Max(10)
    private Integer experience;

    @NotNull(message="Please select!")
    private Boolean degree;

    @Size(min = 15, max = 1000, message = "The cover letter should be more than 15 characters")
    private String cover;

    @Enumerated(EnumType.STRING)
    private WorkType workType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    private String cvFilePath;

    public Career() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Boolean getDegree() {
        return degree;
    }

    public void setDegree(Boolean degree) {
        this.degree = degree;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCvFilePath() {
        return cvFilePath;
    }

    public void setCvFilePath(String cvFilePath) {
        this.cvFilePath = cvFilePath;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
