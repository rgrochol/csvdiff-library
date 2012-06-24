package pl.kubiczek.csvdiff

/**
 * This class is used to lunch the csvdiff framework. Client code should 
 * provide the configuration and execute run() method.
 */
object Luncher {

  var config = new Configuration()
  
  def run() {
    val actualLines = CsvParser.parse(config.actual, config.delimiter)
    val expectedLines = CsvParser.parse(config.expected, config.delimiter)
    
    val result = CsvComparator.compare(actualLines.toList.zipWithIndex, expectedLines.toList.zipWithIndex)
  }
}