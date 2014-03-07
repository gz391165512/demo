package com.demo.view;

import android.app.Activity;
import android.os.Bundle;
import com.demo.R;
import com.demo.util.http.GetUtil;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GetUtil.test();
//        String s = "";
//        try {
//            s = HttpUtil.getJsonPassGet("http://101.230.8.67:8800/winona//common/validatecode/create");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.v("gz",s);
    }
}
