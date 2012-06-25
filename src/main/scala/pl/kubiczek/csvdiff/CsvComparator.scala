package pl.kubiczek.csvdiff

class CsvComparator(config: Configuration) {

  def compare(actual: Iterator[Array[String]], expected: Iterator[Array[String]]): List[DiffResult] = {
    compare(actual.toList.zipWithIndex, expected.toList.zipWithIndex)
  }
  
  def compare(actual: List[(Array[String], Int)], expected: List[(Array[String], Int)]): List[DiffResult] = {
    (actual, expected) match {
      case ((x, n)::xs, (y, m)::ys) =>
        x.zip(y) // list of (actualValue, expectedValue)
      		.zipWithIndex // list of ((actualValue, expectedValue), columnNr)
      		.filter(x => !config.unimportantColumns.contains(x._2)) //unimportant columns are filtered out
      		.filter(x => x._1._1 != x._1._2) // array filtered by actualValue != expectedValue
      		.map(x => NoMatchValue(x._1._1, x._1._2, n, x._2))
      		.toList ++ compare(xs, ys)
      case (Nil, ls@_::_) => ls.map(x => ExpectedRowNotExist(x._2))
      case (ls@_::_, Nil) => ls.map(x => UnexpectedRow(x._2))
      case (Nil, Nil) => Nil 
    }
  
  }
  
}