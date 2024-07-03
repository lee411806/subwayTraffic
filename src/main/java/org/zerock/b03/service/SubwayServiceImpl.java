package org.zerock.b03.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b03.domain.Subway;
import org.zerock.b03.dto.PageRequestDTO;
import org.zerock.b03.dto.PageResponseDTO;
import org.zerock.b03.dto.SubwayDTO;
import org.zerock.b03.repository.SubwayRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class SubwayServiceImpl implements SubwayService{

    private final ModelMapper modelMapper;

    private final SubwayRepository subwayRepository;

    @Override
    public String register(SubwayDTO subwayDTO) {

        Subway subway = modelMapper.map(subwayDTO, Subway.class);

        String Line_NUM = subwayRepository.save(subway).getLINE_NUM();

        return Line_NUM;
    }

    @Override
    public SubwayDTO readOne(String SUB_STA_NM) {

        Optional<Subway> result = subwayRepository.findById(SUB_STA_NM);

        Subway subway = result.orElseThrow();

        SubwayDTO subwayDTO = modelMapper.map(subway, SubwayDTO.class);

        return subwayDTO;
    }

    @Override
    public void modify(SubwayDTO subwayDTO) {
        Optional<Subway> result = subwayRepository.findById(subwayDTO.getSUB_STA_NM());

        Subway subway = result.orElseThrow();

        subway.change(subwayDTO.getSUB_STA_NM());

        subwayRepository.save(subway);

    }

    @Override
    public void remove(String SUB_STA_NM) {
        subwayRepository.deleteById(SUB_STA_NM);
    }

  /*  @Override
    public PageResponseDTO<SubwayDTO> list(PageRequestDTO pageRequestDTO) {

        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");

        Page<Subway> result = subwayRepository.searchAll(types, keyword, pageable);

        List<SubwayDTO> dtoList = result.getContent().stream()
                .map(board -> modelMapper.map(board,SubwayDTO.class)).collect(Collectors.toList());


        return PageResponseDTO.<SubwayDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();

    }*/

}