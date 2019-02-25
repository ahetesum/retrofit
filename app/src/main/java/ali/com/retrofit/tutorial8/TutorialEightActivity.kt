package ali.com.retrofit.tutorial8

import ali.com.retrofit.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TutorialEightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_eight)

        if(intent.hasExtra("TITLE"))
        {
            TutorialEightActivity@ this.title = intent.getStringExtra("TITLE")
        }
    }
}
