package calculator

import Math._

object Polynomial {

  //    Δ = b² - 4ac
  def computeDelta(a: Signal[Double],
                   b: Signal[Double],
                   c: Signal[Double]): Signal[Double] = {
    Signal(b() * b() - 4 * a() * c())
  }

  //    (-b ± √Δ) / 2a
  def computeSolutions(a: Signal[Double], b: Signal[Double],
                       c: Signal[Double], delta: Signal[Double]): Signal[Set[Double]] = {
    //    (-b ± √Δ) / 2a
    Signal{
      val d = delta()
      if(d < 0) Set()
      else {
        val bVal = b()
        val aVal = a()

        Set(
          (-bVal + sqrt(d)) / (2 * aVal),
          (-bVal - sqrt(d)) / (2 * aVal)
        )
      }

    }
  }
}