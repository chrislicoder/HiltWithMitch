package com.chrislicoder.hiltwithmitch

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("the tag", someClass.doThing())
        Log.d("the tag", someClass.doSomeOtherThing())
    }
}

class SomeClass
@Inject
constructor(private val someOtherClass: SomeOtherClass) {

    fun doThing(): String {
        return "A"
    }

    fun doSomeOtherThing(): String {
        return someOtherClass.doSomeOtherThing()
    }
}

class SomeOtherClass
@Inject
constructor() {
    fun doSomeOtherThing(): String {
        return "B"
    }
}
