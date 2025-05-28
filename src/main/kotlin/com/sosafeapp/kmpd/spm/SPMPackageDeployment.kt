package com.sosafeapp.kmpd.spm

sealed class SPMPackageDeployment {
    data class GitDeployment(val repository: String) : SPMPackageDeployment()
}