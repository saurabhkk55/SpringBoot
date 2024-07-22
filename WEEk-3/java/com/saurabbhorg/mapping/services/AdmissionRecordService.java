package com.saurabbhorg.mapping.services;

import com.saurabbhorg.mapping.entities.AdmissionRecordEntity;
import com.saurabbhorg.mapping.repositories.AdmissionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {
    @Autowired
    private AdmissionRecordRepository admissionRecordRepository;

    public AdmissionRecordEntity doRegistration(AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordRepository.save(admissionRecordEntity);
    }

    public Optional<AdmissionRecordEntity> getRegistrationDetails(Long admissionRecordId) {
        return admissionRecordRepository.findById(admissionRecordId);
    }

    public Boolean deleteRegisteredRecord(Long admissionRecordId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = getRegistrationDetails(admissionRecordId);
        if (admissionRecordEntity.isPresent()) {
            admissionRecordRepository.deleteById(admissionRecordId);
            return true;
        } else {
            return false;
        }
    }
}
