package com.projet.scootop.scootop.repository.servicetools.videosservices;

import com.projet.scootop.scootop.servicetools.videosservices.SearchKeyWord;
import com.projet.scootop.scootop.servicetools.videosservices.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SearchKeyWordRepository extends JpaRepository<SearchKeyWord, Integer> {
    @Modifying
    @Query("UPDATE SearchKeyWord  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateSearchKeyWord(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
