/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malak_220226982fx;

/**
 *
 * @author NEW
 */
public class User {
    
    private String username;
    private String password;
    private String name;
    private String gender;
    private String birthdate;

    public User() {
    }

  /*  public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    */

    public User(String name) {
        this.name = name;
    }
    
    public User(String username, String password, String name, String gender, String birthdate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
     
    
}

