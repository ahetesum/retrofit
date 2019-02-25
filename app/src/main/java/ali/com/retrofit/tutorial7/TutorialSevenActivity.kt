package ali.com.retrofit.tutorial7

import ali.com.retrofit.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TutorialSevenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_seven)
        if(intent.hasExtra("TITLE"))
        {
            TutorialSevenActivity@ this.title = intent.getStringExtra("TITLE")
        }
    }
}
