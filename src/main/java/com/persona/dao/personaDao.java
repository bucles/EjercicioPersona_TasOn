/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.dao;

import com.persona.modelo.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Marco
 */
@Stateless
@ApplicationPath("/resources")
@Path("personas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class personaDao extends Application {  

    @PersistenceContext
    private EntityManager entityManager;
    @GET
    @Path("{percedula}")
    public Persona obtenerPersonaPorCedula(@PathParam("percedula") Long cedula) {
        try {
            return entityManager.find(Persona.class, cedula);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        
    }

    @POST
    public Persona guardarPersona(Persona persona) {
        
        try {
            entityManager.persist(persona);
            //listarPersonas();
            return persona;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        
    }
    
     
    private List<Persona> listarPersonas() {
        Query query = entityManager.createQuery("SELECT p FROM Persona p ORDER BY p.percedula");
        
        return query.getResultList();
      }  

    @DELETE
    @Path("{percedula}")
    public void borrarPersona(@PathParam("percedula") Long percedula) {
        entityManager.remove(obtenerPersonaPorCedula(percedula));
    }
    
}
