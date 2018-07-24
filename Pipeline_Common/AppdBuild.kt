package Pipeline_Common

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import Pipeline_Common.vcsRoots.Pipeline_Common_github

open class AppdBuild() : Project() {
    init {
        id("myProject3")
        parentId("_Root")
        name = "My Project 3"

        //vcsRoot(Pipeline_Common_github)

        buildType(SayHello)
        buildType(Clean)
    }
}

object SayHello : BuildType({
    name = "SayHello"
    artifactRules = "hello.txt"
    steps {
        script {
            name = "say hello"
            scriptContent = """echo "Hello World" > hello.txt"""
        }
    }
})

object Clean : BuildType({
    name = "clean"

    steps {
        script {
            name = "clean"
            scriptContent = """echo "clean""""
        }
    }
    dependencies {
        artifacts(SayHello) {
            buildRule = lastSuccessful()
            artifactRules = "hello.txt"
        }
    }
})