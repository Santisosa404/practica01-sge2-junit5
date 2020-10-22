package org.salesianostriana.dam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class CuentaCorrienteTest {

    static CuentaCorriente cun;
    static  CuentaCorriente cun2;

    @BeforeAll
    static void init() {
        cun = new CuentaCorriente("Santi", 1234567, 10000);
        cun2 = new CuentaCorriente("Santi", 1234567, 10000);
        System.out.println("Instanciadas cuentas");
    }

    @Test
    @DisplayName("Depositar")
    void depositTrue() {
        assertEquals(true, cun.deposit(2), "Debe devolver true");
    }

    @Test
    @DisplayName("DepositarFalse")
    void depositFalse() {
        assertEquals(false, cun.deposit(-2), "Debe devolver false");
    }

    @Test
    @DisplayName("RetiradaTrue")
    void retiradaTrue() {
        assertEquals(true, cun.withdraw(10, 2), "Debe devolver true");
    }


    @Test
    @DisplayName("RetiradaFalse")
    void retiradaFalse() {
        assertEquals(false, cun.withdraw(10001, 2), "Debe devolver false");
    }

    @Test
    @DisplayName("RetiradaFalseNegativo")
    void retiradaFalseNegativo() {
        assertEquals(false, cun.withdraw(-1, 2), "Debe devolver false");
    }

    @Test
    @DisplayName("RetiradaFalseNegativo")
    void retiradaFalseNegativoCuota() {
        assertEquals(false, cun.withdraw(2, -1), "Debe devolver false");
    }
    @Test
    @DisplayName("AgregarInteres")
    void agregarInteres(){
        cun.addInterest();
        assertNotEquals(cun.getSaldo(), cun2.getSaldo());
    }

    @Test
    @DisplayName("DevolverCuenta")
    void devolverCuenta(){
        assertEquals(1234567,cun.getAccountNumber(), "Debe devolver el numero de la cuenta");
    }

    @Test
    @DisplayName("DevolverToString")
    void devolverToString(){
        assertEquals("1234567	Santi	10.000,00 €", cun2.toString(), "Debe devolver el toString");
    }





}
