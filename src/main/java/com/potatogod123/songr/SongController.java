package com.potatogod123.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;

    @PostMapping("/albums/addSong")
    public RedirectView addSongToAlbum(String title, int lengths, int trackNumber, long id){
        Album album = albumRepository.getOne(id);
        Song song = new Song(title,lengths,trackNumber,album);

        songRepository.save(song);
        return new RedirectView("/albums");

    }

    @GetMapping("/albums/albumDetails")
    public String albumDetails(long id, Model m){
        Album album = albumRepository.getOne(id);

        m.addAttribute("album", album);

        return "albumDetails.html";
    }
}
