package ali.com.retrofit.tutorial6

import ali.com.retrofit.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TutorialSixActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_six)

        if(intent.hasExtra("TITLE"))
        {
            TutorialSixActivity@ this.title = intent.getStringExtra("TITLE")
        }
    }
}
