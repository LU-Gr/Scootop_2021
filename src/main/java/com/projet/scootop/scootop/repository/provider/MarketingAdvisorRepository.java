package com.projet.scootop.scootop.repository.provider;

import com.projet.scootop.scootop.domain.provider.MarketingAdvisor;
import com.projet.scootop.scootop.model.domainconfiguration.CategoryDTO;
import com.projet.scootop.scootop.model.provider.MarketingAdvisorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingAdvisorRepository extends JpaRepository<MarketingAdvisor, Integer> {
    @Modifying
    @Query("UPDATE MarketingAdvisor  SET name = :name, firstName = :firstName WHERE id = :id")
    int updateMarketingAdvisor(@Param("name") String name, @Param("firstName") String firstName, @Param("id") Integer id);

}
