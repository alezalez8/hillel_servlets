package org.hillel.service;

import org.hillel.persistence.entity.StopEntity;
import org.hillel.persistence.entity.VehicleEntity;
import org.hillel.persistence.jpa.repository.StopJpaRepository;
import org.hillel.persistence.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
public class TransactionalStopService {

    @Autowired
    private StopJpaRepository stopRepository;


    @Transactional()
    public void remove(StopEntity stopEntity) {
        stopRepository.delete(stopEntity);

    }

    @Transactional
    public StopEntity createOrUpdate(StopEntity stopEntity) {
        return stopRepository.save(stopEntity);
    }

    @Transactional(readOnly = true)
    public Optional<StopEntity> findStopById(Long id) {
        final Optional<StopEntity> byId = stopRepository.findById(id);
        if (!byId.isPresent()) return byId;
        return byId;
    }

    @Transactional
    public void deleteStopById(Long id) {
        stopRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Collection<StopEntity> findAllStops() {
        return stopRepository.findAll();

    }
}

