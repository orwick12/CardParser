/*
Created by Brian Orwick
Date: 8/10/2018
ContactInfo is the blueprint for how contacts are currently created.
 */

public class ContactInfo {

    private String name;
    private String phoneNumber;
    private String email;

    public ContactInfo(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPhone: %s\nEmail: %s",
          getName(), getPhoneNumber(), getEmail());
    }
}
