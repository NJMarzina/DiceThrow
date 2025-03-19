package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.rollDiceButton).setOnClickListener {
            // Access the DieFragment and call throwDie() method
            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView) as DieFragment).throwDie()
            (supportFragmentManager
                .findFragmentById(R.id.fragmentContainerView2) as DieFragment).throwDie()
        }
    }
}
