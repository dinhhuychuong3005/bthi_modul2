package model;

public class Phonebook {
    private String name;
    private String numberPhone;
    private String gender;
    private String address;
    private String email;
    private String group;
    private String dateOfBirth;

    public Phonebook(String name, String numberPhone, String gender, String address, String email, String group, String dateOfBirth) {

        this.name = name;
        this.numberPhone = numberPhone;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.group = group;
        this.dateOfBirth = dateOfBirth;
    }

    public Phonebook() {
    }

    public String getGroup() {
        return group;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "," +
                numberPhone + "," +
                gender + "," +
                address + "," +
                email + "," +
                group + ","
                + dateOfBirth;
    }

    public String toString1() {
        return
                "name='" + name + '\'' +
                        ", numberPhone='" + numberPhone + '\'' +
                        ", gender='" + gender + '\'' +
                        ", address='" + address + '\'' +
                        ", email='" + email + '\'' +
                        ", group='" + group + '\'' +
                        '}';
    }
}
