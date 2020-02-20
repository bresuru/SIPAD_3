/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipad.sena.dao;

import java.util.List;
import javax.ejb.Local;
import sipad.sena.entidades.PremiosEventos;

/**
 *
 * @author APRENDIZ
 */
@Local
public interface PremiosEventosFacadeLocal {

    void create(PremiosEventos premiosEventos);

    void edit(PremiosEventos premiosEventos);

    void remove(PremiosEventos premiosEventos);

    PremiosEventos find(Object id);

    List<PremiosEventos> findAll();

    List<PremiosEventos> findRange(int[] range);

    int count();
    
}
