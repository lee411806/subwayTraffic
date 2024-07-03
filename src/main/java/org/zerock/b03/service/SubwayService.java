package org.zerock.b03.service;

import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.zerock.b03.dto.PageRequestDTO;
import org.zerock.b03.dto.PageResponseDTO;
import org.zerock.b03.dto.SubwayDTO;


public interface SubwayService {

    String register(SubwayDTO subwayDTO);

    SubwayDTO readOne(String SUB_STA_NM);

    void modify(SubwayDTO subwayDTO);

    void remove(String SUB_STA_NM);

    /*PageResponseDTO<SubwayDTO> list(PageRequestDTO pageRequestDTO);*/
}
