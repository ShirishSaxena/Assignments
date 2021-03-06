package com.AddressBook.Model;

public class AddressBookEntry {
    private String firstName, lastName, address, email, phoneNo;

    public AddressBookEntry(String line) {
        String[] l = line.split("\\| ");
        if(l.length == 5){
            this.firstName = l[0].trim();
            this.lastName = l[1].trim();
            this.address = l[2].trim();
            this.email = l[3].trim();
            this.phoneNo = l[4].trim();
        }
    }

    public boolean setAll(String line){
        String[] l = line.split("\\| ");
        if(l.length == 5){
            this.firstName = l[0].trim();
            this.lastName = l[1].trim();
            this.address = l[2].trim();
            this.email = l[3].trim();
            this.phoneNo = l[4].trim();

            return true;
        }

        return false;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString(){
        return firstName + " | " + lastName + " | " + address + " | " + email + " | " + phoneNo;
    }
}
