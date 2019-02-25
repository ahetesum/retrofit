package ali.com.retrofit.tutorial4

import ali.com.retrofit.JsonPlaceHolderApi
import ali.com.retrofit.R
import ali.com.retrofit.tutorial1.Post
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tutorial_four.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TutorialFourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_four)

        if(intent.hasExtra("TITLE"))
        {
            TutorialFourActivity@ this.title = intent.getStringExtra("TITLE")
        }

        var retrofit= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonPlaceHolderApi= retrofit.create(JsonPlaceHolderApi::class.java)

        var parameters= HashMap<String,String>()
        parameters.put("userId","2")
        parameters.put("sort","id")
        parameters.put("order","desc")
        var call= jsonPlaceHolderApi.getPosts(parameters)
        call.enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                mapPostTextView.text = t!!.message
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
                        mapPostTextView.append(postString)
                    }

                }
            }

        })
    }
}
