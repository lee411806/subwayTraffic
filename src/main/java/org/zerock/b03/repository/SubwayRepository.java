package org.zerock.b03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.b03.domain.Subway;


@Repository
public interface SubwayRepository extends JpaRepository<Subway, String> {

}
