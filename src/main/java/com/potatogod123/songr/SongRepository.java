package com.potatogod123.songr;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song,Long> {
}
