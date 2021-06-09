package org.hillel.controller.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome")
    public String welcomePage() { // we need return view, redirect or modelview
        return "welcome";  // map to welcome.jsp
    }


    @RequestMapping(path = "/auth", method = RequestMethod.POST) // for example
    public String authPage() {
        return "login";
    }
}