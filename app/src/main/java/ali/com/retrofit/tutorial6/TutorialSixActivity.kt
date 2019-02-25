package ali.com.retrofit.tutorial6

import ali.com.retrofit.JsonPlaceHolderApi
import ali.com.retrofit.R
import ali.com.retrofit.models.Post
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tutorial_six.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TutorialSixActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_six)

        if(intent.hasExtra("TITLE"))
        {
            TutorialSixActivity@ this.title = intent.getStringExtra("TITLE")
        }

        var retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)


        var call = jsonPlaceHolderApi.createPost(4,"Greetings","Hello sir how are you")
        call.enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                feildPostTextView.text = t!!.message
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    var post = response.body()

                    var postString = "";
                    postString = "UserId: " + post!!.userId + " \n"
                    postString += "ID: " + post.id + " \n"
                    postString += "Title: " + post.title + " \n"
                    postString += "Body: " + post.body + " \n\n"
                    feildPostTextView.append(postString)

                }
            }

        })
    }
}
