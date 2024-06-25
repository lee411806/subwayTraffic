/*
package org.zerock.b03.config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImportJsonToMariaDB {

    public static void main(String[] args) {
        String jsonFilePath = "C:/Users/user/Desktop/b03/src/main/resources/subwayData.json";
        String jdbcUrl = "jdbc:mysql://localhost:3306/webdb";
        String jdbcUser = "webuser";
        String jdbcPassword = "webuser";

        try {
            // JSON 파일 읽기
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(jsonFilePath));
            JsonNode dataArray = root.path("DATA");

            // MariaDB 연결 설정
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

            String sql = "INSERT INTO subway (line_num, sub_sta_nm, use_mon, work_dt, eighteen_ride_num, seventeen_ride_num, " +
                    "eighteen_alight_num, ten_ride_num, twelve_alight_num, eight_alight_num, " +
                    "one_ride_num, nine_ride_num, fifteen_ride_num, twenty_ride_num, two_alight_num, " +
                    "fourteen_ride_num, twenty_three_ride_num, eleven_ride_num, thirteen_ride_num, " +
                    "twenty_one_alight_num, twenty_one_ride_num, fourteen_alight_num, seven_ride_num, " +
                    "eleven_alight_num, ten_alight_num, four_ride_num, midnight_alight_num, " +
                    "midnight_ride_num, sixteen_alight_num, twenty_two_ride_num, nineteen_alight_num, " +
                    "five_alight_num, six_alight_num, twenty_two_alight_num, five_ride_num, " +
                    "six_ride_num, nine_alight_num, four_alight_num, nineteen_ride_num, twenty_alight_num, " +
                    "one_alight_num, two_ride_num, thirteen_alight_num, twenty_three_alight_num, " +
                    "three_ride_num, eight_ride_num, three_alight_num, fifteen_alight_num, twelve_ride_num, " +
                    "seven_alight_num, sixteen_ride_num, seventeen_alight_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            // JSON 데이터 삽입
            for (JsonNode item : dataArray) {
                statement.setString(1, item.path("line_num").asText());
                statement.setString(2, item.path("sub_sta_nm").asText());
                statement.setString(3, item.path("use_mon").asText());
                statement.setString(4, item.path("work_dt").asText());
                statement.setInt(5, item.path("eighteen_ride_num").asInt());
                statement.setInt(6, item.path("seventeen_ride_num").asInt());
                statement.setInt(7, item.path("eighteen_alight_num").asInt());
                statement.setInt(8, item.path("ten_ride_num").asInt());
                statement.setInt(9, item.path("twelve_alight_num").asInt());
                statement.setInt(10, item.path("eight_alight_num").asInt());
                statement.setInt(11, item.path("one_ride_num").asInt());
                statement.setInt(12, item.path("nine_ride_num").asInt());
                statement.setInt(13, item.path("fifteen_ride_num").asInt());
                statement.setInt(14, item.path("twenty_ride_num").asInt());
                statement.setInt(15, item.path("two_alight_num").asInt());
                statement.setInt(16, item.path("fourteen_ride_num").asInt());
                statement.setInt(17, item.path("twenty_three_ride_num").asInt());
                statement.setInt(18, item.path("eleven_ride_num").asInt());
                statement.setInt(19, item.path("thirteen_ride_num").asInt());
                statement.setInt(20, item.path("twenty_one_alight_num").asInt());
                statement.setInt(21, item.path("twenty_one_ride_num").asInt());
                statement.setInt(22, item.path("fourteen_alight_num").asInt());
                statement.setInt(23, item.path("seven_ride_num").asInt());
                statement.setInt(24, item.path("eleven_alight_num").asInt());
                statement.setInt(25, item.path("ten_alight_num").asInt());
                statement.setInt(26, item.path("four_ride_num").asInt());
                statement.setInt(27, item.path("midnight_alight_num").asInt());
                statement.setInt(28, item.path("midnight_ride_num").asInt());
                statement.setInt(29, item.path("sixteen_alight_num").asInt());
                statement.setInt(30, item.path("twenty_two_ride_num").asInt());
                statement.setInt(31, item.path("nineteen_alight_num").asInt());
                statement.setInt(32, item.path("five_alight_num").asInt());
                statement.setInt(33, item.path("six_alight_num").asInt());
                statement.setInt(34, item.path("twenty_two_alight_num").asInt());
                statement.setInt(35, item.path("five_ride_num").asInt());
                statement.setInt(36, item.path("six_ride_num").asInt());
                statement.setInt(37, item.path("nine_alight_num").asInt());
                statement.setInt(38, item.path("four_alight_num").asInt());
                statement.setInt(39, item.path("nineteen_ride_num").asInt());
                statement.setInt(40, item.path("twenty_alight_num").asInt());
                statement.setInt(41, item.path("one_alight_num").asInt());
                statement.setInt(42, item.path("two_ride_num").asInt());
                statement.setInt(43, item.path("thirteen_alight_num").asInt());
                statement.setInt(44, item.path("twenty_three_alight_num").asInt());
                statement.setInt(45, item.path("three_ride_num").asInt());
                statement.setInt(46, item.path("eight_ride_num").asInt());
                statement.setInt(47, item.path("three_alight_num").asInt());
                statement.setInt(48, item.path("fifteen_alight_num").asInt());
                statement.setInt(49, item.path("twelve_ride_num").asInt());
                statement.setInt(50, item.path("seven_alight_num").asInt());
                statement.setInt(51, item.path("sixteen_ride_num").asInt());
                statement.setInt(52, item.path("seventeen_alight_num").asInt());

                statement.addBatch();
            }

            statement.executeBatch();

            // 연결 닫기
            connection.close();

            System.out.println("JSON 데이터를 MariaDB에 성공적으로 삽입했습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
