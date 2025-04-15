scalaVersion := "3.6.4"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.17",
  "dev.zio" %% "zio-json" % "0.7.42",
  "dev.zio" %% "zio-http" % "3.2.0",
  "dev.zio" %% "zio-http-testkit" % "3.2.0" % Test,
  "io.getquill" %% "quill-zio" % "4.8.6",
  "io.getquill" %% "quill-jdbc-zio" % "4.8.6",
  "com.h2database" % "h2" % "2.3.232",
  "dev.zio" %% "zio-test" % "2.1.17" % Test,
  "dev.zio" %% "zio-http-testkit" % "3.2.0" % Test,
  "dev.zio" %% "zio-test-sbt" % "2.1.17" % Test,
  "org.specs2" %% "specs2-core" % "5.6.2" % Test,
  "org.specs2" %% "specs2-html" % "5.6.2" % Test


)
dependencyCheckAssemblyAnalyzerEnabled := Option(false)
(Test / testOptions) += Tests.Argument(TestFrameworks.Specs2, "html")
//(Test / testOptions) += Tests.Argument(TestFrameworks.Specs2,"markdown")
//(Test / testOptions) += Tests.Argument(TestFrameworks.Specs2,"markdown.outdir","c:\\temp")
name := "zio exp"
