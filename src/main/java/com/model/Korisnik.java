package com.model;


import javax.persistence.*;

@Entity
@Table(name ="korisnik")
public class Korisnik {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jmbg;

    @Column(name = "tip_korisnika")
    private String tipKorisnika;

    @Column(name="korisnicko_ime")
    private String korisnickoIme;

    @Column
    private String lozinka;


    @Column
    private String firstName;

    @Column
    private  String lastName;

    public Korisnik() {
    }

    public Korisnik(Long jmbg, String tipKorisnika, String korisnickoIme, String lozinka, String firstName, String lastName) {
        this.jmbg = jmbg;
        this.tipKorisnika = tipKorisnika;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getJmbg() {
        return jmbg;
    }

    public void setJmbg(Long jmbg) {
        this.jmbg = jmbg;
    }

    public String getTipKorisnika() {
        return tipKorisnika;
    }

    public void setTipKorisnika(String tipKorisnika) {
        this.tipKorisnika = tipKorisnika;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    @Override
    public String toString() {
        return "Korisnik{" +
                "jmbg=" + jmbg +
                ", tipKorisnika='" + tipKorisnika + '\'' +
                ", korisnickoIme='" + korisnickoIme + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
