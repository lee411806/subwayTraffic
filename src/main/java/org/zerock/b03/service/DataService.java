package org.zerock.b03.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.b03.domain.Subway;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    private ObjectMapper objectMapper;

    public List<Subway> parseApiData(String jsonData) throws Exception {
        JsonNode rootNode = objectMapper.readTree(jsonData);
        List<Subway> subways = new ArrayList<>();

        for (JsonNode node : rootNode.path("data")) {
            String lineNum = node.path("LINE_NUM").asText();
            String useMon = node.path("USE_MON").asText();
            String subStaNm = node.path("SUB_STA_NM").asText();
            String otherField = node.path("otherField").asText();

            Subway subway = new Subway();
            subway.setLineNum(lineNum);
            subway.setUseMon(useMon);
            subway.setSubStaNm(subStaNm);
            subway.setOtherField(otherField);
            subways.add(subway);
        }

        return subways;
    }
}