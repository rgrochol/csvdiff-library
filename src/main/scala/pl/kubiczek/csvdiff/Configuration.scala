package pl.kubiczek.csvdiff
import java.io.File

/**
 * A configuration used by the csvdiff framework.
 */
class Configuration {

  /**
   * Character used to separate values in CSV files. By default values are
   * comma-separated.
   */
  val delimiter = ","
  /**
   * Input file in CSV format used for comparison, the file contains
   * actual values.
   */
  val actual = new File("actual.csv")
  /**
   * Input file in CSV format used for comparison, the file contains 
   * expected values.
   */
  val expected = new File("expected.csv")
    
}