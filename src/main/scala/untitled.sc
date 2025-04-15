import zio._
val s = ZIO.succeed(21).map(_ * 2)
val f = ZIO.fail("No no!").mapError(
  m => Exception(m))
