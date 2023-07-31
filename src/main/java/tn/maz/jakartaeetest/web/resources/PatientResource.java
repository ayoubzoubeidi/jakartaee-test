package tn.maz.jakartaeetest.web.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tn.maz.jakartaeetest.persistence.PatientDao;

@Path("/patients")
public class PatientResource {

    private final PatientDao patientDao;

    @Inject
    public PatientResource(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("patientId") Long patientId) {
        return Response.ok(patientDao.getPatientById(patientId)).build();
    }

}