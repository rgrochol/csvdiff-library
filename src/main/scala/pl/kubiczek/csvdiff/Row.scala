package pl.kubiczek.csvdiff


class Row(rowNr: Int, fields: Array[String], config: Configuration) {

  def getField(i: Int) = this.fields(i)
  
  def getFields = this.fields
  
  def length = this.fields.length
  
  def key = config.keyColumns.map(getField(_))
  
  def compare(that: Row) = {
    this.getFields.zip(that.getFields)
    	.zipWithIndex // array of ((actualValue, expectedValue), columnNr)
    	.filter(x => !config.unimportantColumns.contains(x._2)) //unimportant columns are filtered out
      	.filter(x => x._1._1 != x._1._2) // array filtered by actualValue != expectedValue
      	.map(x => NoMatchValue(this, that, x._2))
      	.toList
  }

}