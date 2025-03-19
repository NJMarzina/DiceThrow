package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.random.Random

class DieFragment : Fragment() {

    val DIESIDE = "sidenumber"

    var prev = "prev1"
    var prev2 = "prev2"

    var currentRoll1 = 0
    var currentRoll2 = 0

    lateinit var dieTextView1: TextView
    lateinit var dieTextView2: TextView

    var dieSides: Int = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView1 = findViewById(R.id.dieTextView1)
            dieTextView2 = findViewById(R.id.dieTextView2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(savedInstanceState == null)
            throwDie()
        else {
            currentRoll1 = savedInstanceState.getInt(prev)
            currentRoll2 = savedInstanceState.getInt(prev2)
            dieTextView1.text = currentRoll1.toString()
            dieTextView2.text = currentRoll2.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(prev, currentRoll1)
        outState.putInt(prev2, currentRoll2)
    }

    fun throwDie() {
        currentRoll1 = (Random.nextInt(dieSides) + 1)
        currentRoll2 = (Random.nextInt(dieSides) + 1)
        dieTextView1.text = currentRoll1.toString()
        dieTextView2.text = currentRoll2.toString()
    }
}
