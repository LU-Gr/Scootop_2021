package com.projet.scootop.scootop.repository.services.interaction;

import com.projet.scootop.scootop.domain.services.interaction.Invite;
import com.projet.scootop.scootop.model.services.interaction.InviteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InviteRepository extends JpaRepository<Invite,Integer> {
    @Modifying
    @Query("UPDATE Invite  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateInvite(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
