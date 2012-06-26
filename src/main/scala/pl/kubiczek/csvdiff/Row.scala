package pl.kubiczek.csvdiff


class Row(rowNr: Int, fields: Array[String], config: Configuration) {

  def getField(i: Int) = fields(i)
  
  def length = fields.length
  
  def key = config.keyColumns.map(getField(_))

}