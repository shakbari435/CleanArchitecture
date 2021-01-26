package com.shakbari.clean.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.shakbari.clean.base.common.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import androidx.lifecycle.liveData
import com.shakbari.clean.ui.repository.MainRepository


class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) : ViewModel() {

    fun getLiveDataUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

    fun getFlowUsers() = flow {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}