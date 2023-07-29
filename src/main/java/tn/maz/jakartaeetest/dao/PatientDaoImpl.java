package tn.maz.jakartaeetest.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import tn.maz.jakartaeetest.domain.Patient;

@ApplicationScoped
public class PatientDaoImpl implements PatientDao {

    @Override
    public void createPatient(Patient patient) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("default");

        var em = entityManagerFactory.createEntityManager();
        var tx = em.getTransaction();
        tx.begin();
        em.persist(patient);
        em.flush();
        tx.commit();
    }
}
