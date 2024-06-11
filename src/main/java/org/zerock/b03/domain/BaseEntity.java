package org.zerock.b03.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//엔티티가 데이터 베이스에 추가되거나 변경될 때 자동으로 시간 값을 지정할 수 있다.
@EntityListeners(value = { AuditingEntityListener.class })
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    private int FOUR_RIDE_NUM;
    private int FOUR_ALIGHT_NUM;
    private int FIVE_RIDE_NUM;
    private int FIVE_ALIGHT_NUM;
    private int SIX_RIDE_NUM;
    private int SIX_ALIGHT_NUM;
    private int SEVEN_RIDE_NUM;
    private int SEVEN_ALIGHT_NUM;
    private int EIGHT_RIDE_NUM;
    private int EIGHT_ALIGHT_NUM;
    private int NINE_RIDE_NUM;
    private int NINE_ALIGHT_NUM;
    private int TEN_RIDE_NUM;
    private int TEN_ALIGHT_NUM;
    private int ELEVEN_RIDE_NUM;
    private int ELEVEN_ALIGHT_NUM;
    private int TWELVE_RIDE_NUM;
    private int TWELVE_ALIGHT_NUM;
    private int THIRTEEN_RIDE_NUM;
    private int THIRTEEN_ALIGHT_NUM;
    private int FOURTEEN_RIDE_NUM;
    private int FOURTEEN_ALIGHT_NUM;
    private int FIFTEEN_RIDE_NUM;
    private int FIFTEEN_ALIGHT_NUM;
    private int SIXTEEN_RIDE_NUM;
    private int SIXTEEN_ALIGHT_NUM;
    private int SEVENTEEN_RIDE_NUM;
    private int SEVENTEEN_ALIGHT_NUM;
    private int EIGHTEEN_RIDE_NUM;
    private int EIGHTEEN_ALIGHT_NUM;
    private int NINETEEN_RIDE_NUM;
    private int NINETEEN_ALIGHT_NUM;
    private int TWENTY_RIDE_NUM;
    private int TWENTY_ALIGHT_NUM;
    private int TWENTY_ONE_RIDE_NUM;
    private int TWENTY_ONE_ALIGHT_NUM;
    private int TWENTY_TWO_RIDE_NUM;
    private int TWENTY_TWO_ALIGHT_NUM;
    private int TWENTY_THREE_RIDE_NUM;
    private int TWENTY_THREE_ALIGHT_NUM;
    private int MIDNIGHT_RIDE_NUM;
    private int MIDNIGHT_ALIGHT_NUM;
    private int ONE_RIDE_NUM;
    private int ONE_ALIGHT_NUM;
    private int TWO_RIDE_NUM;
    private int TWO_ALIGHT_NUM;
    private int THREE_RIDE_NUM;
    private int THREE_ALIGHT_NUM;
    private String WORK_DT;


}
