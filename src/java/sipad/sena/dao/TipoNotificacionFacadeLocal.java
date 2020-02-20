/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.TipoNotificacion;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface TipoNotificacionFacadeLocal {

    void create(TipoNotificacion tipoNotificacion);

    void edit(TipoNotificacion tipoNotificacion);

    void remove(TipoNotificacion tipoNotificacion);

    TipoNotificacion find(Object id);

    List<TipoNotificacion> findAll();

    List<TipoNotificacion> findRange(int[] range);

    int count();
    
}
