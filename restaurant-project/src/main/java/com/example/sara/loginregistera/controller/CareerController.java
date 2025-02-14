package com.example.sara.loginregistera.controller;


import com.example.sara.loginregistera.model.Career;
import com.example.sara.loginregistera.model.User;
import com.example.sara.loginregistera.service.CareerService;
import com.example.sara.loginregistera.service.FileStorageService;
import com.example.sara.loginregistera.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.List;

@Controller
public class CareerController {

    @Autowired
    private CareerService careerService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("/career")
    public String career(Model model) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        User currentLoggedUser = userService.getUserById(userID);
        model.addAttribute("loggedInUser", currentLoggedUser);
        return "job-description";
    }

    @GetMapping("/career/new")
    public String newForm(@ModelAttribute("newForm") Career newFrom,Model model) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        List<Career> existingApplications = careerService.findCareerByUserId(userID);
        if (!existingApplications.isEmpty()) {
            model.addAttribute("errorMessage", "You have already applied before and cannot apply again.");
            return "redirect:/career";
        }
        User currentLoggedUser = userService.getUserById(userID);
        return "careerForm";
    }
//pjesa e pdf
//    @PostMapping("/careers/add")
//    public String addForm(@Valid @ModelAttribute("newForm") Career newForm,
//                          BindingResult bindingResult,
//                          @RequestParam("cvFile") MultipartFile cvFile,
//                          Model model) throws IOException {
//        Long userID = (Long) session.getAttribute("userID");
//        if (session.getAttribute("userID") == null) {
//            return "redirect:/"; // Redirect to login if user is not logged in
//        }
//
//        // Validate the form
//        if (bindingResult.hasErrors()) {
//            return "careerForm"; // Return to the form if there are validation errors
//        }
//
//        // Validate the file
//        if (cvFile.isEmpty()) {
//            model.addAttribute("cvFileError", "Please upload your CV!");
//            return "careerForm"; // Return to the form with an error message
//        }
//
//        if (!cvFile.getContentType().equals("application/pdf")) {
//            model.addAttribute("cvFileError", "Only PDF files are allowed for CV upload.");
//            return "careerForm"; // Return to the form with an error message
//        }
//
//        // Save the file and set the file path in the Career object
//        String cvFilePath = fileStorageService.storeFile(cvFile); // Implement this service
//        newForm.setCvFilePath(cvFilePath);
//
//        // Set the user for the Career object
//        User currentLoggedUser = userService.getUserById(userID);
//        newForm.setUser(currentLoggedUser);
//
//        // Save the Career object
//        careerService.saveNewForm(newForm);
//
//        return "redirect:/careers/view"; // Redirect to the career list after successful submission
//    }
@PostMapping("/careers/add")
public String addForm(@Valid @ModelAttribute("newForm") Career newForm,
                      BindingResult bindingResult,
                      @RequestParam("cvFile") MultipartFile cvFile,
                      Model model) throws IOException {
    Long userID = (Long) session.getAttribute("userID");
    if (session.getAttribute("userID") == null) {
        return "redirect:/";
    }
    System.out.println("File Name: " + cvFile.getOriginalFilename());
    System.out.println("File Size: " + cvFile.getSize());
    System.out.println("File Content Type: " + cvFile.getContentType());
    if (cvFile.isEmpty()) {
        model.addAttribute("cvFileError", "Please upload an image!");
        System.out.println("Image file is empty.");
        return "careerForm";
    }
    if (!careerService.findCareerByUserId(userID).isEmpty()) {
        model.addAttribute("applyError", "You have already applied for this position.");
        return "job-description";
    }

    if (!cvFile.getContentType().startsWith("image/")) {
        model.addAttribute("cvFileError", "Only image files (JPEG, PNG) are allowed.");
        System.out.println("Invalid file type: " + cvFile.getContentType());
        return "careerForm";
    }
    String cvFilePath = fileStorageService.storeFile(cvFile);
    newForm.setCvFilePath(cvFilePath);
    System.out.println("Image File Path: " + cvFilePath);
    if (bindingResult.hasErrors()) {
        System.out.println("Form validation errors: " + bindingResult.getAllErrors());
        return "careerForm";
    }
    User currentLoggedUser = userService.getUserById(userID);
    newForm.setUser(currentLoggedUser);
    System.out.println("Career object before saving: " + newForm.toString());
    careerService.saveNewForm(newForm);

    return "redirect:/careers/view";
}
    @GetMapping("/careers/view")
    public String allCareer(Model viewModel) {
        Long userID = (Long) session.getAttribute("userID");
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        List<Career> userCareer = careerService.findCareerByUserId(userID);
        viewModel.addAttribute("allCareer", userCareer);

        User currentLoggedUser = userService.getUserById(userID);
        viewModel.addAttribute("loggedInUser", currentLoggedUser);

        return "view-form";
    }

    @GetMapping("careers/{id}")
    public String viewForm(@PathVariable Long id, Model model) {
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        Long userID = (Long) session.getAttribute("userID");
        Career career = careerService.findById(id);

        model.addAttribute("career", career);
        User loggedInUser = userService.getUserById(userID);
        model.addAttribute("loggedInUser", loggedInUser);

        return "details-form";
    }
//pjesa e pdf
//    @GetMapping("/download")
//    public ResponseEntity<Resource> downloadFile(@RequestParam String file) {
//        Path filePath = fileStorageService.getFileStorageLocation().resolve(file).normalize();
//        Resource resource;
//        try {
//            resource = new UrlResource(filePath.toUri());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("File URL is invalid: " + file, e);
//        }
//
//        if (resource.exists()) {
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                    .body(resource);
//        } else {
//            throw new RuntimeException("File not found: " + file);
//        }
//    }
@GetMapping("/download")
public ResponseEntity<Resource> downloadFile(@RequestParam String file) {
    Path filePath = fileStorageService.getFileStorageLocation().resolve(file).normalize();
    Resource resource;
    try {
        resource = new UrlResource(filePath.toUri());
    } catch (MalformedURLException e) {
        throw new RuntimeException("File URL is invalid: " + file, e);
    }

    if (resource.exists()) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    } else {
        throw new RuntimeException("File not found: " + file);
    }
}
    //edit
    @GetMapping("/careers/{id}/edit")
    public String editApplication(@PathVariable Long id, Model model) {
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }

        Long userID = (Long) session.getAttribute("userID");
        Career career = careerService.findById(id);
        if (career == null || !career.getUser().getId().equals(userID)) {
            return "redirect:/home";
        }

        model.addAttribute("careerToEdit", career);
        return "editForm";
    }

    @PutMapping("/careers/{id}/update")
    public String updateForm(@PathVariable("id") Long id, @Valid @ModelAttribute("careerToEdit") Career careerToEdit, BindingResult bindingResult) {
        if (session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        Long userID = (Long) session.getAttribute("userID");
        Career originalCareer = careerService.findById(id);
        if (originalCareer == null || !originalCareer.getUser().getId().equals(userID)) {
            return "redirect:/home";
        }

        if (bindingResult.hasErrors()) {
            return "editFrom";
        }

        careerToEdit.setUser(userService.getUserById(userID));
        careerService.updateCareer(careerToEdit);
        return "redirect:/careers/view";
    }
    @DeleteMapping("/careers/{id}/delete")
    public String deleteFromfromDB(@PathVariable("id") Long id){
        if(session.getAttribute("userID") == null) {
            return "redirect:/";
        }
        Long userID = (Long) session.getAttribute("userID");
        Career career = careerService.findById(id);

        if (career == null || !career.getUser().getId().equals(userID)) {
            return "redirect:/home"; // Redirect to home if unauthorized
        }

        careerService.deleteForm(id);
        return "redirect:/home";
    }

}