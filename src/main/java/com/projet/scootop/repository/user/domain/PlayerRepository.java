package com.projet.scootop.repository.user.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projet.scootop.domain.configuration.Poste;
import com.projet.scootop.domain.tools.Team;
import com.projet.scootop.domain.user.domain.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    //@Modifying
    //@Query("UPDATE Player  SET evaluation = :evaluation,birthday = :birthday,taille = :taille, poids = :poids,vma = :vma,nationalite = :nationalite,origin = :origin,interaction = :interaction WHERE id = :id")
    //int updatePlayer(@Param("evaluation") int evaluation, @Param("birthday") LocalDate birthday, @Param("taille") int taille, @Param("poids") int poids, @Param("vma") int vma, @Param("nationalite") String nationalite, @Param("origin") String origin, @Param("interaction") int interaction, @Param("id") Integer id);

    //List<Player> findAllPlayerByMatchSheetsAndTeamsIn(Long gameSheet, List<Team> teams);
	
	//List<Player> findAll();
	
	@Query("SELECT id FROM player p WHERE ((:teams) is null or p.teams IN :teams)")
	List<Player> searchPlayers(@Param("teams") List<Team> teams/* ,@Param("postes")List<Poste> postes */);
	/* and (:postes is null or p.postes IN :postes)")*/
	
	@Query("SELECT * FROM player p WHERE p.firstName LIKE '%:firstname%' AND p.lastName LIKE '%lastname%'")
	Player searchPlayerByName(@Param("firstname") String firstname, @Param("lastname") String lastname);
}
