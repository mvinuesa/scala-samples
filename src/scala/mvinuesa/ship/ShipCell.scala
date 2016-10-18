package ship

/**
  * Classes to represent a ship cell
  *
  * @author mvinuesa
  */

/**
  * Abstrack class for ship cell, extends Ordered
  * @param x, x axis position
  * @param y, y axis position
  */
abstract class ShipCell(val x: Int, val y:Int) extends Ordered [ShipCell] {

  def compare (that: ShipCell) = {
    if (this.x == that.x && this.y == that.y)
      0
    else if (this.x > that.x || this.y > that.y)
      1
    else
      - 1
    }
}

/**
  * Class for OK cells in a ship
  *
  * @param x, x axis position
  * @param y, y axis position
  */
case class OK(override val x: Int, override val y:Int) extends ShipCell(x, y)

/**
  * Class for Hit cells in a ship
  *
  * @param x, x axis position
  * @param y, y axis position
  */
case class Hit(override val x: Int, override val y:Int) extends ShipCell(x, y)
