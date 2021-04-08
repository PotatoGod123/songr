package com.potatogod123.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class MasterController {
//    static ArrayList<Album> albumsHolder = new ArrayList<>();
//    static {
//        albumsHolder.add(new Album("TestingTitle","TestingArtist",34,40003,"https://images.pexels.com/photos/1544947/pexels-photo-1544947.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"));
//
//        albumsHolder.add(new Album("Daft Punk","Daft Punk",344,33333333,"https://images-na.ssl-images-amazon.com/images/I/61Uxg-SWExL._SL1500_.jpg"));
//        albumsHolder.add(new Album("Bounce Into The Music","SIAMÉS",10,3004,"https://e.snmc.io/i/600/w/701a4ba7217acdb1bdc82bda8a1da654/7197424/siames-bounce-into-the-music-Cover-Art.jpg"));
//
//    }

    //===== JPA STUff

    @Autowired
    public AlbumRepository albumRepository;
    //this is an interface, an instance of JPARepository manager that implements AlbumRepository
    //============

    @GetMapping("/hello")
    public String helloWorld(){

        return "hello-world.html";
    }

    @GetMapping("/capitalize/{upper}")
    public String capitalizePath(Model m, @PathVariable String upper){
        m.addAttribute("upperString",upper.toUpperCase(Locale.ROOT));
        return "capitalized.html";
    }

    @GetMapping("/albums")
    public String albumsPath(Model m){
            List<Album> albums = albumRepository.findAll();

            m.addAttribute("albumsAttribute",albums);

        return "albums.html";
    }

    @GetMapping("/albums/addAlbum")
    public String addAlbum(Model m){
            List<Album> albums = albumRepository.findAll();
            m.addAttribute("albumsAttribute",albums);

        return "albumForm.html";
    }

    @GetMapping("/")
    public String spalsh(){
        //we can retrieve from the database
        return "splash.html";
    }

    @PostMapping("/albums/saveAlbum")
    public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl){
        Album newAlbum = new Album(title,artist,songCount,length,imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }

    @DeleteMapping("/albums/{id}")
    public RedirectView deleteCookieStore(@PathVariable long id){
        albumRepository.deleteById(id);
        return new RedirectView("/albums");
    }



}
