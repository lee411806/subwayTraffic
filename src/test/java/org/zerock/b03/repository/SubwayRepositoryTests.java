package org.zerock.b03.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
                .SUB_STA_NM("선릉")
                .USE_MON("3월")
                .build();

        Subway result = subwayRepository.save(subway);

    }

    @Test
    public void testSelect(){

        String LINE_NUM = "가천대";

        Optional<Subway> result = subwayRepository.findById(LINE_NUM);

        Subway subway = result.orElseThrow();
        log.info(subway.toString());
    }


    //직접 바꿔주는 것도 가능
    @Test
    public void testUpdate(){
        String LINE_NUM = "가천대";

        Optional<Subway> result = subwayRepository.findById(LINE_NUM);

        Subway subway = result.orElseThrow();

        subway.change("202406");

        subwayRepository.save(subway);
    }

    @Test
    public void testDelete(){
        String LINE_NUM = "가천대";

        subwayRepository.deleteById(LINE_NUM);
    }


    @Test
    public void testPaging(){
        Pageable pageable =  PageRequest.of(0,10);
        Page<Subway> result = subwayRepository.findAll(pageable);
        log.info(result.toString());
        log.info("total count: "+result.getTotalElements());
        log.info("total page: "+result.getTotalPages());
    }
}
