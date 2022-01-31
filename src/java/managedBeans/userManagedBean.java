/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package managedBeans;

import ejb.NewSessionBeanLocal;
import entities.TblUser;
import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Admin
 */
@ManagedBean(name = "userManagedBean")
@SessionScoped
@Dependent
public class userManagedBean {
@EJB NewSessionBeanLocal bl;
    String username;
    String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public void submitMB(){
//        System.out.println(username);
//        System.out.println(password);
        this.bl.submitBean(username, password);
    }
    
    public Collection<TblUser> viewUsers(){
        return this.bl.viewUser();
    }
    
    public void deleteUser(Integer userId){
        this.bl.deleteUser(userId);
    }
    
    public void updateUser(Integer userId, String username, String password){
        this.bl.updateUser(userId, username, password);
    }
    public userManagedBean() {
    }
    
}
