package com.example.sara.loginregistera.controller;


import com.example.sara.loginregistera.model.Reservation;
import com.example.sara.loginregistera.model.User;
import com.example.sara.loginregistera.service.ReservationService;
import com.example.sara.loginregistera.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ReservationController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private HttpSession session;

    @GetMapping("/home")
    public String home(Model model) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        User currentLoggedUser = userService.getUserById(userID);
        model.addAttribute("loggedInUser", currentLoggedUser);
            return "home";
    }
    @GetMapping("/menu")
    public String menu(Model model) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        User currentLoggedUser = userService.getUserById(userID);
        model.addAttribute("loggedInUser", currentLoggedUser);
            return "menu-part";
        }


    @GetMapping("/reservation/view")
    public String allReservation(Model viewModel) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        List<Reservation> userReservations = reservationService.findReservationsByUserId(userID);
        viewModel.addAttribute("allReservation", userReservations);

        User currentLoggedUser = userService.getUserById(userID);
        viewModel.addAttribute("loggedInUser", currentLoggedUser);

        return "view-reservation";
    }


    @GetMapping("/reservation/create")
    public String reservation(@ModelAttribute("createReservation") Reservation createReservation ) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        User currentLoggedUser = userService.getUserById(userID);
        return "create-reservation";
    }
    @PostMapping("/reservation/book")
    public String bookTable(@Valid @ModelAttribute("createReservation")Reservation createReservation, BindingResult bindingResult) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        if (bindingResult.hasErrors()) {
            return "create-reservation";
        }
        if (createReservation.getTime() != null) {
            int minutes = createReservation.getTime().getMinute();
            if (minutes % 30 != 0) {
                bindingResult.rejectValue("time", "error.createReservation", "Time must be in 30-minute intervals (e.g., 12:00, 12:30).");
            }
        }

        if (createReservation.getDate() != null && createReservation.getDate().isBefore(LocalDate.now())) {
            bindingResult.rejectValue("date", "error.createReservation", "Date must be today or in the future.");
        }

        User currentLoggedUser = userService.getUserById(userID);
        createReservation.setUser(currentLoggedUser);
        reservationService.saveReservation(createReservation);
        return "redirect:/reservation/view";
    }

    @GetMapping("reservation/{id}")
    public String viewTeam(@PathVariable Long id, Model model) {
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        Long userID = (Long) session.getAttribute("userID");
        Reservation reservation = reservationService.findById(id);

        if (reservation == null || !reservation.getUser().getId().equals(userID)) {
            return "redirect:/home";
        }

        model.addAttribute("reservation", reservation);
        User loggedInUser = userService.getUserById(userID);
        model.addAttribute("loggedInUser", loggedInUser);

        return "details";
        }


    @GetMapping("/reservation/{id}/edit")
    public String editReservation(@PathVariable Long id, Model model) {
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }

        Long userID = (Long) session.getAttribute("userID");
        Reservation reservation = reservationService.findById(id);


        if (reservation == null || !reservation.getUser().getId().equals(userID)) {
            return "redirect:/home";
        }

        model.addAttribute("reservationToEdit", reservation);
        return "editReservation";
    }

    @PutMapping("/reservation/{id}/update")
    public String updateTeam(@PathVariable("id") Long id, @Valid @ModelAttribute("reservationToEdit") Reservation reservationToEdit, BindingResult bindingResult) {
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        Long userID = (Long) session.getAttribute("userID");
        Reservation originalReservation = reservationService.findById(id);

        if (originalReservation == null || !originalReservation.getUser().getId().equals(userID)) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            return "editReservation";
        }

        reservationToEdit.setUser(userService.getUserById(userID));
        reservationService.updateReservation(reservationToEdit);
        return "redirect:/reservation/view";
    }
    @DeleteMapping("/reservation/{id}/delete")
    public String deleteTeamFromDB(@PathVariable("id") Long id){
        if(session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        Long userID = (Long) session.getAttribute("userID");
        Reservation reservation = reservationService.findById(id);

        if (reservation == null || !reservation.getUser().getId().equals(userID)) {
            return "redirect:/home";
        }
        reservationService.deleteReservation(id);
        return "redirect:/home";
    }

}
