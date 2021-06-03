package org.hillel.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.WebServlet;

//@Controller
//@WebServlet("/myApp")
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcomePage() { // we need return view, redirect or modelview
        System.out.println("__________________________");
        return "welcome";  // map to welcome.jsp
    }

    @RequestMapping("/auth")
    public String authPage() {
        return "login";
    }
}
