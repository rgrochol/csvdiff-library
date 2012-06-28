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
   * 
   * @return a list of [[pl.kubiczek.csvdiff.DiffResult]] instances representing
   * differences in compared files
   */
  def run() = {
    val (actualTable, expectedTable) = parser.parse()
    actualTable.compare(expectedTable)
  }
}