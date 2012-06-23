package pl.kubiczek.csvdiff

import java.io._

object CsvParser {
  
  def parse(csv: File) = {
	scala.io.Source.fromFile(csv).getLines.map(_.split(";"))
  }

}