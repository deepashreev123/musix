package com.stackroute.musixservice.repository;
import java.util.List;
import com.stackroute.musixservice.domain.Track;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.repository.CrudRepository;

import java.util.List;

    public interface TrackRepository extends MongoRepository<Track, Integer> {


     @Query(value = "select * from track where track_name=?1")
        public List<Track> getTrackByName(String trackName);
    }

