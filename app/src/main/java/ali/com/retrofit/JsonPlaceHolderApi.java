package ali.com.retrofit;

import ali.com.retrofit.tutorial1.Post;
import ali.com.retrofit.tutorial2.Comment;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

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

    @GET("posts/{id}/comments")
    Call<List<Comment>> getAllComment(@Path("id") int postId);
}
