package org.hillel.controller.tl;


import org.hillel.controller.converter.VehicleMapper;
import org.hillel.controller.dto.StopDto;
import org.hillel.controller.dto.VehicleDto;
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
        //searchParams.setAscSort(true);
        model.addAttribute("inputSearchParams", searchParams);
        model.addAttribute("stops", Collections.emptyList());
        return searchJourneys(model, searchParams);

    }
    @PostMapping("/journeys/search")
    public ModelAndView searchJourneys(Model model, @ModelAttribute("inputSearchParams") InputSearchParams searchParams) {
        Collection<StopEntity> stop = ticketClient.findAllStops(
                searchParams.getTotalPages(),
                searchParams.getMaxResult(),
                searchParams.getSortBy(),
                searchParams.sortDirect,
                searchParams.getFilterKey(),
                searchParams.getFilterValue());
       // List<StopDto> stopDtos = stop.stream().map(stopMapper::stopToStopDto).collect(Collectors.toList());
       // model.addAttribute("stops", stopDtos);
        return new ModelAndView("journeys_view", model.asMap());
    }


    @GetMapping("/journeys/delete/{stopId}")
    public RedirectView deleteVehicle(@PathVariable("stopId") Long stopId) {

        ticketClient.deleteStopById(stopId);
        return new RedirectView("/tl/journeys");
    }


    @GetMapping("/journeys/view/{stopId}")
    public ModelAndView viewStop(Model model, @PathVariable("stopId") long stopId) {
        StopEntity stop = ticketClient.findStopById(stopId);
       // StopDto stopDto = stopMapper.fullStopToDto(stop);
       // model.addAttribute("stop", stopDto);
        return new ModelAndView("stop_view", model.asMap());

    }

   /* @GetMapping("/vehicles")
    public String homeVehiclesPage(Model model) {
        Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
        model.addAttribute("vehicles", allVehicles.stream()
                .map(item -> vehicleMapper.vehicleToVehicleDto(item))
                .collect(Collectors.toList()));
        return "vehicles_view";
    }



    @GetMapping("/vehicle/delete/{vehicleId}")
    public RedirectView deleteVehicle(@PathVariable("vehicleId") Long vehicleId) {
        ticketClient.removeVehicle(ticketClient.findVehicleById(vehicleId, false).get());
        return new RedirectView("/tl/vehicles");
    }


    @PostMapping("/vehicle/save")
    public RedirectView save(@ModelAttribute("vehSave") VehicleDto vehicleDto) {
        ticketClient.createOrUpdateVehicle(vehicleMapper.vehicleDtoToVehicle(vehicleDto));
        return new RedirectView("/tl/vehicles");
    }*/






    /*@GetMapping("/vehicles")
    public String homeVehiclesPage(Model model) {
        Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
        model.addAttribute("vehicles", allVehicles); // в vehicles_view.html в ${vehicles} передаем allVehicles
        return "vehicles_view";
    }*/

    // =============== variant 2 ======================================================
   /* @GetMapping("/vehicles")
    public ModelAndView homeVehiclesPage(Model model) {
        Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
        model.addAttribute("vehicles", allVehicles); // в vehicles_view.html в ${vehicles} передаем allVehicles
        return new ModelAndView("vehicles_view", model.asMap());
    }*/


// ================== parsing input url var 1 ==================================

    // /vehicle/delete/?id=1&name=test
   /* @GetMapping("/vehicle/delete")
    public String deleteVehicle(@RequestParam("id") long vehicleId,
                                @RequestParam(value = "name", required = false) String vehicle) {
        return null;
    }*/
// ================== parsing input url var 2 ==================================
    /*@GetMapping("/vehicle/delete/{vehicleId}")
    public String deleteVehicle(@PathVariable("vehicleId") Long vehicleId) {
        ticketClient.removeVehicle(ticketClient.findVehicleById(vehicleId, false).get());
        return "redirect:/tl/vehicles";
    }*/



    /*@PostMapping("/vehicle/save")
    public RedirectView save(@ModelAttribute("vehSave") VehicleDto vehicleDto) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setName(vehicleDto.getName());
        ticketClient.createOrUpdateVehicle(vehicleEntity);
        return new RedirectView("/tl/vehicles");
    }*/
}
