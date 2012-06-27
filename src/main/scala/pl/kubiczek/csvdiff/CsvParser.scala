package pl.kubiczek.csvdiff

import java.io._

class CsvParser(config: Configuration) {
  
  def parse() = {
	(createTable(config.actualFile), createTable(config.expectedFile))
  }
  
  private def createTable(file: File) = {
    new Table(scala.io.Source.fromFile(file)
				.getLines
				.map(_.split(config.delimiter))
				.toArray
				.zipWithIndex
				.map(x => new Row(x._2, x._1, config)),
			  config)
  }

}