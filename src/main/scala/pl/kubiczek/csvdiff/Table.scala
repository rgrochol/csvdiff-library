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
  
  private def compareRowByRow(that: Table) = f(this.getRows.toList, that.getRows.toList)
  
  private def f(actual: List[Row], expected: List[Row]): List[DiffResult] = 
    (actual, expected) match {
      case (x::xs, y::ys) => x.compare(y) ++ f(xs, ys)
      case (Nil, ls@_::_) => ls.map(ExpectedRowNotExist(_))
      case (ls@_::_, Nil) => ls.map(UnexpectedRow(_))
      case (Nil, Nil) => Nil 
    }
    
  private def compareKeyByKey(that: Table): List[DiffResult] = Nil // TODO

}