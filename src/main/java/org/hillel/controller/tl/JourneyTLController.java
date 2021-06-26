package org.hillel.controller.tl;


import org.hillel.controller.converter.VehicleMapper;
import org.hillel.controller.dto.StopDto;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
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
public class JourneyTLController {


    private final TicketClient ticketClient;
    private final VehicleMapper vehicleMapper;

    @Autowired
    public JourneyTLController(TicketClient ticketClient, VehicleMapper vehicleMapper) {
        this.ticketClient = ticketClient;
        this.vehicleMapper = vehicleMapper;
    }




    @GetMapping("/journeys")
    public ModelAndView searchAll(Model model) {
        InputSearchParams searchParams = new InputSearchParams();
        searchParams.setMaxResult(8);
        model.addAttribute("inputSearchParams", searchParams);
        model.addAttribute("stops", Collections.emptyList());
        return searchJourneys(model, searchParams);

    }
    @PostMapping("/journeys/search")
    public ModelAndView searchJourneys(Model model, @ModelAttribute("inputSearchParams") InputSearchParams searchParams) {
        Collection<JourneyEntity> jorneys = ticketClient.findAllJorneys(
                searchParams.getTotalPages(),
                searchParams.getMaxResult(),
                searchParams.getSortBy(),
                searchParams.isSortDirect(),
                searchParams.getFilterKey(),
                searchParams.getFilterValue());
       // List<StopDto> stopDtos = stop.stream().map(stopMapper::stopToStopDto).collect(Collectors.toList());
       // model.addAttribute("stops", stopDtos);
        return new ModelAndView("journeys_view", model.asMap());
    }


    @GetMapping("/journeys/delete/{id}")
    public RedirectView deleteJourneys(@PathVariable("id") Long journeyId) {
        ticketClient.removeJourneyById(journeyId);
        return new RedirectView("/tl/journeys");
    }


    @GetMapping("/journeys/view/{id}")
    public ModelAndView viewStop(Model model, @PathVariable("id") long stopId) {
        JourneyEntity journeyEntity = ticketClient.findJourneyById(stopId);
       // StopDto stopDto = stopMapper.fullStopToDto(stop);
       // model.addAttribute("stop", stopDto);
        return new ModelAndView("journeys_view", model.asMap());

    }

}
