package com.lush_digital_.graphqlexample.ui

import com.apollographql.apollo.ApolloClient
import com.lush.retrofit.soa.service.ApolloApiClient
import org.koin.core.KoinComponent


class CharacterRepo: KoinComponent {

    //Below is the call to handle a RX response
    internal fun loadCharacters(): ApolloClient? {

        return  ApolloApiClient.getClient()
    }
}