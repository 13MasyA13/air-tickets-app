package ua.khai.golik.entities;

public class User {

    // Default constructor

    public User(){

    }

    // Initial constructor

    public User(int id, String login, String password, String first_name, String last_name,
                String first_phone_number, String second_phone_number, String birthDate, String email){
        this.id = id;
        this.login = login;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.first_phone_number = first_phone_number;
        this.second_phone_number = second_phone_number;
        this.birthDate = birthDate;
        this.email = email;
    }

    // Class's fields

    private int id;
    private String login;
    private String password;
    private String first_name;
    private String last_name;
    private String first_phone_number;
    private String second_phone_number;
    private String email;
    private String birthDate;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_phone_number() {
        return first_phone_number;
    }

    public void setFirst_phone_number(String first_phone_number) {
        this.first_phone_number = first_phone_number;
    }

    public String getSecond_phone_number() {
        return second_phone_number;
    }

    public void setSecond_phone_number(String second_phone_number) {
        this.second_phone_number = second_phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
