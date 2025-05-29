package com.sosafeapp.kmpd

sealed class HttpStorageDeployment {
    class GithubMavenPackage(
        val token: String,
        val username: String,
        val repository: String,
        val packagePath: List<String> = listOf("publication", "files", "all"),
        val requestTimeOutInMillis: Long = 600_000, // 10 minutes
    ) : HttpStorageDeployment()

    class GithubReleases(
        val token: String,
        val username: String,
        val repository: String,
        val targetCommitish: CommitishSource = CommitishSource.RemoteHEAD(),
    ) : HttpStorageDeployment()

    class Upload(
        val username: String,
        val password: String,
        val uploadDirectoryUrl: String,
    ) : HttpStorageDeployment()
}