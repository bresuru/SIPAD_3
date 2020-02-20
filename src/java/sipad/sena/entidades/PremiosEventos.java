/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author APRENDIZ
 */
@Entity
@Table(name = "premios_eventos")
@NamedQueries({
    @NamedQuery(name = "PremiosEventos.findAll", query = "SELECT p FROM PremiosEventos p")
    , @NamedQuery(name = "PremiosEventos.findByIdPremio", query = "SELECT p FROM PremiosEventos p WHERE p.idPremio = :idPremio")
    , @NamedQuery(name = "PremiosEventos.findByFotoPremio", query = "SELECT p FROM PremiosEventos p WHERE p.fotoPremio = :fotoPremio")})
public class PremiosEventos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPremio")
    private Integer idPremio;
    @Column(name = "foto_premio")
    private String fotoPremio;
    @JoinColumn(name = "id_evento", referencedColumnName = "id_evento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Evento idEvento;

    public PremiosEventos() {
    }

    public PremiosEventos(Integer idPremio) {
        this.idPremio = idPremio;
    }

    public Integer getIdPremio() {
        return idPremio;
    }

    public void setIdPremio(Integer idPremio) {
        this.idPremio = idPremio;
    }

    public String getFotoPremio() {
        return fotoPremio;
    }

    public void setFotoPremio(String fotoPremio) {
        this.fotoPremio = fotoPremio;
    }

    public Evento getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Evento idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPremio != null ? idPremio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PremiosEventos)) {
            return false;
        }
        PremiosEventos other = (PremiosEventos) object;
        if ((this.idPremio == null && other.idPremio != null) || (this.idPremio != null && !this.idPremio.equals(other.idPremio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sipad.sena.entidades.PremiosEventos[ idPremio=" + idPremio + " ]";
    }
    
}
