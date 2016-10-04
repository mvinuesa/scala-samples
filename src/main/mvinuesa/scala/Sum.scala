import annotation.tailrec

/**
  * Define a sum linear and sum with tailrec
  *
  * @author mvinuesa
  */
object Sum {
  def sum(a: Int, b: Int): Int =
    if (a > b) 0
    else a + sum(a + 1, b)

  def sumTail(f: Int => Int)(a: Int, b: Int): Int = {
    @tailrec
    def iter(a: Int, result: Int): Int = {
      if (a > b) result
      else iter(a + 1, result + f(a))
    }
    iter(a, 0)
  }

  def main(args: Array[String]) {
    val result0 = sumTail(x => x)(1, 3)
    println(result0)
    val result1 = sum(1, 3)
    println(result1)
    assert(result0 == result1)
  }
}