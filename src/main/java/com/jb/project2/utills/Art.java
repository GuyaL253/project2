package com.jb.project2.utills;

import com.jb.project2.beans.Company;
import com.jb.project2.beans.Coupon;
import com.jb.project2.beans.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Art {
    private static int count = 1;

    public static void catchPrint(String message) {
        System.out.println("\u001B[31m" + message + "\u001B[0m");
    }


    public static void printCompanyDetails(Company company) {
        System.out.print("\u001B[36mCompany Details:\u001B[0m");
        System.out.print(" \u001B[34mCompany ID:\u001B[0m " + company.getCompanyId());
        System.out.print(" \u001B[34mName:\u001B[0m " + company.getName());
        System.out.print(" \u001B[34mEmail:\u001B[0m " + company.getEmail());
        System.out.println(" \u001B[34mPassword:\u001B[0m " + company.getPassword());
        System.out.println("\u001B[34mCoupons:\u001B[0m");
        for (Coupon coupon : company.getCoupons()) {
            System.out.print("  \u001B[33mCoupon ID:\u001B[0m " + coupon.getCouponId());
            System.out.print(" \u001B[33mTitle:\u001B[0m " + coupon.getTitle());
            System.out.print(" \u001B[33mDescription:\u001B[0m " + coupon.getDescription());
            System.out.print(" \u001B[33mStart Date:\u001B[0m " + coupon.getStartDate());
            System.out.print(" \u001B[33mEnd Date:\u001B[0m " + coupon.getEndDate());
            System.out.print(" \u001B[33mAmount:\u001B[0m " + coupon.getAmount());
            System.out.print(" \u001B[33mPrice:\u001B[0m " + coupon.getPrice());
            System.out.println(" \u001B[33mImage:\u001B[0m " + coupon.getImage());
        }
        System.out.println();
    }

    public static void printCustomerDetails(Customer customer) {
        System.out.print("\u001B[36mCustomer Details:\u001B[0m");
        System.out.print(" \u001B[34mCustomer ID:\u001B[0m " + customer.getCustomerId());
        System.out.print(" \u001B[34mFirst Name:\u001B[0m " + customer.getFirstName());
        System.out.print(" \u001B[34mLast Name:\u001B[0m " + customer.getLastName());
        System.out.print(" \u001B[34mEmail:\u001B[0m " + customer.getEmail());
        System.out.println(" \u001B[34mPassword:\u001B[0m " + customer.getPassword());
        System.out.println("\u001B[34mCoupons:\u001B[0m");
        for (Coupon coupon : customer.getCoupons()) {
            System.out.print("  \u001B[33mCoupon ID:\u001B[0m " + coupon.getCouponId());
            System.out.print(" \u001B[33mTitle:\u001B[0m " + coupon.getTitle());
            System.out.print(" \u001B[33mDescription:\u001B[0m " + coupon.getDescription());
            System.out.print(" \u001B[33mStart Date:\u001B[0m " + coupon.getStartDate());
            System.out.print(" \u001B[33mEnd Date:\u001B[0m " + coupon.getEndDate());
            System.out.print(" \u001B[33mAmount:\u001B[0m " + coupon.getAmount());
            System.out.print(" \u001B[33mPrice:\u001B[0m " + coupon.getPrice());
            System.out.println(" \u001B[33mImage:\u001B[0m " + coupon.getImage());
        }
        System.out.println();
    }

    public static void printCouponDetails(Coupon coupon) {
        System.out.print("\u001B[36mCoupon Details:\u001B[0m");
        System.out.print(" \u001B[33mCoupon ID:\u001B[0m " + coupon.getCouponId());
        System.out.print(" \u001B[33mCompany ID:\u001B[0m " + coupon.getCompanyId());
        System.out.print(" \u001B[33mCategory:\u001B[0m " + coupon.getCategory());
        System.out.print(" \u001B[33mTitle:\u001B[0m " + coupon.getTitle());
        System.out.print(" \u001B[33mDescription:\u001B[0m " + coupon.getDescription());
        System.out.print(" \u001B[33mStart Date:\u001B[0m " + coupon.getStartDate());
        System.out.print(" \u001B[33mEnd Date:\u001B[0m " + coupon.getEndDate());
        System.out.print(" \u001B[33mAmount:\u001B[0m " + coupon.getAmount());
        System.out.print(" \u001B[33mPrice:\u001B[0m " + coupon.getPrice());
        System.out.println(" \u001B[33mImage:\u001B[0m " + coupon.getImage());
    }

    public static void START() {
        System.out.println("""
                            
                               
                 ██████╗ ██████╗ ██╗   ██╗██████╗  ██████╗ ███╗   ██╗    ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗    ███████╗████████╗ █████╗ ██████╗ ████████╗███████╗██████╗
                ██╔════╝██╔═══██╗██║   ██║██╔══██╗██╔═══██╗████╗  ██║    ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║    ██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██╔════╝██╔══██╗
                ██║     ██║   ██║██║   ██║██████╔╝██║   ██║██╔██╗ ██║    ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║    ███████╗   ██║   ███████║██████╔╝   ██║   █████╗  ██║  ██║
                ██║     ██║   ██║██║   ██║██╔═══╝ ██║   ██║██║╚██╗██║    ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║    ╚════██║   ██║   ██╔══██║██╔══██╗   ██║   ██╔══╝  ██║  ██║
                ╚██████╗╚██████╔╝╚██████╔╝██║     ╚██████╔╝██║ ╚████║    ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║    ███████║   ██║   ██║  ██║██║  ██║   ██║   ███████╗██████╔╝
                 ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝      ╚═════╝ ╚═╝  ╚═══╝    ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝    ╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═════╝
                                                                                                                                                                                           """.replace("█", "\033[31m█\033[0m").indent(4));
    }


    public static void END() {
        System.out.println("""
                            
                            
                 \033[32m██████╗ ██████╗ ██╗   ██╗██████╗  ██████╗ ███╗   ██╗    ███████╗██╗   ██╗███████╗████████╗███████╗███╗   ███╗    ███████╗███╗   ██╗██████╗ ███████╗██████╗\033[0m
                \033[32m██╔════╝██╔═══██╗██║   ██║██╔══██╗██╔═══██╗████╗  ██║    ██╔════╝╚██╗ ██╔╝██╔════╝╚══██╔══╝██╔════╝████╗ ████║    ██╔════╝████╗  ██║██╔══██╗██╔════╝██╔══██╗\033[0m
                \033[32m██║     ██║   ██║██║   ██║██████╔╝██║   ██║██╔██╗ ██║    ███████╗ ╚████╔╝ ███████╗   ██║   █████╗  ██╔████╔██║    █████╗  ██╔██╗ ██║██║  ██║█████╗  ██║  ██║\033[0m
                \033[32m██║     ██║   ██║██║   ██║██╔═══╝ ██║   ██║██║╚██╗██║    ╚════██║  ╚██╔╝  ╚════██║   ██║   ██╔══╝  ██║╚██╔╝██║    ██╔══╝  ██║╚██╗██║██║  ██║██╔══╝  ██║  ██║\033[0m
                \033[32m╚██████╗╚██████╔╝╚██████╔╝██║     ╚██████╔╝██║ ╚████║    ███████║   ██║   ███████║   ██║   ███████╗██║ ╚═╝ ██║    ███████╗██║ ╚████║██████╔╝███████╗██████╔╝\033[0m
                 \033[32m╚═════╝ ╚═════╝  ╚═════╝ ╚═╝      ╚═════╝ ╚═╝  ╚═══╝    ╚══════╝   ╚═╝   ╚══════╝   ╚═╝   ╚══════╝╚═╝     ╚═╝    ╚══════╝╚═╝  ╚═══╝╚═════╝ ╚══════╝╚═════╝\033[0m
                                                                                                                                       """.replace("█", "\033[32m█\033[0m").indent(4));
    }


    public static void DailyCheckForExpiredCoupons() {
        long now = System.currentTimeMillis();
        long midnight = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        long remainingTime = midnight - now;
        long hours = remainingTime / (1000 * 60 * 60);
        long minutes = (remainingTime / (1000 * 60)) % 60;
        long seconds = (remainingTime / 1000) % 60;


        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = rightNow.format(formatter);
        System.out.println("\u001B[30m" +
                """
                             ____             _     __                           __                   __             ____                          ______                     _                      __          ______\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                            / __ \\  ____ _   (_)   / /   __  __         _____   / /_   ___   _____   / /__          / __/  ____    _____          / ____/   _  __    ____    (_)   _____  ___   ____/ /         / ____/  ____   __  __    ____   ____    ____    _____\040\040\040\040\040\040
                           / / / / / __ `/  / /   / /   / / / /        / ___/  / __ \\ / _ \\ / ___/  / //_/         / /_   / __ \\  / ___/         / __/     | |/_/   / __ \\  / /   / ___/ / _ \\ / __  /         / /      / __ \\ / / / /   / __ \\ / __ \\  / __ \\  / ___/\040\040\040\040\040\040
                          / /_/ / / /_/ /  / /   / /   / /_/ /        / /__   / / / //  __// /__   / ,<           / __/  / /_/ / / /            / /___    _>  <    / /_/ / / /   / /    /  __// /_/ /         / /___   / /_/ // /_/ /   / /_/ // /_/ / / / / / (__  )\040\040\040\040\040\040\040
                         /_____/  \\__,_/  /_/   /_/    \\__, /         \\___/  /_/ /_/ \\___/ \\___/  /_/|_|         /_/     \\____/ /_/            /_____/   /_/|_|   / .___/ /_/   /_/     \\___/ \\__,_/          \\____/   \\____/ \\__,_/   / .___/ \\____/ /_/ /_/ /____/\040\040\040\040\040\040\040\040
                                                      /____/                                                                                                     /_/                                                                  /_/\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                        """ + "\u001B[0m");

        System.out.println("\u001B[36m" +
                "Check number : " + count++ + "\n" +
                "Check time   : " + formatDateTime + "\n" +
                "\u001B[31m" + String.format("Next check will be at: %s. Remaining time: %02d:%02d:%02d\n",
                LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toLocalTime(), hours, minutes, seconds)
                + "\u001B[0m");

    }

    public static void INIT_DATABASE() {
        System.out.println("""
                ██╗███╗   ██╗██╗████████╗    ██████╗  █████╗ ████████╗ █████╗ ██████╗  █████╗ ███████╗███████╗        \s
                ██║████╗  ██║██║╚══██╔══╝    ██╔══██╗██╔══██╗╚══██╔══╝██╔══██╗██╔══██╗██╔══██╗██╔════╝██╔════╝        \s
                ██║██╔██╗ ██║██║   ██║       ██║  ██║███████║   ██║   ███████║██████╔╝███████║███████╗█████╗          \s
                ██║██║╚██╗██║██║   ██║       ██║  ██║██╔══██║   ██║   ██╔══██║██╔══██╗██╔══██║╚════██║██╔══╝          \s
                ██║██║ ╚████║██║   ██║       ██████╔╝██║  ██║   ██║   ██║  ██║██████╔╝██║  ██║███████║███████╗██╗██╗██╗
                ╚═╝╚═╝  ╚═══╝╚═╝   ╚═╝       ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝╚══════╝╚══════╝╚═╝╚═╝╚═╝
                                                                                                                      \s""");

    }

    public static void separator() {
        System.out.println("""
                                                                                                               \s
                                                                                                               \s
                █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ █████ 
                                                                                                                
                                                                                                               \s
                                                                                                               \s
                                                                                                               \s""");
    }

    public static void DATABASE_READY() {
        System.out.println("""
                ██████╗ ███████╗ █████╗ ██████╗ ██╗   ██╗    ██╗
                ██╔══██╗██╔════╝██╔══██╗██╔══██╗╚██╗ ██╔╝    ██║
                ██████╔╝█████╗  ███████║██║  ██║ ╚████╔╝     ██║
                ██╔══██╗██╔══╝  ██╔══██║██║  ██║  ╚██╔╝      ╚═╝
                ██║  ██║███████╗██║  ██║██████╔╝   ██║       ██╗
                ╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═════╝    ╚═╝       ╚═╝
                                                               \s""");

    }

    public static void localHost() {
        System.out.println("""
                            
                            
                            
                            
                            
                ██╗      ██████╗  ██████╗ █████╗ ██╗     ██╗  ██╗ ██████╗ ███████╗████████╗     █████╗  ██████╗  █████╗  ██████╗\s
                ██║     ██╔═══██╗██╔════╝██╔══██╗██║     ██║  ██║██╔═══██╗██╔════╝╚══██╔══╝ ██╗██╔══██╗██╔═████╗██╔══██╗██╔═████╗
                ██║     ██║   ██║██║     ███████║██║     ███████║██║   ██║███████╗   ██║    ╚═╝╚█████╔╝██║██╔██║╚█████╔╝██║██╔██║
                ██║     ██║   ██║██║     ██╔══██║██║     ██╔══██║██║   ██║╚════██║   ██║    ██╗██╔══██╗████╔╝██║██╔══██╗████╔╝██║
                ███████╗╚██████╔╝╚██████╗██║  ██║███████╗██║  ██║╚██████╔╝███████║   ██║    ╚═╝╚█████╔╝╚██████╔╝╚█████╔╝╚██████╔╝
                ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚══════╝   ╚═╝        ╚════╝  ╚═════╝  ╚════╝  ╚═════╝\s
                                                                            \s"""
        );
    }


    public final static String ADMIN_METHODS = """
             
             
             █████╗ ██████╗ ███╗   ███╗██╗███╗   ██╗    ███╗   ███╗███████╗████████╗██╗  ██╗ ██████╗ ██████╗ ███████╗      \s
            ██╔══██╗██╔══██╗████╗ ████║██║████╗  ██║    ████╗ ████║██╔════╝╚══██╔══╝██║  ██║██╔═══██╗██╔══██╗██╔════╝    ██╗
            ███████║██║  ██║██╔████╔██║██║██╔██╗ ██║    ██╔████╔██║█████╗     ██║   ███████║██║   ██║██║  ██║███████╗    ╚═╝
            ██╔══██║██║  ██║██║╚██╔╝██║██║██║╚██╗██║    ██║╚██╔╝██║██╔══╝     ██║   ██╔══██║██║   ██║██║  ██║╚════██║    ██╗
            ██║  ██║██████╔╝██║ ╚═╝ ██║██║██║ ╚████║    ██║ ╚═╝ ██║███████╗   ██║   ██║  ██║╚██████╔╝██████╔╝███████║    ╚═╝
            ╚═╝  ╚═╝╚═════╝ ╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝    ╚═╝     ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝      \s
                                                                                                                       
                                                                                                                       
                                                                                                                       
                                                                                                                           \s""";

    public static void COMPANIES_METHODS() {
        System.out.println(
                """


                        ██████╗ ██████╗ ███╗   ███╗██████╗  █████╗ ███╗   ██╗██╗███████╗███████╗    ███╗   ███╗███████╗████████╗██╗  ██╗ ██████╗ ██████╗ ███████╗
                        ██╔════╝██╔═══██╗████╗ ████║██╔══██╗██╔══██╗████╗  ██║██║██╔════╝██╔════╝    ████╗ ████║██╔════╝╚══██╔══╝██║  ██║██╔═══██╗██╔══██╗██╔════╝
                        ██║     ██║   ██║██╔████╔██║██████╔╝███████║██╔██╗ ██║██║█████╗  ███████╗    ██╔████╔██║█████╗     ██║   ███████║██║   ██║██║  ██║███████╗
                        ██║     ██║   ██║██║╚██╔╝██║██╔═══╝ ██╔══██║██║╚██╗██║██║██╔══╝  ╚════██║    ██║╚██╔╝██║██╔══╝     ██║   ██╔══██║██║   ██║██║  ██║╚════██║
                        ╚██████╗╚██████╔╝██║ ╚═╝ ██║██║     ██║  ██║██║ ╚████║██║███████╗███████║    ██║ ╚═╝ ██║███████╗   ██║   ██║  ██║╚██████╔╝██████╔╝███████║
                         ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝╚══════╝╚══════╝    ╚═╝     ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝
                        """
        );
    }


    public static void CUSTOMERS_METHODS() {
        System.out.println("""
                 
                 
                 ██████╗██╗   ██╗███████╗████████╗ ██████╗ ███╗   ███╗███████╗██████╗ ███████╗    ███╗   ███╗███████╗████████╗██╗  ██╗ ██████╗ ██████╗ ███████╗      \s
                ██╔════╝██║   ██║██╔════╝╚══██╔══╝██╔═══██╗████╗ ████║██╔════╝██╔══██╗██╔════╝    ████╗ ████║██╔════╝╚══██╔══╝██║  ██║██╔═══██╗██╔══██╗██╔════╝    ██╗
                ██║     ██║   ██║███████╗   ██║   ██║   ██║██╔████╔██║█████╗  ██████╔╝███████╗    ██╔████╔██║█████╗     ██║   ███████║██║   ██║██║  ██║███████╗    ╚═╝
                ██║     ██║   ██║╚════██║   ██║   ██║   ██║██║╚██╔╝██║██╔══╝  ██╔══██╗╚════██║    ██║╚██╔╝██║██╔══╝     ██║   ██╔══██║██║   ██║██║  ██║╚════██║    ██╗
                ╚██████╗╚██████╔╝███████║   ██║   ╚██████╔╝██║ ╚═╝ ██║███████╗██║  ██║███████║    ██║ ╚═╝ ██║███████╗   ██║   ██║  ██║╚██████╔╝██████╔╝███████║    ╚═╝
                 ╚═════╝ ╚═════╝ ╚══════╝   ╚═╝    ╚═════╝ ╚═╝     ╚═╝╚══════╝╚═╝  ╚═╝╚══════╝    ╚═╝     ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝ ╚═════╝ ╚═════╝ ╚══════╝      \s
                """);
    }

    public static void BEFORE() {
        System.out.println();
        System.out.println("\033[34m" + """
                ░█▀▄░█▀▀░█▀▀░█▀█░█▀▄░█▀▀
                ░█▀▄░█▀▀░█▀▀░█░█░█▀▄░█▀▀
                ░▀▀░░▀▀▀░▀░░░▀▀▀░▀░▀░▀▀▀""" + "\033[0m");
        System.out.println();
    }

    public static void AFTER() {
        System.out.println();
        System.out.println("\033[34m" + """
                ░█▀█░█▀▀░▀█▀░█▀▀░█▀▄
                ░█▀█░█▀▀░░█░░█▀▀░█▀▄
                ░▀░▀░▀░░░░▀░░▀▀▀░▀░▀""" + "\033[0m");
        System.out.println();
    }

    private static int counter = 1;

    public static void goodTest(String title) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = currentTime.format(formatter);
        System.out.printf("""

                \u001B[32m>>>>>>>>>>>> Test %03d - %s (%s)

                \u001B[0m""", counter++, title, formattedTime);
    }

    public static void badTest(String title) {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTime = currentTime.format(formatter);
        System.out.printf("""

                \u001B[31m>>>>>>>>>>>> Test %03d - %s (%s)

                \u001B[0m""", counter++, title, formattedTime);
    }

    private static int companyCount = 0;

    public static void printCompaniesDetails(List<Company> companies) {
        for (int i = 0; i < companies.size(); i += 3) {
            Art.printCompanyDetails(companies.get(i));
            companyCount++;
            if (i + 1 < companies.size()) {
                Art.printCompanyDetails(companies.get(i + 1));
                companyCount++;
            }
            if (i + 2 < companies.size()) {
                Art.printCompanyDetails(companies.get(i + 2));
                companyCount++;
            }
            if (companyCount % 3 == 0) {
                System.out.println();
            }
        }
    }

    public static void printCustomersDetails(List<Customer> customers) {
        for (int i = 0; i < customers.size(); i += 3) {
            Art.printCustomerDetails(customers.get(i));
            if (i + 1 < customers.size()) {
                Art.printCustomerDetails(customers.get(i + 1));
            }
            if (i + 2 < customers.size()) {
                Art.printCustomerDetails(customers.get(i + 2));
            }
            System.out.println();
        }
    }


}

