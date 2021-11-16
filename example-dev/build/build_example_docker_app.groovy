//
// Job Parameters
//
String repoName = "example-docker-app"
//String prjName = "dev"
String jobName = "build-example-docker-app"
String jenkinsfileLocation = "Jenkinsfile"
String displayString = "Build example-docker-app"

// tags to come later
def values = ["toPatch", "toMinor", "toMajor"]

pipelineJob(jobName) {
    displayName(displayString)
    parameters {
        stringParam('BRANCH','main','Which branch should it build from?')
        choiceParam('AUTOINCREMENT', values, 'Which do you wish to increment?')
        // tags to come later
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url "https://github.com/praveendandu02/${repoName}.git"
                        credentials('git')
                    }
                    branch('$BRANCH')
                }
            }
            scriptPath(jenkinsfileLocation)
        }
    }
}