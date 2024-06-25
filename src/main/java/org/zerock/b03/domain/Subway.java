package org.zerock.b03.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder  //빌더 패턴 자동으로 생성
@AllArgsConstructor   //모든 필드를 포함하는 생성자를 자동으로 생성합니다.
@NoArgsConstructor // 기본 생성자 자동으로 생성
@ToString  // 어노테이션은 객체의 문자열 표현을 자동으로 생성합니다.
public class Subway extends BaseEntity {

    // JPA에서 엔티티의 기본키를 자동으로 생성하는 방식을 지정하는 어노테이션

    @Id
    private String SUB_STA_NM;

    @Column(nullable = false)
    private String LINE_NUM;

    @Column(nullable = false)
    private String USE_MON;


 public void change(String USE_MON){
     this.USE_MON = USE_MON;
 }


}
