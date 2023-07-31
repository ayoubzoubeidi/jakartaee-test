package tn.maz.jakartaeetest.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import tn.maz.jakartaeetest.domain.Patient;
import tn.maz.jakartaeetest.web.models.PatientDto;

@ApplicationScoped
public class PatientDaoImpl implements PatientDao {

    @Override
    public void createPatient(Patient patient) {
        var em = getEntityManager();
        var tx = em.getTransaction();
        tx.begin();
        em.persist(patient);
        em.flush();
        tx.commit();
    }

    @Override
    public PatientDto getPatientById(Long patientId) {
        var em = getEntityManager();
        var tx = em.getTransaction();
        tx.begin();
        var query = em.createQuery(
                "SELECT new tn.maz.jakartaeetest.web.models.PatientDto(p.id, p.firstName, p.lastName, p.email, p.phoneNumber) " +
                        "FROM Patient p WHERE p.id = :patientId", PatientDto.class
        );
        query.setParameter("patientId", patientId);
        var patient = query.getSingleResult();
        tx.commit();
        return patient;
    }

    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("default").createEntityManager();
    }
}
