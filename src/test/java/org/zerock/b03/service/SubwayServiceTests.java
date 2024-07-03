package org.zerock.b03.service;



import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b03.dto.SubwayDTO;


@Log4j2
@SpringBootTest
public class SubwayServiceTests {

    @Autowired
    private SubwayService subwayService;

    @Test
    public void testRegister() {

        /*log.info(subwayService.getClass().getName());*/

        SubwayDTO subwayDTO = SubwayDTO.builder()
                .LINE_NUM("분당선")
                .SUB_STA_NM("선릉")
                .USE_MON("3월")
                .build();

        String Line_NUM = subwayService.register(subwayDTO);

       /* log.info("호선 명 " + Line_NUM);*/
    }



}
