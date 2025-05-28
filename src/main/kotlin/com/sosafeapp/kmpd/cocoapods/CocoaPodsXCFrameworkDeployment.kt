package com.sosafeapp.kmpd.cocoapods

import com.sosafeapp.kmpd.HttpStorageDeployment

sealed class CocoaPodsXCFrameworkDeployment {
    class GitDeployment : CocoaPodsXCFrameworkDeployment()

    data class HttpDeployment(
        val deployment: HttpStorageDeployment
    ) : CocoaPodsXCFrameworkDeployment()
}