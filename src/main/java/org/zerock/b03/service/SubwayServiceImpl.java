package org.zerock.b03.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b03.domain.Subway;
import org.zerock.b03.dto.SubwayDTO;
import org.zerock.b03.repository.SubwayRepository;


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

}