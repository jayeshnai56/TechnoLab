package com.lattitudetech.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lattitudetech.api.NetworkResult
import com.lattitudetech.model.User
import com.lattitudetech.repository.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelUserFetch @Inject constructor(
    private val repository: UserRepo,
    application: Application
) : AndroidViewModel(application) {

    private val _responseUser: MutableLiveData<NetworkResult<List<User>>> = MutableLiveData()
    val responseUser: LiveData<NetworkResult<List<User>>> = _responseUser

    fun fetchUser() = viewModelScope.launch {
        repository.getUser().collect { value: NetworkResult<List<User>> ->
            run {
                _responseUser.value = value
            }
        }
    }
}