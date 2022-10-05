package com.example.navigation_drawer_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.size
import com.example.navigation_drawer_homework.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()


    }

    private fun listeners() {
        val drawerLayout = binding.drawerLayout
        val header = binding.navigationView.getHeaderView(0)
        val toggleButtonGroup = header.findViewById<RadioGroup>(R.id.toggle)
        binding.apply {
//            imageMenu.setOnClickListener {
//                drawerLayout.openDrawer(GravityCompat.START)
//            }
            toggleButtonGroup.setOnCheckedChangeListener{ _, checkedID ->
                val checkedButton = toggleButtonGroup.findViewById<RadioButton>(checkedID)
                checkedButton.setTextColor(ContextCompat.getColor(this@MainActivity, R.color.white))
                for(i in 0 until toggleButtonGroup.size){
                    val currentChildID = toggleButtonGroup.getChildAt(i).id
                    if(currentChildID!=checkedID){
                        toggleButtonGroup.findViewById<RadioButton>(currentChildID).setTextColor(ContextCompat.getColor(this@MainActivity, R.color.black))
                    }
                }
            }
        }
    }
}