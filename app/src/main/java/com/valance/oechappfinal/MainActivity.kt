package com.valance.oechappfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.valance.oechappfinal.databinding.ActivityMainBinding
import com.valance.oechappfinal.fragments.StartFragment
import io.github.jan.supabase.SupabaseClient

class MainActivity : AppCompatActivity() {
    private lateinit var supabaseClient: SupabaseClient
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideSystemUI()
        supportFragmentManager.beginTransaction()
            .replace(R.id.my_nav_host_fragment, StartFragment())
            .commit()
        val myApplication = application as MyApp
        supabaseClient = myApplication.supabaseClient

    }


    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, binding.root).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}