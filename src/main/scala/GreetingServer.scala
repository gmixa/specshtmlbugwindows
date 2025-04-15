import zio._
import zio.http._
object GreetingServer extends ZIOAppDefault:
  val routes =
    Routes(
      Method.GET / Root -> handler(Response.text("Greetings at your Service")),
      Method.GET / "greet" -> handler {(req : Request) =>
        val name = req.queryOrElse[String]("name","World")
        Response.text(s"Hello $name")
      }
    )
  override def run = Server.serve(routes).provide(Server.defaultWithPort(8081))
end GreetingServer

