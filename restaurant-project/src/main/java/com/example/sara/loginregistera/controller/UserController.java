package com.example.sara.loginregistera.controller;

import com.example.sara.loginregistera.model.LoginUser;
import com.example.sara.loginregistera.model.User;
import com.example.sara.loginregistera.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userServ;

    @GetMapping("/")
    public String loginRegPage(Model viewModel){
        viewModel.addAttribute("newUser", new User());
        viewModel.addAttribute("newLogin", new LoginUser());

        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model viewModel) {
        viewModel.addAttribute("newUser", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(Model viewModel,
                               @Valid @ModelAttribute("newUser") User newUser,
                               BindingResult bindingResult,
                               HttpSession session) {

        if (!newUser.isAcceptTerms()) {
            bindingResult.rejectValue("acceptTerms", "error.newUser", "You must accept the Terms of Use & Privacy Policy.");
        }

        User possibleUser = userServ.validateRegistration(newUser, bindingResult);
        if (bindingResult.hasErrors()) {
            viewModel.addAttribute("newLogin", new LoginUser());
            return "registration";
        }

        session.setAttribute("userID", possibleUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                            BindingResult bindingResult,
                            HttpSession session,
                            Model viewModel) {
        User possibleUser = userServ.validateLogin(newLogin, bindingResult);
        if (bindingResult.hasErrors()) {
            viewModel.addAttribute("newUser", new User());
            return "login";
        }

        session.setAttribute("userID", possibleUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/logout")
    public String logoutUserOut(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
