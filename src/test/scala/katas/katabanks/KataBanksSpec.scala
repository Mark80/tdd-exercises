package katas.katabanks

import org.scalatest.{Matchers, FlatSpec}

import scala.annotation.tailrec


class KataBanksSpec extends FlatSpec with Matchers {

  import InputParser._

  val zero: String = " _ " +
                     "| |" +
                     "|_|"

  val one: String = "   " +
                    "  |" +
                    "  |"

  val nine: String = " _ " +
                     "|_|" +
                     " _|"



  "input parser " should "create list of digit" in {

    val up =     " _ " * 9
    val middle = "| |" * 9
    val bottom = "|_|" * 9

    val listOfDigits = parse(up, middle, bottom)
    assert(listOfDigits.forall(_ == zero))

  }

  it should "convert all nine" in {

    val up =     " _ " * 9
    val middle = "|_|" * 9
    val bottom = " _|" * 9

    val listOfDigits = parse(up, middle, bottom)
    assert(listOfDigits.forall(_ == nine))
  }

  it should "convert all one" in {

    val up =     "   " * 9
    val middle = "  |" * 9
    val bottom = "  |" * 9

    val listOfDigits = parse(up, middle, bottom)
    assert(listOfDigits.forall(_ == one))
  }



}




