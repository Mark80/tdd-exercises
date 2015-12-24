package katas.katapotter

import org.scalatest._


class PotterSpec extends FlatSpec with Matchers {

  "0 libri " should "hanno prezzo 0" in {

    val libri = Vector.empty[String]

    assert(price(libri) === 0)

  }

  "1 libro " should "ha prezzo 8" in {

    val libri = Vector("1")

    assert(price(libri) === 8)

  }


  "2 libri uguali " should "ha prezzo 16" in {

    val libri = Vector("1", "2")

    assert(price(libri) === 16)

  }

  "5 libri uguali " should "ha prezzo 40" in {

    val libri = Vector("1", "2", "3", "4", "5")

    assert(price(libri) === 40)

  }

  "2 libri diversi  " should "hanno il 5% di sconto " in {

    val libri = Vector("1", "1")
    assert(price(libri) === 8 * 2 * 0.95)

  }

  "3 libri diversi  " should "hanno il 10% di sconto " in {

    val libri = Vector("1", "1", "1")
    assert(price(libri) === 8 * 3 * 0.90)

  }


  "2 libri diversi e uno uguale " should "applicano lo sconto del 10% sui due libri diversi" in {

    val libri = Vector("1", "1", "2")
    assert(price(libri) === 8 + 8 * 2 * 0.95)

  }

  def price(libri: Vector[String]): Double = {

    if (libri.size == 3 && libri(0) == libri(1) && libri(2) == libri(1))
      libri.size * 8 * 0.90
    else if (libri.size == 2 && libri(0) == libri(1))
      libri.size * 8 * 0.95
    else
      libri.size * 8
  }

}
