package com.services;

import com.model.Korisnik;
import com.repository.KorisnikRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {

    @Autowired
    KorisnikRepo korisnikRepo;


    public List<Korisnik> getAll() {return korisnikRepo.findAll();}

}
