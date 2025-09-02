
//take fields user in userr pojo class
//name ,first name, last name, email, phone number,age
//provide regex for all fields ans save inside json file
//now create a login pojo class with username and password msure use abstraction and oops 



public class Login {
    private String username;
    private String password;

    
    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

   
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


public static void main(String[] args) {
    Login login = new Login("user123", "pass456");
    System.out.println("Username: " + login.getUsername());
    System.out.println("Password: " + login.getPassword());
}