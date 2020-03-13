package com.android.dependency_inject


import android.content.Context
import com.lush.retrofit.soa.service.ApolloApiClient
import com.lush_digital_.graphqlexample.ui.CharacterRepo
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module


/**
 * Base class for dependency injection
 *
 * @author Olly Curtis
 */

object DependencyInjectionHelper : KoinComponent {

    fun startKoin(context: Context) {
        startKoin {
            androidLogger()
            androidContext(context)
            modules(
                    getRepoModules()
            )
        }
    }


    private fun getRepoModules(): Module {
        return module {
            single { CharacterRepo() }
        }
    }
}

