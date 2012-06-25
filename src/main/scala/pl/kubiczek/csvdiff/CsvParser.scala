package pl.kubiczek.csvdiff

import java.io._

class CsvParser(config: Configuration) {
  
  def parse() = {
	(scala.io.Source.fromFile(config.actualFile).getLines.map(_.split(config.delimiter)),
	    scala.io.Source.fromFile(config.expectedFile).getLines.map(_.split(config.delimiter)))
  }

}