package com.saurabbhorg.mapping.controllers;

import com.saurabbhorg.mapping.entities.AdmissionRecordEntity;
import com.saurabbhorg.mapping.services.AdmissionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/admissionRecord")
public class AdmissionRecordController {
    @Autowired
    private AdmissionRecordService admissionRecordService;

    @GetMapping(path = "/{admission_record_id}")
    public Optional<AdmissionRecordEntity> getRegistrationDetails(@PathVariable Long admission_record_id) {
        return admissionRecordService.getRegistrationDetails(admission_record_id);
    }

    @PostMapping
    public AdmissionRecordEntity doRegistration(@RequestBody AdmissionRecordEntity admissionRecordEntity) {
        return admissionRecordService.doRegistration(admissionRecordEntity);
    }

    @DeleteMapping(path = "/{admission_record_id}")
    public Boolean deleteRegisteredRecord(@PathVariable Long admission_record_id) {
        return admissionRecordService.deleteRegisteredRecord(admission_record_id);
    }
}
