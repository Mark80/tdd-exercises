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

    val parsedList = parse(up, middle, bottom)
    assert(parsedList.forall(_ == zero))

  }

  it should "convert all nine" in {

    val up =     " _ " * 9
    val middle = "|_|" * 9
    val bottom = " _|" * 9

    val parsedList = parse(up, middle, bottom)
    assert(parsedList.forall(_ == nine))
  }

  it should "convert all one" in {

    val up =     "   " * 9
    val middle = "  |" * 9
    val bottom = "  |" * 9

    val parsedList = parse(up, middle, bottom)
    assert(parsedList.forall(_ == one))
  }



}

trait  Parser {

  def parse(upList:String, middleList: String, bottomList: String): List[String]

}

object InputParser extends Parser {

  override def parse(upList:String, middleList: String, bottomList: String): List[String] =
    parse(splitInput(upList), splitInput(middleList), splitInput(bottomList), List.empty[String])

  @tailrec
  private def parse(upList: List[String], middleList: List[String], bottomList: List[String], acc: List[String]): List[String] =
    upList match {
      case Nil => acc
      case _ => parse(upList.tail, middleList.tail, bottomList.tail, acc ++ List(toDigit(upList.head, middleList.head, bottomList.head)))
    }

  private def splitInput(input: String): List[String] = input.sliding(3,3).toList

  private def toDigit(up: String, middle: String, botton: String): String = up + middle + botton

}
