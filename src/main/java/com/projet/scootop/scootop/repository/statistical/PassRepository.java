package com.projet.scootop.scootop.repository.statistical;

import com.projet.scootop.scootop.domain.stastistical.Pass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassRepository extends JpaRepository<Pass,Long> {

}
