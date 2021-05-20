package org.hillel.controller.tl;


import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.service.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
public class VehicleTLController {


   /* @Autowired
    private TicketClient ticketClient;*/

    private TicketClient ticketClient;

    //@Autowired
    public VehicleTLController(TicketClient ticketClient) {
        this.ticketClient = ticketClient;
    }

    @GetMapping("/vehicles")
    public String homeVehiclesPage(Model model) {
        Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
        model.addAttribute("vehicles", allVehicles); // в vehicles_view.html в ${vehicles} передаем allVehicles
        return "vehicles_view";
    }

    // /vehicle/delete/?id=1&name=test
   /* @GetMapping("/vehicle/delete")
    public String deleteVehicle(@RequestParam("id") long vehicleId,
                                @RequestParam(value = "name", required = false) String vehicle) {
        return null;
    }*/

    @GetMapping("/vehicle/delete/{vehicleId}")
    public String deleteVehicle(@PathVariable("vehicleId") Long vehicleId) {
        ticketClient.removeVehicle(ticketClient.findVehicleById(vehicleId, false).get());
        return "redirect:/tl/vehicles";

    }
}
