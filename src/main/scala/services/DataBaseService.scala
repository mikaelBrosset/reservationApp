package services

import scala.io.Source
import io.circe._
import io.circe.parser._

object DataBaseService {
  def getAllFromTable(tableName: String): Seq[Any] = {

  }
  def getFileInfo(tableName: String): Iterator[String] = {
    Source.fromResource(tableName + ".txt").getLines()
  }
  def JsonToSeq(json: String): Seq[Any] = {
    val parseResult = parse(json)
  }
}
