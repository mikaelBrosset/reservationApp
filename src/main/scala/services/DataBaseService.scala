package services

import scala.io.Source

object DataBaseService {

  def getTableFileContent(tableName: String): String = {
    Source.fromResource(tableName + ".txt").getLines().mkString
  }

  def JsonToMap(json: String): Map[String, String] = {
    io.circe.parser.decode[Map[String, String]](json) match {
      case Right(v) => v
      case Left(_) => Map()
    }
  }
}
