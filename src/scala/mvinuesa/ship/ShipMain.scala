package main.scala.session3

import ship.{OK, Ship}


/**
  * Created by Mario on 17/10/2016.
  */
object ShipMain {

  def main(args: Array[String]): Unit = {

    //val ship1 = new Ship(Set(OK(0,1), OK(10,0)));
    //println( "Returned Value : " + new Ship(Set(OK(0,0))));
    val ship2 = new Ship(Set(OK(0,0), OK(0,1)));
    println( "Returned Value : " + ship2);
    println( "+=> : " + ship2.+=>(OK(0,0)))
    println( "+=> : " + ship2.+=>(OK(0,1)));
    println( "isSunk : " + ship2.isSunk());
  }
}
