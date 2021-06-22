package org.hillel.service;

import org.hillel.persistence.entity.JourneyEntity;
import org.hillel.persistence.jpa.repository.JourneyJpaRepository;
import org.hillel.persistence.repository.JourneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service(value = "transactionalJourneyService")
public class TransactionalJourneyService {

    @Autowired
    private JourneyJpaRepository journeyRepository;


    @Transactional
    public JourneyEntity createOrUpdateJourney(final JourneyEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Unable to create new record");
        }//
        return journeyRepository.save(entity);

    }


    @Transactional(readOnly = true)
    public Optional<JourneyEntity> findById(Long id, boolean withDependencies) {
        final Optional<JourneyEntity> byId = journeyRepository.findById(id);
        if (withDependencies && byId.isPresent()) {
            final JourneyEntity journeyEntity = byId.get();
            journeyEntity.getVehicle().getName();  //
            journeyEntity.getStops().size();        // get table in case lazy
        }
        return byId;
    }

    @Transactional(readOnly = true)
    public JourneyEntity findById(Long id) {
        final Optional<JourneyEntity> byId = journeyRepository.findById(id);
        if(!byId.isPresent()) return byId.get();
        return byId.get();
    }




    @Transactional(readOnly = true)
    public Collection<JourneyEntity> findAllJourneys() {
        return journeyRepository.findAll();
    }

    @Transactional
    public void remove(JourneyEntity journey) {
        journeyRepository.delete(journey);
    }

    @Transactional
    public void removeById(Long journeyId) {
        journeyRepository.disableById(journeyId);
    }
}