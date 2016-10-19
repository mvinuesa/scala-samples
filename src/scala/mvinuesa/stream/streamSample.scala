import scala.util.Random

object StreamSample {


  /**
    * Sum two ramdom numbers consecutive
    *
    * @return
    */
  def ramdomSumStream(): Stream[Int] = {
    lazy val s: Stream[(Int, Int)] = (0, 0) #:: Stream.iterate((1, 1))((x: (Int, Int)) => (x._1 + 1, s(Random.nextInt(x._1 + 1))._2 + s(Random.nextInt(x._1))._2))
    s map { x => x._2 }
  }
}

