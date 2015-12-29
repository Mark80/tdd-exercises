package katas.katabanks

/**
 * Created by marco on 29/12/15.
 */
trait Parser {

  def parse(upList: String, middleList: String, bottomList: String): List[String]

}
