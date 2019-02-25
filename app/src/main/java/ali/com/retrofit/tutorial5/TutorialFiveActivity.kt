package ali.com.retrofit.tutorial5

import ali.com.retrofit.JsonPlaceHolderApi
import ali.com.retrofit.R
import ali.com.retrofit.tutorial1.Post
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_tutorial_five.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TutorialFiveActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_five)

        if(intent.hasExtra("TITLE"))
        {
            TutorialFiveActivity@ this.title = intent.getStringExtra("TITLE")
        }

        var retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        var post= Post()
        post.userId=3
        post.body="Hello sir how are you"
        post.title="Greetings"

        var call = jsonPlaceHolderApi.createPost(post)
        call.enqueue(object : Callback<Post> {
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                createPostTextView.text = t!!.message
            }

            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    var post = response.body()

                    var postString = "";
                    postString = "UserId: " + post!!.userId + " \n"
                    postString += "ID: " + post.id + " \n"
                    postString += "Title: " + post.title + " \n"
                    postString += "Body: " + post.body + " \n\n"
                    createPostTextView.append(postString)

                }
            }

        })
    }
}
