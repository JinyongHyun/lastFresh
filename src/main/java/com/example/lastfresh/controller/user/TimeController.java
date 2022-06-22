package com.example.lastfresh.controller.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@Slf4j
public class TimeController {

    @GetMapping("/time")
    @ResponseBody
    public String getReviewDate(String reviewDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date today = new Date();

        Date rDate = sdf.parse(reviewDate);

        Calendar rCalendar = Calendar.getInstance();

        rCalendar.setTime(rDate);

        log.info("리뷰 시간 컨트롤러--------------------------" +reviewDate);

        log.info("리뷰 시간 컨트롤러 알데이트 확인------------------"+ rDate);

        long gap = today.getTime() - rDate.getTime();

        int h = rCalendar.get(Calendar.HOUR_OF_DAY);
        int mm = rCalendar.get(Calendar.MINUTE);
        int s = rCalendar.get(Calendar.SECOND);

        int y = rCalendar.get(Calendar.YEAR);
        int m = rCalendar.get(Calendar.MONTH) + 1;
        int d = rCalendar.get(Calendar.DATE);

        String time = null;
        if(gap < 1000 * 60 * 60 * 24){ //시 분 초
//            1의 자리 수는 앞에 0을 붙인다.
            time = (h < 10 ? "0" : "") + h + ":" + (mm < 10 ? "0" : "") + mm + ":" + (s < 10 ? "0" : "") + s;
        }else{ //년 월 일
//            1의 자리 수는 앞에 0을 붙인다.
            time = y + "-" + (m < 10 ? "0" : "") + m + "-" + (d < 10 ? "0" : "") + d;
        }
        return time;
    }
}
