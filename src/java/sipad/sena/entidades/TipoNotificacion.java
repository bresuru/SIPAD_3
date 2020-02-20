/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "tipo_notificacion")
@NamedQueries({
    @NamedQuery(name = "TipoNotificacion.findAll", query = "SELECT t FROM TipoNotificacion t")
    , @NamedQuery(name = "TipoNotificacion.findByIdTipoNotificaion", query = "SELECT t FROM TipoNotificacion t WHERE t.idTipoNotificaion = :idTipoNotificaion")
    , @NamedQuery(name = "TipoNotificacion.findByTipoEntrenamiento", query = "SELECT t FROM TipoNotificacion t WHERE t.tipoEntrenamiento = :tipoEntrenamiento")
    , @NamedQuery(name = "TipoNotificacion.findByColorNotificacion", query = "SELECT t FROM TipoNotificacion t WHERE t.colorNotificacion = :colorNotificacion")})
public class TipoNotificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoNotificaion")
    private Integer idTipoNotificaion;
    @Column(name = "tipo_entrenamiento")
    private String tipoEntrenamiento;
    @Column(name = "color_notificacion")
    private String colorNotificacion;
    @OneToMany(mappedBy = "idTipoNotificacion", fetch = FetchType.LAZY)
    private List<Notificacion> notificacionList;

    public TipoNotificacion() {
    }

    public TipoNotificacion(Integer idTipoNotificaion) {
        this.idTipoNotificaion = idTipoNotificaion;
    }

    public Integer getIdTipoNotificaion() {
        return idTipoNotificaion;
    }

    public void setIdTipoNotificaion(Integer idTipoNotificaion) {
        this.idTipoNotificaion = idTipoNotificaion;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(String tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public String getColorNotificacion() {
        return colorNotificacion;
    }

    public void setColorNotificacion(String colorNotificacion) {
        this.colorNotificacion = colorNotificacion;
    }

    public List<Notificacion> getNotificacionList() {
        return notificacionList;
    }

    public void setNotificacionList(List<Notificacion> notificacionList) {
        this.notificacionList = notificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoNotificaion != null ? idTipoNotificaion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoNotificacion)) {
            return false;
        }
        TipoNotificacion other = (TipoNotificacion) object;
        if ((this.idTipoNotificaion == null && other.idTipoNotificaion != null) || (this.idTipoNotificaion != null && !this.idTipoNotificaion.equals(other.idTipoNotificaion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.TipoNotificacion[ idTipoNotificaion=" + idTipoNotificaion + " ]";
    }
    
}
