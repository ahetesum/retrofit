package ali.com.retrofit.tutorial3

import ali.com.retrofit.JsonPlaceHolderApi
import ali.com.retrofit.R
import ali.com.retrofit.tutorial1.Post
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tutorial_three.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TutorialThreeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_three)

        var retrofit= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonPlaceHolderApi= retrofit.create(JsonPlaceHolderApi::class.java)
        var call= jsonPlaceHolderApi.getPosts(3,"id","desc")
        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                qPostTextView.text = t!!.message
            }

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    var posts = response.body()
                    for (i in posts!!.indices)
                    {
                        var postString= "";
                        postString= "UserId: "+ posts[i].userId+" \n"
                        postString+="ID: "+ posts[i].id+" \n"
                        postString+="Title: "+ posts[i].title+" \n"
                        postString+="Body: "+ posts[i].body+" \n\n"
                        qPostTextView.append(postString)
                    }

                }
            }

        })
    }
}
