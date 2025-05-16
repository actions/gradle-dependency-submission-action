buildscript {
  def getInputParam = { String name ->
      def envVarName = name.toUpperCase().replace('.', '_').replace('-', '_')
      return System.getProperty(name) ?: System.getenv(envVarName)
  }
  def pluginRepositoryUrl = getInputParam('gradle.plugin-repository.url') ?: 'https://plugins.gradle.org/m2'
  def pluginRepositoryUsername = getInputParam('gradle.plugin-repository.username')
  def pluginRepositoryPassword = getInputParam('gradle.plugin-repository.password')
  def dependencyGraphPluginVersion = getInputParam('dependency-graph-plugin.version') ?: '1.3.2'

  logger.lifecycle("Resolving dependency graph plugin")
  repositories {
    maven {
      url = "https://jitpack.io"
    }
  }
  dependencies {
    classpath "com.github.ljones140:github-dependency-graph-gradle-plugin:20d684b171"
  }
}

apply plugin: org.gradle.github.GitHubDependencyGraphPlugin
