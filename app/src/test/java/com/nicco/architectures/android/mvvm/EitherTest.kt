package com.nicco.architectures.android.mvvm

import com.nicco.architectures.android.base.Either
import com.nicco.architectures.android.base.getOrElse
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeInstanceOf
import org.amshove.kluent.shouldEqualTo
import org.junit.Test

class EitherTest : UnitTest() {

    @Test
    fun `Either Right should return correct type`() {
        val result = Either.Right("ironman")

        result shouldBeInstanceOf Either::class.java
        result.isRight shouldBe true
        result.isLeft shouldBe false
        result.fold({},
                { right ->
                    right shouldBeInstanceOf String::class.java
                    right shouldEqualTo "ironman"
                })
    }

    @Test fun `Either Left should return correct type`() {
        val result = Either.Left("ironman")

        result shouldBeInstanceOf Either::class.java
        result.isLeft shouldBe true
        result.isRight shouldBe false
        result.fold(
                { left ->
                    left shouldBeInstanceOf String::class.java
                    left shouldEqualTo "ironman"
                }, {})
    }

    @Test fun `Either fold should ignore passed argument if it is Right type`() {
        val result = Either.Right("Right").getOrElse("Other")

        result shouldEqualTo "Right"
    }

    @Test fun `Either fold should return argument if it is Left type`() {
        val result = Either.Left("Left").getOrElse("Other")

        result shouldEqualTo "Other"
    }
}