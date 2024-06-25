package softsuave.tech_matrix.api

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST

internal interface EmojiDetectionService {

    @POST("request?ime=handwriting&app=mobilesearch&cs=1&oe=UTF-8")
    fun detect(@Body body: EmojiDetectionRequest): Single<ResponseBody>

}