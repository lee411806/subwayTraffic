package org.zerock.b03.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b03.domain.Subway;

import java.util.Optional;


@SpringBootTest
public class SubwayRepositoryTests {

    private static final Logger log = LogManager.getLogger(SubwayRepositoryTests.class);
    @Autowired
    private SubwayRepository subwayRepository;

    @Test
    public void testInsert(){
        Subway subway = Subway.builder()
                .LINE_NUM("분당선")
                .SUB_STA_NM("태평역")
                .USE_MON("3월")
                .build();

        Subway result = subwayRepository.save(subway);

    }

    @Test
    public void testSelect(){

        String LINE_NUM = "분당선";

        Optional<Subway> result = subwayRepository.findById(LINE_NUM);

        Subway subway = result.orElseThrow();
        log.info(subway.toString());
    }




}
