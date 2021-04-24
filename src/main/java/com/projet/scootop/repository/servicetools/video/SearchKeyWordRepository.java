package com.projet.scootop.repository.servicetools.video;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.servicetools.video.SearchKeyWord;

@Repository
public interface SearchKeyWordRepository extends JpaRepository<SearchKeyWord, Long> {

}
