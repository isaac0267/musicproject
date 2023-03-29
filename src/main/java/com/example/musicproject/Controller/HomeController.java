package com.example.musicproject.Controller;

import com.example.musicproject.ModeModel.Artist;
import org.springframework.ui.Model;
import com.example.musicproject.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ArtistService artistService;

    @GetMapping("/")
    public String index(Model model) {
        List<Artist> artistList = artistService.fetchAll();
        model.addAttribute("artists", artistList);
        return "home/index";
    }

    // This method will put the new user in the MySQL.We use the @GetMapping
    @GetMapping("create")
    public String create() {
        return "home/create";
    }

    // PostMapping is used for making the creatNew.
    @PostMapping("/createNew")
    public String createNew(@ModelAttribute Artist artist) {
        artistService.addArtist(artist);
        return "redirect:/";
    }

    // that method that will print the artist to the browser.
    @GetMapping("/viewOne/{id}")
    public String viewOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("artist", artistService.findArtistID(id));
        return "home/viewOne";

    }

    // The button that will delete the artist.
    @GetMapping("/delet/{id}")
    public String deletOne(@PathVariable("id") int id) {
        boolean deletede = artistService.deletePerson(id);
        if (deletede) {
            return "redirect:/";
        } else {
            return "redirect:/";
        }

    }

    // The method that will update artist.
    @GetMapping("/updateOne/{id}")
    public String updateOne(@PathVariable("id") int id, Model model) {
        model.addAttribute("artist", artistService.findArtistID(id));
        return "home/updateOne";
    }
   @PostMapping("/updateArtist")
    public String updateArtist(@ModelAttribute Artist artist) {
   artistService.updatePerson(artist.getId(),artist);
      return"redirect:/";
   }

}
