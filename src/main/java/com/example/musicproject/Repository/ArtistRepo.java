package com.example.musicproject.Repository;

import com.example.musicproject.ModeModel.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepo {
    @Autowired
    JdbcTemplate template;

    public List<Artist> fetchAll() {
        String sql = "SELECT * FROM artiset";
        RowMapper<Artist> rowMapper = new BeanPropertyRowMapper<>(Artist.class);
        return template.query(sql, rowMapper);
    }

    public void addArtist(Artist A) {
        String sql = "INSERT INTO artiset(id,first_name, last_name,tracks,year_of_publication, record_label)VALUES(?,?,?,?,?,?)";
        template.update(sql, A.getId(), A.getFirst_name(), A.getLast_name(), A.getTracks(), A.getYear_of_publication(), A.getRecord_label());
    }

    public Artist findePersonID(int id) {
        String sql = "SELECT * FROM artiset WHERE id=?";
        RowMapper<Artist> rowMapper = new BeanPropertyRowMapper<>(Artist.class);
        Artist artist = template.queryForObject(sql, rowMapper, id);
        return artist;
    }

    public Boolean delePerson(int id) {
        String sql = "DELETE FROM artiset WHERE id=?";
        return template.update(sql, id) > 0;
    }

    public void updateArtist(int id, Artist a) {
    String sql="UPDATE artiset SET first_name=?,last_name=?,tracks=?,year_of_publication=?,record_label=? WHERE id=?";
    template.update(sql,a.getFirst_name(),a.getLast_name(),a.getTracks(),a.getYear_of_publication(),a.getRecord_label(),a.getId());


    }
}
