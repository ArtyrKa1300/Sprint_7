package example;


// Cоздать класс Courier. Его полями будут ключи из JSON — login, password и firstName.
public class Courier {

    private String login; // ключ login стал полем типа String
    private String password; // ключ password стал полем типа String
    private String firstName; // ключ firstName стал полем типа String


    // Конструктор со всеми параметрами
    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    // Конструктор без параметров
    public Courier() { // для библиотеки, которая поможет превратить объект в JSON
    }

    // К каждому полю написать геттеры и сеттеры, они обеспечивают доступ к полям класса (Геттеры позволяют получать значения, сеттеры — изменять их)

    // геттер для поля login
    public String getLogin() {
        return login;
    }

    // сеттер для поля login
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}