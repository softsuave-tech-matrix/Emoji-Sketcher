package softsuave.tech_matrix.draw_emoji_get_emoji.api

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import softsuave.tech_matrix.draw_emoji_get_emoji.api.EmojiDetectionRequest

interface EmojiDetectionService {

    @POST("request?ime=handwriting&app=mobilesearch&cs=1&oe=UTF-8")
    fun detect(@Body body: EmojiDetectionRequest): Single<ResponseBody>

}