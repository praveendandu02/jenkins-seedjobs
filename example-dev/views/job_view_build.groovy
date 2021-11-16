listView('Build') {
    description('Below are all the standard docker builds for dev')
    jobs {
        regex("^build.*")
        recurse()
    }
    columns{
        status()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}