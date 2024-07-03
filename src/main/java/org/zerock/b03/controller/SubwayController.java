package org.zerock.b03.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.b03.service.SubwayService;

@Controller
@Log4j2
@RequiredArgsConstructor  //final 필드 생성자 자동 생성
public class SubwayController {

    private  final SubwayService subwayService;


    @GetMapping("/list")
    public void list(Model model) {


    }


}
