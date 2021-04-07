package com.potatogod123.songr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album,Long> {
    //this will load methods like save,update,delete,getone,getall
}
