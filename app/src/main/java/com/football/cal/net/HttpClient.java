package com.football.cal.net;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.football.cal.model.Data;

public class HttpClient {

    private static final String URL = "http://princesshair.space/ver3.json";

    private Context mContext;

    public HttpClient(Context context) {
        mContext = context;
    }

    public void request(Listener listener) {
        RequestQueue queue = Volley.newRequestQueue(mContext);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                response -> listener.onResponse(Data.parse(response)),
                error -> listener.onResponse(null));

        queue.add(stringRequest);
    }

}
