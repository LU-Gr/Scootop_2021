package com.projet.scootop.scootop.repository.domainuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Player;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
    //@Modifying
    //@Query("UPDATE Player  SET evaluation = :evaluation,birthday = :birthday,taille = :taille, poids = :poids,vma = :vma,nationalite = :nationalite,origin = :origin,interaction = :interaction WHERE id = :id")
    //int updatePlayer(@Param("evaluation") int evaluation, @Param("birthday") LocalDate birthday, @Param("taille") int taille, @Param("poids") int poids, @Param("vma") int vma, @Param("nationalite") String nationalite, @Param("origin") String origin, @Param("interaction") int interaction, @Param("id") Integer id);

    List<Player> findAllPlayerByMatchSheetsAndTeamsIn(Long gameSheet, List<Team> teams);
}
