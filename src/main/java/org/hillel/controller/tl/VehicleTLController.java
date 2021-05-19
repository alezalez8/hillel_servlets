package org.hillel.controller.tl;


import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.service.TicketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class VehicleTLController {


    @Autowired
    private TicketClient ticketClient;

    @GetMapping("/vehicles")
    public String homeVehiclesPage(Model model) {
        Collection<VehicleEntity> allVehicles = ticketClient.findAllVehicles();
        model.addAttribute("vehicles", allVehicles); // в vehicles_view.html в ${vehicles} передаем allVehicles
        return "vehicles_view";
    }
}
