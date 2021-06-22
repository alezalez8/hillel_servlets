package org.hillel.controller.tl;


import org.hillel.controller.converter.StopMapper;
import org.hillel.controller.converter.VehicleMapper;
import org.hillel.controller.dto.StopDto;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.service.InputSearchParams;
import org.hillel.service.SearchQueryParam;
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
public class StopTLController {


    private final TicketClient ticketClient;
    private final StopMapper stopMapper;

    @Autowired
    public StopTLController(TicketClient ticketClient, StopMapper stopMapper) {
        this.ticketClient = ticketClient;
        this.stopMapper = stopMapper;
    }


    @GetMapping("/stops")
    public ModelAndView searchAll(Model model) {
        InputSearchParams searchParams = new InputSearchParams();
        searchParams.setMaxResult(8);
        //searchParams.setAscSort(true);
        model.addAttribute("inputSearchParams", searchParams);
        model.addAttribute("stops", Collections.emptyList());
        return searchStops(model, searchParams);

    }

    @PostMapping("/stops/search")
    public ModelAndView searchStops(Model model, @ModelAttribute("inputSearchParams") InputSearchParams searchParams) {
        Collection<StopEntity> stop = ticketClient.findAllStops(
                searchParams.getTotalPages(),
                searchParams.getMaxResult(),
                searchParams.getSortBy(),
                searchParams.isSortDirect(),
                searchParams.getFilterKey(),
                searchParams.getFilterValue());
        List<StopDto> stopDtos = stop.stream().map(stopMapper::stopToStopDto).collect(Collectors.toList());
        model.addAttribute("stops", stopDtos);
        System.out.println("==================================================================");
        System.out.println(searchParams);
        System.out.println("==================================================================");

        return new ModelAndView("stops_view", model.asMap());
    }


    @GetMapping("/stops/delete/{stopId}")
    public RedirectView deleteVehicle(@PathVariable("stopId") Long stopId) {
        ticketClient.deleteStopById(stopId);
        return new RedirectView("/tl/stops");
    }


    @GetMapping("/stop/view/{stopId}")
    public ModelAndView viewStop(Model model, @PathVariable("stopId") long stopId) {
        StopEntity stop = ticketClient.findStopById(stopId);
        StopDto stopDto = stopMapper.fullStopToDto(stop);
        model.addAttribute("stop", stopDto);
        return new ModelAndView("stop_view", model.asMap());

    }

    @PostMapping("/stops/save")
    public RedirectView save(@ModelAttribute("stopSave") StopDto stopDto) {
        StopEntity stopEntity = new StopEntity();
        stopEntity.setActive(true);
        stopEntity.setId(stopDto.getId());
        return new RedirectView("/tl/stops");
    }


}
