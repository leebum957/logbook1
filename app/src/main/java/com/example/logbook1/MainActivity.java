package com.example.logbook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    Button back_btn;
    Button forward_btn;
    ArrayList<String> imageList;

    int currentImage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.imageView);
        back_btn = findViewById(R.id.prevBtn);
        forward_btn = findViewById(R.id.nextBtn);


        imageList = new ArrayList<String>();
        imageList.add("https://wikiceleb.net/wp-content/uploads/2022/04/ngoai-hinh-cua-zoro.jpg");
        imageList.add("https://image.winudf.com/v2/image/Y29tLmJhbGVmb290Lk1vbmtleURMdWZmeVdhbGxwYXBlcl9zY3JlZW5fMF8xNTI0NTE5MTEwXzAyOA/screen-0.jpg?fakeurl=1&type=.webp");
        imageList.add("https://gamek.mediacdn.vn/133514250583805952/2022/5/18/photo-1-16528608926331302726659.jpg");
        imageList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTC52Qb5GJXhY2l68Pc15aiV_wO22KHNOaUBg&usqp=CAU");


    }

    private void loadImage() {
        Glide.with(MainActivity.this)
                .load(imageList.get(currentImage))
                .centerCrop()
                .into(imageView);
    }

    public void Forward(View view) {
        currentImage++;
        if (currentImage <= imageList.size() - 1) {
            loadImage();
        } else
            currentImage = imageList.size() - 1;
    }

    public void Backward(View view) {
        currentImage--;
        if (currentImage >=  0) {
            loadImage();
        } else
            currentImage = 0;
    }
}