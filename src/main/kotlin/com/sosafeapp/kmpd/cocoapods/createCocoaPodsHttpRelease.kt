package com.sosafeapp.kmpd.cocoapods

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import com.sosafeapp.kmpd.Version
import com.sosafeapp.kmpd.deployments.deployFile
import java.io.File
import java.nio.file.Path
import kotlin.io.path.writeText

fun createCocoaPodsHttpRelease(
    podspecDeployment: CocoaPodsSpecDeployment.HttpDeployment,
    deployedXCFramework: String,
    kgpProducedPodspec: File,
    podspecName: String,
    temp: Path,
    time: Long,
    version: Version,
) {
    val finalPodspecJson = preparePodspecJsonWithHttpSource(kgpProducedPodspec, deployedXCFramework, version)

    val fileName = "${podspecName}-${time}.podspec.json"
    val podspecToUpload = temp.resolve(fileName)
    podspecToUpload.writeText(Json{ prettyPrint = true }.encodeToString(finalPodspecJson))

    deployFile(
        deployment = podspecDeployment.deployment,
        deployedFileName = fileName,
        file = podspecToUpload.toFile(),
        time = time,
    )
}

