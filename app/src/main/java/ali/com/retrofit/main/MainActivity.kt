package ali.com.retrofit.main

import ali.com.retrofit.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var tutorialList= arrayOf("Tutorial One","Tutorial Two","Tutorial Three","Tutorial Four","Tutorial Five","Tutorial Six")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemArrayAdapter = TutorialAdapter(this,tutorialList)
        tutorialRecyclerView.layoutManager = LinearLayoutManager(this)
        tutorialRecyclerView.itemAnimator = DefaultItemAnimator()
        tutorialRecyclerView.adapter = itemArrayAdapter
    }
}
