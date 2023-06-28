package com.jb.project2.dailyJob;

import com.jb.project2.service.CompanyServiceImpl;
import com.jb.project2.utills.Art;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import java.time.LocalDate;


@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class DailyJobThread {

    private final CompanyServiceImpl companiesImpl;
    private int count = 12345678;
    private final int halfMinute = 30_000;
    private final String cronExpression = "0 0 0 * * ?";


    @Async
    @Scheduled(fixedRate = halfMinute) // Run every 30 seconds
//    @Scheduled(cron = cronExpression) // Run at 00:00 every day
    public void deleteCoupons() throws InterruptedException {
        if (count == 12345678) {
            int twentySeconds = 20_000;
            Thread.sleep(twentySeconds);
            count++;
        }
        Art.DailyCheckForExpiredCoupons();
        LocalDate now = LocalDate.now();
        companiesImpl.deleteCouponByDate(now);
    }
}

