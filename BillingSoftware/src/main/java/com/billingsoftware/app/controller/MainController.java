package com.billingsoftware.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
//@CrossOrigin(origins = "*")
public class MainController {

	
    @GetMapping("/dashboard")
    public String indexPage() {
        // Optionally add model attributes to pass data to the view
        return "pages/dashboard"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/expensecalendar")
    public String expenseCalendar() {
        // Optionally add model attributes to pass data to the view
        return "pages/expenseCalendar"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/collectioncalendar")
    public String collectionCalendar() {
        // Optionally add model attributes to pass data to the view
        return "pages/collectionCalendar"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/uploadexpense")
    public String uploadPage() {
        // Optionally add model attributes to pass data to the view
        return "pages/upload"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/uploadpayment")
    public String paymentReport() {
        // Optionally add model attributes to pass data to the view
        return "pages/paymentReport"; // Returns the name of the HTML template (index.html)
    }
    
    @GetMapping("/collection")
    public String showPaymentForm() {
        // Optionally add model attributes to pass data to the view
        return "pages/allcollection"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/expense")
    public String showExpensepage() {
        // Optionally add model attributes to pass data to the view
        return "pages/allexpense"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/allexpensereport")
    public String allexpensereport() {
        // Optionally add model attributes to pass data to the view
        return "pages/allexpensereport"; // Returns the name of the HTML template (index.html)
    }
    
    
    @GetMapping("/addcollection")
    public String addcollection() {
        // Optionally add model attributes to pass data to the view
        return "pages/addcollection"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/sign-in")
    public String signip() {
        // Optionally add model attributes to pass data to the view
        return "pages/sign-in"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/sign-up")
    public String signUp() {
        // Optionally add model attributes to pass data to the view
        return "pages/sign-up"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/check")
    public String checkdeatails() {
        // Optionally add model attributes to pass data to the view
        return "pages/checkdeatails"; // Returns the name of the HTML template (index.html)
    }
    @GetMapping("/")
    public String profile() {
        // Optionally add model attributes to pass data to the view
        return "pages/profile"; // Returns the name of the HTML template (index.html)
    }
}
