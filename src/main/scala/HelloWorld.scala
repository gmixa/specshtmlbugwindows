import zio.*
import java.io.IOException
object HelloWorld extends ZIOAppDefault:
  def sayHello: ZIO[Any, IOException, Unit] =
    Console.printLine("Hello, World!")
  end sayHello
  def run: ZIO[Any, IOException, Unit] = sayHello
end HelloWorld
