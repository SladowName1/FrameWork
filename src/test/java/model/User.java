package model;

import java.util.Objects;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;

    public User(String firstName, String lastName, String email, String login,
                String password) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.login=login;
        this.password=password;
    }

    public static User getUser(String firstName, String lastName, String email, String login,
                               String password){
        return new User(firstName, lastName, email, login,password);
    }

    public String getFirstName() {return  firstName;}

    public String setFirstName(String firstName) {return this.firstName=firstName;}

    public String getLastName() {return  lastName;}

    public String setLastName(String lastName) {return  this.lastName=lastName;}

    public String getEmail() {return email;}

    public String setEmail(String email) {return this.email=email;}

    public String getLogin() {return login;}

    public String setLogin(String login) {return this.login=login;}

    public String getPassword() {return password;}

    public String setPassword(String password) {return this.password=password;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getLogin(), user.login) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword());
    }

}
