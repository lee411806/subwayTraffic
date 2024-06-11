package org.zerock.b03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

//복합키 만들어 줌
@Getter
@Setter
@NoArgsConstructor
public class SubwayId implements Serializable {

    private String LINE_NUM;
    private String USE_MON;
    private String SUB_STA_NM;


    // 필드를 모두 포함하는 생성자
    public SubwayId(String LINE_NUM, String USE_MON, String SUB_STA_NM) {
        this.LINE_NUM = LINE_NUM;
        this.USE_MON = USE_MON;
        this.SUB_STA_NM = SUB_STA_NM;
    }

    // equals와 hashCode 메서드 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubwayId subwayId = (SubwayId) o;
        return Objects.equals(LINE_NUM, subwayId.LINE_NUM) &&
                Objects.equals(USE_MON, subwayId.USE_MON) &&
                Objects.equals(SUB_STA_NM, subwayId.SUB_STA_NM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LINE_NUM, USE_MON, SUB_STA_NM);
    }

}
