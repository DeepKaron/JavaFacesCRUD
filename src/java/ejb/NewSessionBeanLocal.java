/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entities.TblUser;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Admin
 */
@Local
public interface NewSessionBeanLocal {
    public void submitBean(String username, String password);
    Collection <TblUser> viewUser();
    public void deleteUser(Integer userId);
    public void updateUser(Integer userId, String username, String password);
}
