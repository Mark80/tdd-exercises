package katas.katabanks

import scala.annotation.tailrec

/**
 * Created by marco on 29/12/15.
 */
object InputParser extends Parser {

  private val digitDimension: Int = 3
  private val step: Int = 3

  override def parse(upList: String, middleList: String, bottomList: String): List[String] =
    parse(splitInput(upList), splitInput(middleList), splitInput(bottomList), List.empty[String])

  @tailrec
  private def parse(upList: List[String], middleList: List[String], bottomList: List[String], acc: List[String]): List[String] =
    upList match {
      case Nil => acc
      case _ => parse(upList.tail, middleList.tail, bottomList.tail, acc ++ List(toDigit(upList.head, middleList.head, bottomList.head)))
    }

  private def splitInput(input: String): List[String] = input.sliding(digitDimension, step).toList

  private def toDigit(up: String, middle: String, botton: String): String = up + middle + botton

}
