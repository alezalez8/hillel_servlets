package org.hillel.controller.tl;


import org.hillel.controller.converter.StopMapper;
import org.hillel.controller.converter.VehicleMapper;
import org.hillel.controller.dto.StopDto;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.service.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
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
    public String homeStopsPage(Model model) {
        Collection<StopEntity> allStops = ticketClient.findAllStops();
        model.addAttribute("stops", allStops);
        /*model.addAttribute("stops", allStops.stream()
                .map(item -> vehicleMapper.vehicleToVehicleDto(item))
                .collect(Collectors.toList()));*/
        return "stops_view";
    }


    @GetMapping("/stops/delete/{stopId}")
    public RedirectView deleteVehicle(@PathVariable("stopId") Long stopId) {
        ticketClient.deleteStopById(stopId);
        return new RedirectView("/tl/stops");
    }


    @PostMapping("/stops/save")
    public RedirectView save(@ModelAttribute("stopSave") StopDto stopDto) {
        System.out.println("name is " + stopDto.getName());
        System.out.println("description is " + stopDto.getDescription());
        System.out.println("date is " + stopDto.getCreateDate());
        StopEntity stopEntity = new StopEntity();
        stopEntity.setActive(true);
       // stopEntity.setCreateDate(stopDto.setCreateDate());
        stopEntity.setId(stopDto.getId());
        //stopEntity.isActive(stopDto.getActive())

        return new RedirectView("/tl/stops");
    }


   /* @PostMapping("/stops/save")
    public RedirectView save(@ModelAttribute("stopSave") StopDto stopDto) {
        // ticketClient.createOrUpdateVehicle(vehicleMapper.vehicleDtoToVehicle(vehicleDto));
        ticketClient.createOrUpdateStop(stopMapper.stopDtoToStop(stopDto));
        return new RedirectView("/tl/stops");
    }*/

}
