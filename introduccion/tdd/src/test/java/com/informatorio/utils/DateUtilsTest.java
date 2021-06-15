package com.informatorio.utils;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class DateUtilsTest {
 
    @Test
    public void testeandoHello() {
        // Given
        
        // When
        String saludo = DateUtils.hello();
        // Then
        assertEquals("Hello", saludo);
    }

    @Test
    public void debe_devolver_fecha_a_partir_de_un_string() {
        LocalDate fecha = DateUtils.convertirFecha("12-10-2020");
        assertEquals(LocalDate.parse("2020-10-12"), fecha);
    }
}