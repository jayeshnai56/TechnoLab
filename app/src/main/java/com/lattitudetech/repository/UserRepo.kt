package com.lattitudetech.repository

import com.lattitudetech.api.BaseApiResponse
import com.lattitudetech.api.NetworkResult
import com.lattitudetech.api.RemoteDataSource
import com.lattitudetech.model.User
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class UserRepo @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : BaseApiResponse() {

    suspend fun getUser(): Flow<NetworkResult<List<User>>> {
        return flow {
            emit(safeApiCall {
                remoteDataSource.getUsers()
            })
        }.flowOn(Dispatchers.IO)
    }
}