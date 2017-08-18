package com.example.haein.grandir;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU=102;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(), "onActivityResult 메소드 호출됨. " +
                    "요청 코드 : "+requestCode+", 결과코드 : "+ resultCode,Toast.LENGTH_LONG).show();

            if(requestCode == RESULT_OK){

                String name = data.getExtras().getString("name");
                Toast.makeText(getApplicationContext(),"응답으로 전달된 name : "+name,Toast.LENGTH_LONG).show();
            }
        }}//카메라로 가기 위한 소스

    public void CameraView(View V){

        Intent intent=new Intent(getApplicationContext(), CameraActivity.class);
        startActivityForResult(intent,REQUEST_CODE_MENU);
    }//촬명버튼 이벤트


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "mike");
                setResult(RESULT_OK, intent);


                finish();

            }
        });}//메인메뉴로 돌아가기 위한 소스

}