package com.sosafeapp.kmpd

sealed class CommitishSource {
    class RemoteHEAD: CommitishSource()
    data class SpecificCommitish(val value: String) : CommitishSource()
}