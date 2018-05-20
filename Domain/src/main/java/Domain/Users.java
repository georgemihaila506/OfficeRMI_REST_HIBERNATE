package Domain;

import java.io.Serializable;

public class Users implements Serializable {
    private int UId;
    private String username;
    private String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users()
    {

    }
    public int getUId()
    {
        return UId;
    }
    public void setUId(int UId)
    {
        this.UId=UId;
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
