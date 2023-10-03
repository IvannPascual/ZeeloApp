package com.common.data.featureflags

/**
 * For this test we simulate that we have this hardcoded in local.
 * The correct form is to provide a better implementation of this feauture flags
 * to be consumed from the cloud
 */
class FeatureFlagsRepository {

    val simulateGetBooksApiIsNotAvailable = false

}