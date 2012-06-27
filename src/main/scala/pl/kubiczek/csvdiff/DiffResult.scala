package pl.kubiczek.csvdiff

abstract sealed class DiffResult
case class NoMatchValue(actual: Row, expected:Row, columnNr: Int) extends DiffResult
case class ExpectedRowNotExist(expected: Row) extends DiffResult
case class UnexpectedRow(actual: Row) extends DiffResult
