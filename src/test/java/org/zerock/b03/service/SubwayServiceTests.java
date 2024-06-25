package org.zerock.b03.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b03.dto.SubwayDTO;


@SpringBootTest
public class SubwayServiceTests {

    @Autowired
    private SubwayService subwayService;

    @Test
    public void testRegister() {

        log.info(subwayService.getClass().getName());

        SubwayDTO subwayDTO = subwayDTO.builder()
                .title("Sample Title...")
                .content("Sample Content...")
                .writer("user00")
                .build();

        String Line_NUM = subwayService.register(subwayDTO);

        log.info("호선 명 " + Line_NUM);
    }


}
