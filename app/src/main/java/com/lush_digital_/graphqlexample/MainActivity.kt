package com.lush_digital_.graphqlexample

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.lush_digital_.graphqlexample.ui.CharacterFragment


class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    CharacterFragment.newInstance()
                )
                .commitNow()
        }
    }
}
