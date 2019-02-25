package ali.com.retrofit;

import ali.com.retrofit.tutorial1.Post;
import ali.com.retrofit.tutorial2.Comment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

import java.util.List;
import java.util.Map;

public interface JsonPlaceHolderApi
{
    @GET("posts")
    Call<List<Post>> getAllPost();

    @GET("posts")
    Call<List<Post>> getPosts(
            @Query("userId")int userId,
            @Query("_sort")String sort,
            @Query("_order")String order
    );

    @GET("posts")
    Call<List<Post>> getPosts(@QueryMap Map<String,String> parameters);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getAllComment(@Path("id") int postId);
}
