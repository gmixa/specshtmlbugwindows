import zio.Scope
import zio.test.*

import java.io.IOException

object HelloWorldSpec extends ZIOSpecDefault:
  override def spec: Spec[Any, IOException] =
    suite("HelloWorldSpec") {
      test("sayHello correctly displays output") {
        for {
          _ <- HelloWorld.sayHello
          output <- TestConsole.output
        } yield assertTrue(output == Vector("Hello, World!\n"))
      }
    }
end HelloWorldSpec
