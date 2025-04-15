import zio.*
import zio.stream.*

import java.io.{FileInputStream, IOException}

object ZIOReadFile extends ZIOAppDefault:
  def open(fileName: String): ZStream[Any, IOException, String] =
    ZStream
      .fromInputStreamZIO(
        ZIO
          .attempt(new FileInputStream(fileName))
          .refineToOrDie[IOException]
      )
      .map(f => new String(Array(f)))
  end open

  val sink = ZSink.collectAll[String].map(_.mkString("-"))
  override def run = open("d.txt")
    .run(sink)
    .debug("test")
  end run

end ZIOReadFile
