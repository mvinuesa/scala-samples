package ship

/**
  *  Case class for ship
  *  A ship is a set of ShipCell
  *  Require a set of 1 to 4 ShipCells
  *  Require shipCells must be consecutive and in order
  *
  *  @author mvinuesa
  */
case class Ship(shipCells: Set[ShipCell]) {
  require(shipCells.size > 0 && shipCells.size <= 4)
  require(isPlaced(shipCells))

  private def isPlaced(shipCells: Set[ShipCell]): Boolean = {

    def aux (shipCell: ShipCell, shipCells: Seq[ShipCell], accu : Boolean) : Boolean = {
      if (accu == false) {
        false
      } else if (shipCells.isEmpty) {
        true
      } else {
        aux(shipCells.head, shipCells.tail, (shipCell.x == shipCells.head.x && shipCell.y + 1 == shipCells.head.y) ||
          (shipCell.y == shipCells.head.y && shipCell.x + 1 == shipCells.head.x))
      }
    }
    val sortedSeq = shipCells.toSeq.sorted
    aux(sortedSeq.head, sortedSeq.tail, true)
  }

  /**
    * Operator to torpedoing the ship
    *
    * @param shipCell, cell to be torpedoing
    *
    * @return a new Ship if the cell is in the ship, with a Hit cell
    */
  def +=> (shipCell: ShipCell): Ship = {
    if (shipCells(shipCell)) {
      new Ship(shipCells - shipCell + Hit(shipCell.x , shipCell.y))
    } else {
      this
    }
  }

  /**
    *
    * @return true is the ship is sunk
    */
  def isSunk() : Boolean = {
    shipCells.forall(isSunkCell(_))
  }

  private def isSunkCell (shipCell: ShipCell) : Boolean = shipCell match {
      case OK(_ , _) => true
      case Hit(_ , _) => false
  }

}
