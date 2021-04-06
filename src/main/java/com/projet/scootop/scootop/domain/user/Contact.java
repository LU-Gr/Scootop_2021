package com.projet.scootop.scootop.domain.user;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String email;
    public String tel;
    public String address;
    public String cp;
    @OneToOne
    public User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact(String email, String tel, String address, String cp) {
        this.email = email;
        this.tel = tel;
        this.address = address;
        this.cp = cp;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", cp='" + cp + '\'' +
                ", user=" + user +
                '}';
    }
}
