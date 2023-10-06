package TallerPractico.Modelo;

public class Persona {
    private String user;
    private String password;
    public Persona(){
    }
    public Persona(String user, String password){
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;    }

    public String toString(){
        return user + "," + password + "\n";
    }

}
