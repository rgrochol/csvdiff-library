package pl.kubiczek.csvdiff

/**
 * Factory for [[pl.kubiczek.csvdiff.Luncher]] instances.
 */
object Luncher {
  /**
   * Create luncher with a given configuration.
   * 
   * @param config the configuration of the csvdiff framework
   * @return a new Luncher instance 
   */
  def apply(config: Configuration) = {
    val parser = new CsvParser(config)
    new Luncher(config, parser)
  }
}

/**
 * This class is used to lunch the csvdiff framework. Client code should 
 * call run() method.
 */
class Luncher(config: Configuration, parser: CsvParser) {
  /**
   * Runs csvdiff framework.
   */
  def run() {
    val (actualTable, expectedTable) = parser.parse()
    //val result = comparator.compare(actualLines, expectedLines)
    
    //val actualMap = indexing(actualLines.toArray)
    //val expectedMap = indexing(expectedLines.toArray)
  }
  
  private def indexing(rows: Array[Array[String]]) = {
    rows.groupBy(x => f(x, config.keyColumns))
  }
  
  private def f(row: Array[String], keys: List[Int]): List[String] =
    keys match {
    	case x::xs => row(x)::f(row, xs)
    	case Nil => Nil
  	}
}