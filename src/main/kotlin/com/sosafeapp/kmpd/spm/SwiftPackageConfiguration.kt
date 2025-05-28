package com.sosafeapp.kmpd.spm

import com.sosafeapp.kmpd.Version


data class SwiftPackageConfiguration(
    val packageDeployment: SPMPackageDeployment,
    val version: Version = Version.UsePatchTimestamp(),
    val packageName: SwiftPackageName = SwiftPackageName.FromProjectName(),
)