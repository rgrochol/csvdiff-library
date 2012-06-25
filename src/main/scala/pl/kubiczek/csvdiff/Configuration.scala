package pl.kubiczek.csvdiff
import java.io.File

/**
 * A configuration used by the csvdiff framework.
 * 
 * Configuration instance specify all user-configurable parameters which
 * are used at runtime by the csvdiff framework.
 */
class Configuration {
  /**
   * Character used to separate values in CSV files. By default the values are
   * comma-separated.
   */
  val delimiter = ","
  /**
   * Input file in CSV format used for comparison, the file contains
   * actual values.
   */
  val actualFile = new File("actual.csv")
  /**
   * Input file in CSV format used for comparison, the file contains 
   * expected values.
   */
  val expectedFile = new File("expected.csv")
  /**
   * Set of column numbers which are skipped during comparison. By default the set
   * is empty, i.e. each column is involved in comparison.
   */
  val unimportantColumns: Set[Int] = Set()
}