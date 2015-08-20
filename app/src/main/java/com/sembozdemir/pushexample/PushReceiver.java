package com.sembozdemir.pushexample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by semih on 8/20/15.
 */
public class PushReceiver extends ParsePushBroadcastReceiver {

    @Override
    protected void onPushOpen(Context context, Intent intent) {
        super.onPushOpen(context, intent);
        // Kullanıcı push notification a bastığında yapılacaklar (Default olarak MainActivity açılır.)
        // Örnek olması açısından toast gösterildi.
        try {
            // Parse'dan push json formatında geliyor aşağıdaki kodla msg ı ayıklayabiliriz.
            JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
            String msg = json.getString("alert");
            Log.d("PushReceiver", "Push message: " + msg);
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

        }catch (JSONException e){
            Log.e("PushReceiver", e.getMessage());
        }
    }
}
