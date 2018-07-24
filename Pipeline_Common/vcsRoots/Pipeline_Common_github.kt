package Pipeline_Common.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Pipeline_Common_github : GitVcsRoot({
    uuid = "1f05a729-831d-4604-adc6-c9c44f3af16f"
    name = "https://github.com/siddeshbg/temp-tc3-project3"
    url = "https://github.com/siddeshbg/temp-tc3-project3"

    authMethod = password {
        userName = "siddeshbg"
        password = "credentialsJSON:8ee37528-4db6-407c-a2e2-c48e51c8f566"
    }
    param("teamcity:vcsResourceDiscovery:versionedSettingsRoot", "true")
})