package com.nicco.architectures.android

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class TestGlobo {

    fun myFizzSolution(number: Int): String {
        if (number <= 0) {
            return "Numero invalido"
        }

        return if (multipleThirty(number))
            "zoom"
        else if (ehBuzz(number) && ehFizz(number))
            "fizzbuzz"
        else if (ehFizz(number))
            "fizz"
        else if (ehBuzz(number))
            "buzz"
        else
            number.toString()
    }

    private fun multipleThirty(number: Int) = number % 30 == 0

    private fun ehBuzz(number: Int) = number % 5 == 0

    private fun ehFizz(number: Int): Boolean {
        if (number % 3 == 0) {
            return true
        } else if (novaRegraFizz(number)) {
            return true
        }
        return false
    }

    private fun novaRegraFizz(number: Int) = number.toString().contains('3')

    @Test
    fun novaRegraFizz() {
        assertTrue(novaRegraFizz(37))
    }

    @Test
    fun ehMultipleThirty() {
        assertTrue(multipleThirty(30))
    }

    @Test
    fun naoEhMultipleThirty() {
        assertFalse(multipleThirty(31))
    }

    @Test
    fun ehBuzz() {
        assertTrue(ehBuzz(5))
    }

    @Test
    fun naoBuzz() {
        assertFalse(ehBuzz(3))
    }

    @Test
    fun ehFizz() {
        assertTrue(ehFizz(3))
    }

    @Test
    fun naoFizz() {
        assertFalse(ehFizz(5))
    }

    @Test
    fun numeroMenorQueZeroInvalido() {
        val test = myFizzSolution(0)
        assert(test == "Numero invalido")
    }

    @Test
    fun meuNumeroEhFizz() {
        val test = myFizzSolution(3)
        assert(test == "fizz")

        val test2 = myFizzSolution(37)
        assert(test2 == "fizz")
    }

    @Test
    fun isZoom(){
        val test = myFizzSolution(30)
        assert(test == "zoom")
    }

    @Test
    fun meuNumeroEhFizzBuzz() {
        val test = myFizzSolution(15)
        assert(test == "fizzbuzz")
    }

    @Test
    fun meuNumeroEhBuzz() {
        val test = myFizzSolution(5)
        assert(test == "buzz")
    }
}