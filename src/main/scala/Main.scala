import zio.*
import zio.Console.*
import zio.metrics.Metric

import scala.io.{Codec, Source}
import scala.util.{Try, Using}
import zio.stm.*
import zio.Fiber.Status

case class HostPort(host: String, port: Int)
object HostPort:
  given config: Config[HostPort] =
    (Config.string("host") ++ Config.int("port")).map { case (host, port) =>
      HostPort(host, port)
    }
end HostPort
case class HostPorts(hostPorts: List[HostPort])
object HostPorts:
  given config: Config[HostPorts] =
    Config.listOf(HostPort.config).map(HostPorts(_))
end HostPorts

object Main extends ZIOAppDefault:
  def run =
    for {
      config <- ZIO.config[HostPorts]
      _ <- printLine(s"Application started: $config")
      _ <- ZIO.foreachDiscard(config.hostPorts)(e =>
        printLine(s"http://${e.host}:${e.port}")
      )
    } yield ()
  end run

end Main
