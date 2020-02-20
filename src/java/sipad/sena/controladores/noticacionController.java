/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.controladores;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import sipad.sena.dao.*;
import sipad.sena.entidades.*;

@Named
@RequestScoped
public class noticacionController {

    @EJB
    private NotificacionFacadeLocal notificacionFacadeLocal;
    private Notificacion notificacion;
    private List<Notificacion> listarNotificaciones;
    
    @EJB
    private TipoNotificacionFacadeLocal tipoNotificacionFacadeLocal;
    private TipoNotificacion tipoNotificacion;
    
    @EJB
    private SupervisorFacadeLocal supervisorFacadeLocal;
    private Supervisor supervisor;
    
    @EJB
    private UsuarioFacadeLocal usuarioFacadeLocal;
    private Usuario usuario;

    //Post construcutor
    @PostConstruct
    private void init() {

        notificacion = new Notificacion();
        tipoNotificacion = new TipoNotificacion();
        supervisor = new Supervisor();
        usuario = new Usuario();

        listarNotificaciones = notificacionFacadeLocal.findAll();

    }

    //GETHERS Y SETTHERS
    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public List<Notificacion> getListarNotificaciones() {
        return listarNotificaciones;
    }

    public void setListarNotificaciones(List<Notificacion> listarNotificaciones) {
        this.listarNotificaciones = listarNotificaciones;
    }

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public void setTipoNotificacion(TipoNotificacion tipoNotificacion) {
        this.tipoNotificacion = tipoNotificacion;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    //METODOS
    
    public TipoNotificacion guardarNotificacion(int idTipoNotificacion){
        
        try {
            
            tipoNotificacion = tipoNotificacionFacadeLocal.find(idTipoNotificacion);          
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tipoNotificacion;
        
    }
    
    
}
