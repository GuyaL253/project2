package com.jb.project2.dailyJob;

import com.jb.project2.service.CompanyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.Date;


import java.time.LocalDate;

import java.time.LocalDate;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class DailyJobThread {

    private final CompanyServiceImpl companiesImpl;

    @Async
    @Scheduled(cron = "0 0 0 * * ?") // Run at 00:00 every day
    public void deleteCoupons() {
        LocalDate now = LocalDate.now();
        companiesImpl.deleteCouponByDate(now);
    }
}

