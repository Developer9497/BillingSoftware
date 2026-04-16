package com.billingsoftware.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
//@RequestMapping("/resto")
//@CrossOrigin(origins = "*")
public class RestaurantController {

	  @GetMapping("/add-party")
	    public String AddParty() {
	        // Optionally add model attributes to pass data to the view
	        return "restaurant/partyDetailsModal"; // Returns the name of the HTML template (index.html)
	  }
	  @GetMapping("/add-product")
	    public String AddProduct() {
	        // Optionally add model attributes to pass data to the view
	        return "restaurant/Product"; // Returns the name of the HTML template (index.html)
	  }
	  @GetMapping("/add-purchesbill")
	    public String purchesbill() {
	        // Optionally add model attributes to pass data to the view
	        return "restaurant/purchesbill"; // Returns the name of the HTML template (index.html)
	  }
	  @GetMapping("/add-purchesbill2")
	    public String purchesbill2() {
	        // Optionally add model attributes to pass data to the view
	        return "restaurant/purchesbill2"; // Returns the name of the HTML template (index.html)
	  }
	  @GetMapping("/add-partyDetailsModal")
	    public String partyDetailsModal() {
	        // Optionally add model attributes to pass data to the view
	        return "restaurant/partyDetailsModal"; // Returns the name of the HTML template (index.html)
	  }
	  
	  
}
