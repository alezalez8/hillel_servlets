package org.hillel.controller.tl;


import org.hillel.controller.converter.StopMapper;
import org.hillel.controller.dto.StopDto;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.service.InputSearchParams;
import org.hillel.service.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WelcomeTLController {


    private final TicketClient ticketClient;


    @Autowired
    public WelcomeTLController(TicketClient ticketClient) {
        this.ticketClient = ticketClient;

    }


    @GetMapping("/welcome")
    public ModelAndView welcome() {


        return new ModelAndView("welcome");
    }


}
