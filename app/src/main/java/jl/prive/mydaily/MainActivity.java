package jl.prive.mydaily;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import jl.prive.mydaily.Activity.PersonalInfoActivity;

public class MainActivity extends Activity {

    private ImageView mImageView;
    public String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "onCreate");
        mImageView = (ImageView) findViewById(R.id.image);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "image");
//                mImageView.setImageResource(R.drawable.rating_half);
                // 这里进入资料编辑界面
                startActivity(new Intent(MainActivity.this, PersonalInfoActivity.class));
            }
        });
        findViewById(R.id.hehe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "hehe");
            }
        });
    }


    @Override
    protected void onPause() {
        Log.e(TAG, "onPause");
        super.onPause();

    }

    @Override
    protected void onRestart() {
        Log.e(TAG, "onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, "onStop");
        super.onStop();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e(TAG, "onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }
}
