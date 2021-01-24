package CodeCadame;

// User is made so there is a acces to the user name and pasword
public class User {
    private String name;
    private String pasword;

    public User(String name, String pasword){
        this.name = name;
        this.pasword = pasword;
    }

    // get the user name
    public String getName(){
        return this.name;
    }

    // set the user name
    public void changeName(String name){
        this.name = name;
    }

    // get the user pasword
    public String getPasword(){
        return this.pasword;
    }

    // set the user pasword
    public void changePasword(String pasword){
        this.pasword = pasword;
    }
}
