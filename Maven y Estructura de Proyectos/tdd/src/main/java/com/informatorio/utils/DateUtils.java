package com.informatorio.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtils {
 
    public static void main(String[] args) {
        System.out.println(convertirFecha("20-02-2021"));;
    }

    public static String hello() {
        return "Hello";
    }

    public static LocalDate convertirFecha(String fechaString) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaString, formato);
        return fecha;
    }
}