package katas.numberinwords

import org.scalatest.{Matchers, FlatSpec}

/**
 * Created by marco on 24/12/15.
 */
class NumberInWordSpec extends FlatSpec with Matchers {


  "0" should "essere scritto come zero" in {

    assert(toWords(0) === "zero")

  }

  "1" should "essere scritto come uno" in {

    assert(toWords(1) === "uno")

  }



  "4" should "essere scritto come quattro" in {

    assert(toWords(4) === "quattro")

  }

  val repoWord: Map[Double, String] = Map(
    0.0 -> "zero",
    1.0 -> "uno",
    2.0 -> "due",
    3.0 -> "tre",
    4.0 -> "quattro",
    5.0 -> "cinque",
    6.0 -> "sei",
    7.0 -> "sette",
    8.0 -> "otto",
    9.0 -> "nove",
    10.0 -> "dieci",
    11.0 -> "undici"
ß
  )

  def toWords(amount: Double): String = {

    repoWord.getOrElse(amount, "")

  }
}
