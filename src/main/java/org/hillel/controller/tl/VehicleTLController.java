package org.hillel.controller.tl;


import org.hillel.controller.converter.VehicleMapper;
import org.hillel.controller.dto.VehicleDto;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.service.TicketClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.stream.Collectors;

@Controller
public class VehicleTLController {

   /* @Autowired
    private TicketClient ticketClient;*/

    private final TicketClient ticketClient;
    private final VehicleMapper vehicleMapper;

    //@Autowired
    public VehicleTLController(TicketClient ticketClient, VehicleMapper vehicleMapper) {
        this.ticketClient = ticketClient;
        this.vehicleMapper = vehicleMapper;
    }

    /*@GetMapping("/vehicles")
    public String homeVehiclesPage(Model model) {
        Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
        model.addAttribute("vehicles", allVehicles); // в vehicles_view.html в ${vehicles} передаем allVehicles
        return "vehicles_view";
    }*/
// =============== use vehicleMapper ======================================================
    @GetMapping("/vehicles")
    public String homeVehiclesPage(Model model) {
       Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
         model.addAttribute("vehicles", allVehicles.stream()
                .map(item -> vehicleMapper.vehicleToVehicleDto(item))
                .collect(Collectors.toList()));
//        model.addAttribute("vehicles", allVehicles);
        return "vehicles_view";
    }


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

    // можно вместо стринга передать ModelAndView, и вернуть return new ModelAndView("vehicles_view", model.asMap());
    @GetMapping("/vehicle/delete/{vehicleId}")
    public RedirectView deleteVehicle(@PathVariable(value = "vehicleId") Long vehicleId) {
        ticketClient.removeVehicle(ticketClient.findVehicleById(vehicleId, false).get());
        return new RedirectView("/tl/vehicles");
    }


    // =============== use vehicleMapper ======================================================

    @PostMapping("/vehicle/save")
    public RedirectView save(@ModelAttribute("vehSave") VehicleDto vehicleDto) {
       ticketClient.createOrUpdateVehicle(vehicleMapper.vehicleDtoToVehicle(vehicleDto));
        return new RedirectView("/tl/vehicles");
    }


    /*@PostMapping("/vehicle/save")
    public RedirectView save(@ModelAttribute("vehSave") VehicleDto vehicleDto) {
        VehicleEntity vehicleEntity = new VehicleEntity();
        vehicleEntity.setName(vehicleDto.getName());
        ticketClient.createOrUpdateVehicle(vehicleEntity);
        return new RedirectView("/tl/vehicles");
    }*/
}
