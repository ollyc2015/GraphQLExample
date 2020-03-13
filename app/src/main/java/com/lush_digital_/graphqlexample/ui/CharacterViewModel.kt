package com.lush_digital_.graphqlexample.ui

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.FeedResultQuery


class CharacterViewModel : ViewModel() {

    private var characterRepo: CharacterRepo = CharacterRepo()
    private var myGraphQLResponse: MutableLiveData<FeedResultQuery.Data>? = null
    private var errorResponse: MutableLiveData<String>? = null

    fun responseData(): MutableLiveData<FeedResultQuery.Data>? {
        if (myGraphQLResponse == null) {
            myGraphQLResponse = MutableLiveData()

        }
        return myGraphQLResponse
    }

    fun errorResponse(): MutableLiveData<String>? {

        if (errorResponse == null) {
            errorResponse = MutableLiveData()

        }
        return errorResponse
    }


    @SuppressLint("CheckResult")
    fun getGraphQLRickAndMortyCharacters() {

        val query = FeedResultQuery()

        characterRepo.loadCharacters()
            ?.query(query)?.enqueue(object : ApolloCall.Callback<FeedResultQuery.Data>() {
                override fun onResponse(response: Response<FeedResultQuery.Data>) {

                    val data = response.data()

                    if (data == null) {

                        errorResponse?.postValue("No data received: ${response.errors()}")

                    } else {
                        myGraphQLResponse?.postValue(data)

                    }
                }

                override fun onFailure(e: ApolloException) {

                    errorResponse?.postValue("Error: ${e.message.toString()}")
                }
            })

    }
}
