package org.hyperskill.projectname

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


var counter1 = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val button1 = Button(this).apply {
            id = R.id.button1
            text = "button1"
            setOnClickListener {
                counter1++
                showToast("$counter1")
            }
        }

        val button2 = Button(this).apply {
            id = R.id.button2
            text = "button2"
            setOnClickListener {
                State.counter2++
                showToast("${State.counter2}")
            }
        }

        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL

            addView(button1)
            addView(button2)
        }

        setContentView(linearLayout)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

object State {
    var counter2 = 0
}