package com.mima.testndk;

import androidx.appcompat.app.AppCompatActivity;
//import com.sun.jna.Library;
//import com.sun.jna.Pointer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.mima.testndk.databinding.ActivityMainBinding;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'testndk' library on application startup.
//    static {
//        System.loadLibrary("testndk");
//    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;

        int c = NdkDemo.INSTANCE.testInt(3, 4);
        String test = NdkDemo.INSTANCE.getString("java  ");
        tv.setText(test);
        Log.e("ard", "JNA返回：" + c+" getString  返回值：：："+test);

    }

    /**
     * A native method that is implemented by the 'testndk' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();

    interface NdkDemo extends Library {
        NdkDemo INSTANCE = (NdkDemo) Native.loadLibrary("testndk", NdkDemo.class);

        int testInt(int a, int b);

        String getString(String pre);


    }

}