package pl.kubiczek.csvdiff

class Table(rows: Array[Row], config: Configuration) {

  def getRow(i: Int) = this.rows(i)
  
  def getRows = this.rows
  
  def length = this.rows.length
  
  def compare(that: Table) = {
    if(config.keyColumns.isEmpty)
      this.compareRowByRow(that)
    else
      this.compareKeyByKey(that)
  }
  
  private def compareRowByRow(that: Table) = 
    createDiffResults(this.getRows.toList, that.getRows.toList)
  
  private def createDiffResults(actual: List[Row], expected: List[Row]): List[DiffResult] = 
    (actual, expected) match {
      case (x::xs, y::ys) => x.compare(y) ++ createDiffResults(xs, ys)
      case (Nil, ls@_::_) => ls.map(ExpectedRowNotExist(_))
      case (ls@_::_, Nil) => ls.map(UnexpectedRow(_))
      case (Nil, Nil) => Nil 
    }
    
  private def compareKeyByKey(that: Table): List[DiffResult] = {
    val thisMap = indexing(this.getRows)
    val thatMap = indexing(that.getRows)
    // TODO handling of unique key violation, i.e. thisMap(key).length > 1
  
    thisMap.keys.flatMap(key => thatMap.get(key) match {
        case Some(rows) => thisMap(key)(0).compare(rows(0)).toList
        case None => List(UnexpectedRow(thisMap(key)(0))) // TODO or ExpectedRowNotExist
      }
    ).toList
  }
  
  private def indexing(rows: Array[Row]) = {
    rows.groupBy(row => config.keyColumns.map(row.getField(_)))
  }

}