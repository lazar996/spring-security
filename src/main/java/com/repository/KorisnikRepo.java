package com.repository;

import com.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KorisnikRepo extends JpaRepository<Korisnik, Long> {

    public List<Korisnik> findAll();
    public Korisnik findByKorisnickoIme(String korisnicko_ime);
    public Korisnik findByTipKorisnika (String tipKorisnika);

}
