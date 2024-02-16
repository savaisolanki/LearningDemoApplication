package com.example.learningdemoapplication.activity.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.learningdemoapplication.R
import com.example.learningdemoapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /*
        //Manual
        //private lateinit var baseApp: BaseApp

        //Using Hilt Framework
        @Inject
        lateinit var camera: Camera

        @Inject
        lateinit var main: InterfaceOneMain

        @Inject
        lateinit var qualifierClass: QualifierClass


    */

    private lateinit var binding: ActivityMainBinding


    private var navHostFragment: NavHostFragment? = null
    private var navController: NavController? = null

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        navController = navHostFragment?.navController

        /*

        //Manual

         baseApp = BaseApp()
         baseApp.bike.getBikeInfo()
         baseApp.getDataDownload()
         baseApp.interfaceData.mainData()

        */

        /*
          //Using Hilt Framework

            camera.getFunctionality()
            main.mainData()
            qualifierClass.getData()

         */
    }


    companion object {
        val FName = "Savai"
        val Lname = "Solanki"
    }


}

