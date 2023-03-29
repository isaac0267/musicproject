package com.example.musicproject.service;

import com.example.musicproject.ModeModel.Artist;
import com.example.musicproject.Repository.ArtistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    ArtistRepo artistRepo;

    public List<Artist> fetchAll() {
        return artistRepo.fetchAll();
    }

    public void addArtist(Artist A) {
        artistRepo.addArtist(A);

    }

    public Artist findArtistID(int id) {
        return artistRepo.findePersonID(id);
    }
   public Boolean deletePerson(int id) {
     return artistRepo.delePerson(id);
   }
   public void updatePerson(int id,Artist A) {
    artistRepo.updateArtist(id,A);
   }
}
