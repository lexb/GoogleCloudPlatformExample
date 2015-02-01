package com.example.tobolkac.googlecloudplatformexample.backend;

import com.googlecode.objectify.annotation.Entity;

/**
 * Created by clayt on 2/1/15.
 */
@Entity
public class UserRecord
{
    private String username;
    private String password;
    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
