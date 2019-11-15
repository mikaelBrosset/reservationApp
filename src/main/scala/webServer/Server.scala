package webServer

import akka.actor.{ActorSystem, ClassicActorSystemProvider}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn

object WebServer {
  def main(args: Array[String]) {

    implicit val system = ActorSystem("my-system")
    implicit val materializer = ActorMaterializer()
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.dispatcher

    val route =
      path("") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>HOMEPAGE</h1>"))
        }
      } ~ path("add") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h3>ADD</h3>"))
        }
      } ~ path("remove") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h3>REMOVE</h3>"))
        }
      } ~ path("getAll") {
        get {
          complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h3>GET ALL</h3>"))
        }
      }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 9999)

    println(s"Server online at http://localhost:9999/\nPress RETURN to stop...")
    StdIn.readLine() // let it run until user presses return
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
