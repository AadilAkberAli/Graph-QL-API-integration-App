package com.example.graphql

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.exception.ApolloException
import okhttp3.Response
import org.jetbrains.annotations.NotNull
import java.io.IOException
import java.net.SocketException
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private  val mainRepository: MainRepository): ViewModel() {

    private val _resultUsers = MutableLiveData<Resource<ArrayList<GetUserListQuery.GetUsersList>>>()
    val resultUsers: LiveData<Resource<ArrayList<GetUserListQuery.GetUsersList>>> = _resultUsers
    fun getUsers()
    {

        mainRepository.getUserList()?.enqueue(object : ApolloCall.Callback<GetUserListQuery.Data>() {
            override fun onFailure(error: ApolloException) {
                _resultUsers.postValue(Resource.Error(errorMessage = error.message.toString()))
            }

            override fun onResponse(@NotNull response: com.apollographql.apollo.api.Response<GetUserListQuery.Data>) {
                // Changing UI must be on UI thread
                Log.d("Todo", response.data.toString())
                _resultUsers.postValue(Resource.Success(data = response.data?.getUsersList  as ArrayList<GetUserListQuery.GetUsersList>))
            }
        })
    }


}