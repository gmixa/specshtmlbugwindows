ThisBuild / crossScalaVersions := Seq("3.6.4")
ThisBuild / scalaVersion := crossScalaVersions.value.head
ThisBuild / githubWorkflowOSes := Seq("ubuntu-latest","windows-latest")
ThisBuild / githubWorkflowJavaVersions += JavaSpec.temurin("21")
ThisBuild / githubWorkflowJavaVersions -= JavaSpec.zulu("8")
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "5.6.2" % Test,
  "org.specs2" %% "specs2-html" % "5.6.2" % Test)
dependencyCheckAssemblyAnalyzerEnabled := Option(false)
(Test / testOptions) += Tests.Argument(TestFrameworks.Specs2, "html")
name := "zio exp"
