package org.zerock.b03.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b03.domain.Subway;
import org.zerock.b03.domain.SubwayId;


public interface SubwayRepository extends JpaRepository<Subway, SubwayId> {

}
