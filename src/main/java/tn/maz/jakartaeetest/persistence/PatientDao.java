package tn.maz.jakartaeetest.persistence;

import tn.maz.jakartaeetest.domain.Patient;
import tn.maz.jakartaeetest.web.models.PatientDto;

public interface PatientDao {
    void createPatient(Patient patient);

    PatientDto getPatientById(Long patientId);
}
