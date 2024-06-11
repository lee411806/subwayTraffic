package org.zerock.b03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// BaseEntity에 있는 AuditingEntityListener 활성화
@EnableJpaAuditing
@SpringBootApplication
public class B03Application {

    public static void main(String[] args) {
        SpringApplication.run(B03Application.class, args);
    }

}
