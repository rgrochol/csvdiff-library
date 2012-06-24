package pl.kubiczek.csvdiff

abstract sealed class DiffResult
case class NoMatchValue(actualValue: String, expectedValue:String, 
    rowNr: Int, columnNr: Int) extends DiffResult
case class ExpectedRowNotExist(rowNr: Int) extends DiffResult
case class UnexpectedRow(rowNr: Int) extends DiffResult
