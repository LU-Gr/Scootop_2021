package com.projet.scootop.repository.tools;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.tools.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {

	List<Team> findTeamByClubId(Long clubId);
}