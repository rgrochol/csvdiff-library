package pl.kubiczek.csvdiff

class Table(rows: Array[Row], config: Configuration) {

  def getRow(i: Int) = rows(i)
  
  def length = rows.length
  

}