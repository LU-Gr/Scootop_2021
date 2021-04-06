package com.projet.scootop.scootop.repository.statistical;

import com.projet.scootop.scootop.domain.stastistical.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action,Long> {

}
