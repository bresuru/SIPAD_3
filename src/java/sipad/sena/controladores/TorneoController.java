package sipad.sena.controladores;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import sipad.sena.entidades.*;
import sipad.sena.dao.*;

@Named
@RequestScoped
public class TorneoController {

    @EJB
    private TorneoFacadeLocal TFL;
    private Torneo torneo;

    @EJB
    private LugarTorneoFacadeLocal LTFL;
    private LugarTorneo lugarTorneo;
    private List<LugarTorneo> listaLugarTorneo;

    @EJB
    private SupervisorFacadeLocal SFL;
    private Supervisor superv;
    private List<Supervisor> listaSupervisor;

    @EJB
    private UsuarioFacadeLocal UFL;
    private Usuario user;

    @EJB
    private AlumnoHasTorneoFacadeLocal alumnoHasTorneoFacadeLocal;
    private AlumnoHasTorneo alumnoHasTorneo;

    @EJB
    private AlumnoFacadeLocal alumnoFacadeLocal;
    private Alumno alumno;

    @PostConstruct
    public void init() {
        torneo = new Torneo();
        lugarTorneo = new LugarTorneo();
        superv = new Supervisor();
        user = new Usuario();
        alumno = new Alumno();
        alumnoHasTorneo = new AlumnoHasTorneo();

        listaLugarTorneo = LTFL.findAll();
    }

    public TorneoController() {
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public LugarTorneo getLugarTorneo() {
        return lugarTorneo;
    }

    public void setLugarTorneo(LugarTorneo lugarTorneo) {
        this.lugarTorneo = lugarTorneo;
    }

    public List<LugarTorneo> getListaLugarTorneo() {
        return listaLugarTorneo;
    }

    public void setListaLugarTorneo(List<LugarTorneo> listaLugarTorneo) {
        this.listaLugarTorneo = listaLugarTorneo;
    }

    public Supervisor getSuperv() {
        return superv;
    }

    public void setSuperv(Supervisor superv) {
        this.superv = superv;
    }

    public List<Supervisor> getListaSupervisor() {
        return listaSupervisor;
    }

    public void setListaSupervisor(List<Supervisor> listaSupervisor) {
        this.listaSupervisor = listaSupervisor;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public AlumnoHasTorneo getAlumnoHasTorneo() {
        return alumnoHasTorneo;
    }

    public void setAlumnoHasTorneo(AlumnoHasTorneo alumnoHasTorneo) {
        this.alumnoHasTorneo = alumnoHasTorneo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    //Metodos:
    //Metodo para crear torneo 
    public void crearTorneo() {
        try {

            TFL.create(torneo);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Torneo creado con exito"));

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Huy!!!... ocurrio un error"));

        }
    }

    // Metodo para actualizar 
    public void actualizarTorneo() {

        try {

            TFL.edit(torneo);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso: ", "Torneo actualizado con exito"));

        } catch (Exception e) {

            e.printStackTrace();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Error al actualizar la informacion del torneo"));

        }

    }

    //Metodo para listar torneos
    public List<Torneo> listarTorneos() {

        List<Torneo> lista = null;

        try {

            lista = TFL.findAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public String consultarTorneo(int idTorneo) {

        try {
            torneo = TFL.find(idTorneo);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "AVISO: ", "Torneo encontrado"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error: ", "Error al buscar el torneo"));

        }

        return "modificarTorneo";

    }

    public void modificarTorneo() {
        try {
            superv = SFL.find(2);
            torneo.setIdLugarTorneo(lugarTorneo);
            torneo.setIdSupervisor(superv);

            TFL.edit(torneo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //consultar torneos del alumno
    public List<AlumnoHasTorneo> listaAlumnoT() {
        List<AlumnoHasTorneo> lista = null;

        try {

            lista = alumnoHasTorneoFacadeLocal.findAlumnoT(alumno.getIdAlumno());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    //Buscar torneo
    public String buscarTorneo(int idTorneo){
        
        String url = "";
        
        try {
            
            torneo = TFL.find(idTorneo);
            
            url = "/app/alumno/pages/torneo_al_info";
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return url;
        
    }
    
    //Consultar alumnos del torneo
    public List<Alumno> fontAlumnTorn(int id_torn){
        
        List<Alumno>  listaAlumn = null;
        
        try {
            
            listaAlumn = alumnoFacadeLocal.findAlumnTorn(id_torn);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listaAlumn;
        
    }

}
