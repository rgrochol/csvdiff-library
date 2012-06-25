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
    val comparator = new CsvComparator(config)
    val parser = new CsvParser(config)
    new Luncher(config, comparator, parser)
  }
}

/**
 * This class is used to lunch the csvdiff framework. Client code should 
 * call run() method.
 */
class Luncher(config: Configuration, comparator: CsvComparator, parser: CsvParser) {
  /**
   * Runs csvdiff framework.
   */
  def run() {
    val (actualLines, expectedLines) = parser.parse()
    val result = comparator.compare(actualLines, expectedLines)
    
  }
}