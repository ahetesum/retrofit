package ali.com.retrofit.tutorial2

import ali.com.retrofit.JsonPlaceHolderApi
import ali.com.retrofit.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_comments.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TutorialTwoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)


        var retrofit= Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonPlaceHolderApi= retrofit.create(JsonPlaceHolderApi::class.java)
        var call= jsonPlaceHolderApi.getAllComment(1)
        call.enqueue(object : Callback<List<Comment>> {
            override fun onFailure(call: Call<List<Comment>>?, t: Throwable?) {
                postTextView.text = t!!.message
            }

            override fun onResponse(call: Call<List<Comment>>?, response: Response<List<Comment>>?) {
                if (response != null && response.isSuccessful && response.body() != null) {
                    var comments = response.body()
                    for (i in comments!!.indices)
                    {
                        var postString: String = ""
                        postString= "PostId: "+ comments[i].postId+" \n"
                        postString+="ID: "+ comments[i].id+" \n"
                        postString+="Email: "+ comments[i].email+" \n"
                        postString+="Body: "+ comments[i].body+" \n\n"
                        postTextView.append(postString)
                    }

                }
            }

        })
    }
}
