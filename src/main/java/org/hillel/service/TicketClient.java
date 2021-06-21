package org.hillel.service;

import org.hibernate.cfg.Environment;
import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.persistence.jpa.repository.SimpleVehicleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
public class TicketClient {

    /*//@Autowired
    private List<JourneyService> journeyServices;
*/
    @Autowired
    private TransactionalJourneyService journeyService;

    @Autowired
    private TransactionalStopService stopService;


    @Autowired
    private TransactionalVehicleService vehicleService;

    // @Autowired
    private Environment environment;

    @Value("${datasource.url}")
    private String url;

    public TicketClient() {
    }


    public Optional<JourneyEntity> getJourneyById(Long id, boolean withDependencies) {
        return id == null ? Optional.empty() : journeyService.findById(id, withDependencies);
    }

    public StopEntity createOrUpdateStop(final StopEntity stopEntity) {
        return stopService.createOrUpdate(stopEntity);
    }

    public JourneyEntity createOrUpdateJourney(JourneyEntity journey) {
        //todo check
        return journeyService.createOrUpdateJourney(journey);
    }


    public Collection<VehicleEntity> veryLittleTest(String name) {
        return vehicleService.littleTest(name);
    }


    public VehicleEntity createOrUpdateVehicle(VehicleEntity vehicle) {
        return vehicleService.createOrUpdate(vehicle);

    }

    public void remove(JourneyEntity journey) {
        journeyService.remove(journey);
    }

    public void removeById(Long journeyId) {
        journeyService.removeById(journeyId);
    }

    public void removeVehicle(final VehicleEntity vehicleEntity) {
        vehicleService.remove(vehicleEntity);
    }

    public void removeStops(final StopEntity stopEntity) {
        stopService.remove(stopEntity);
    }

    /*public void findStopById(final Long id) {
        stopService.findStopById(id);
    }*/
    public StopEntity findStopById(final Long id) {
        return stopService.findStopById(id);
    }


    public void deleteStopById(final Long id) {
        stopService.deleteStopById(id);
    }


    public Collection<VehicleEntity> findVehicleByids(Long... ids) {
        return vehicleService.findByIds();
    }

    public Optional<VehicleEntity> findVehicleById(Long id, boolean withDependencies) {
        return vehicleService.findById(id, withDependencies);
    }

    public Collection<VehicleEntity> findAllVehicles() {
        return vehicleService.findAll();
    }

    public Collection<StopEntity> findAllStops(
            int pageIndex,
            int maxResult,
            String getSortBy,
            boolean isAscSort,
            String filterKey,
            String filterValue
    ) {
//        QueryContext queryContext = new QueryContext(pageIndex, maxResult, getSortBy, isAscSort, filterKey, filterValue);
      // SearchQueryParam queryParam = new QueryContext(pageIndex, maxResult, getSortBy, isAscSort, filterKey, filterValue);
        return stopService.findAllStops();
    }


    public Collection<VehicleEntity> findAllVehiclesByName(String name) {
        return vehicleService.findByName(name);
    }

    public Collection<VehicleEntity> findAllByName(String name) {
        return vehicleService.findAllByName(name);
    }

    public void disableById(Long id) {
        vehicleService.disableById(id);
    }


    public List<SimpleVehicleDto> listAllSimpleVehicles() {
        return vehicleService.listAllSimpleVehicles();
    }

}

