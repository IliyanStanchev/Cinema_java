package models;

import javax.persistence.*;

@Entity
public class User
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String loginUsername;

    private String loginPassword;

    private String name;

    private String email;

    @Column(unique = true)
    private String phoneNumber;


    public User()
    {

    }

    public User(String loginUsername, String loginPassword, String name, String email, String phoneNumber)
    {

        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public String getEmail()
    {
        return email;
    }

    public int getId()
    {
        return id;
    }

    public String getLoginPassword()
    {
        return loginPassword;
    }

    public String getLoginUsername()
    {
        return loginUsername;
    }

    public String getName()
    {
        return name;
    }


    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public void setLoginPassword(String loginPassword)
    {
        this.loginPassword = loginPassword;
    }

    public void setLoginUsername(String loginUsername)
    {
        this.loginUsername = loginUsername;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }


}