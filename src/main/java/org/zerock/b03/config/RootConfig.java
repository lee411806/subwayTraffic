package org.zerock.b03.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {

    @Bean
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)  //필드매칭 활성화
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                //필드 접근 수준을 PRIVATE로 설정하여, private 필드에도 접근할 수 있도록 합니다.
                .setMatchingStrategy(MatchingStrategies.STRICT);
        //설정이 완료된 ModelMapper 객체를 반환하여 스프링 컨텍스트에서 사용할 수 있도록 합니다.

        return modelMapper;
    }
}