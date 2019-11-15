package services

object ErrorManager {
  var errors: Seq[String] = Seq()

  def addError(error: String): Unit = {
    errors = errors :+ error
  }
}
