package android.com.httptest.Http;

import android.content.Context;
import android.widget.ImageView;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * 2016/4/3.
 */
public class HttpUtils {

    /**
     * 防止工具类被实例化
     */
    public HttpUtils() {
        throw new AssertionError();
    }

    /**
     * 加载图片
     * @param context
     * @param url
     * @param imageView
     * @param defImageId
     * @param errImageId
     * @return
     */
    public static ImageContainer loadImage(Context context,String url,ImageView imageView,int defImageId,int errImageId) {
        HttpNet httpNet = HttpNet.getNet(context);
        ImageListener mImageListener = httpNet.getImageLoader().getImageListener(imageView,defImageId,errImageId);
        return httpNet.getImageLoader().get(url,mImageListener);
    }

    /**
     * 发送json请求
     * @param context
     * @param modth
     * @param url
     * @param params
     * @param listener
     * @param errorListener
     */
    public static void sendJsonRequest(Context context,int modth,String url,JSONObject params,Listener listener,ErrorListener errorListener) {
        JsonObjectRequest jsonRequest = new JsonObjectRequest(modth,url,params,listener,errorListener);
        HttpNet.getNet(context).getRequestQueue().add(jsonRequest);
    }

}
