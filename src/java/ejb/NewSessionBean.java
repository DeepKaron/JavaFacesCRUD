/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entities.TblUser;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Admin
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext(unitName = "facesDemoNewPU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void submitBean(String username, String password){
        TblUser u = new TblUser();
        u.setUsername(username);
        u.setPassword(password);
        em.persist(u);
    }

    @Override
    public Collection<TblUser> viewUser() {
        return em.createNamedQuery("TblUser.findAll").getResultList();
    }

    @Override
    public void deleteUser(Integer userId) {
        TblUser u = em.find(TblUser.class, userId);
        em.remove(u);
    }

    @Override
    public void updateUser(Integer userId, String username, String password) {
        TblUser u = em.find(TblUser.class, userId);
        u.setUsername(username);
        u.setPassword(password);
        em.merge(u);
    }
    
}
