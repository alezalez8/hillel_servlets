package org.hillel.controller;

//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcomePage() { // we need return view, redirect or modelview
        return "welcome";  // map to welcome.jsp
    }

    @RequestMapping("/auth")
    public String authPage() {
        return "login";
    }
}
