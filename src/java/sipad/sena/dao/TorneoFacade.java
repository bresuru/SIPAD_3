/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sipad.sena.entidades.Torneo;

/**
 *
 * @author APRENDIZ
 */
@Stateless
public class TorneoFacade extends AbstractFacade<Torneo> implements TorneoFacadeLocal {

    @PersistenceContext(unitName = "SIPAD_3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TorneoFacade() {
        super(Torneo.class);
    }
    
    @Override
    public List<Torneo> findEstado(int estado, int idAlumno) {

        List<Torneo> listaTorneo = null;
        
        try {
            
            Query query = em.createQuery("SELECT t FROM Torneo t WHERE t.idEstado.idEstadoUsuario = :estado");
            
            query.setParameter("estado", estado);
            
            listaTorneo = query.getResultList();
            
        } catch (Exception e) {
            throw e;
        }
        
        return listaTorneo;
    }

    @Override
    public List<AlumnoHasTorneoFacade> findAlumnoTorneo(int idAlumno) {
        
        List<AlumnoHasTorneoFacade> listaTorneos = null;
        
        try {
            
            Query query = em.createQuery("SELECT t FROM AlumnoHasTorneo t WHERE t.alumnoIdAlumno.idAlumno = :idAlumno");
            
            query.setParameter("idAlumno", idAlumno);
            
            listaTorneos = query.getResultList();
            
        } catch (Exception e) {
            throw e;
        }
        
        return listaTorneos;
        
    }
    
}
