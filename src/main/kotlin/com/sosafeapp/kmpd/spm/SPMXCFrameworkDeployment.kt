package com.sosafeapp.kmpd.spm

import com.sosafeapp.kmpd.HttpStorageDeployment

sealed class SPMXCFrameworkDeployment {
    class GitDeployment : SPMXCFrameworkDeployment()
    data class HttpDeployment(
        val deployment: HttpStorageDeployment
    ) : SPMXCFrameworkDeployment()
}