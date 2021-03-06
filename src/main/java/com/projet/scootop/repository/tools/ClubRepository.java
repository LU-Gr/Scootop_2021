package com.projet.scootop.repository.tools;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.tools.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

	List<Club> findClubByCountry(String country);
}
