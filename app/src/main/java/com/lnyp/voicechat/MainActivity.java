package com.lnyp.voicechat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imgUserHead;

    private ImageView imgBg;

    private int scaleRatio = 5;

    private int blurRadius = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgUserHead = (ImageView) findViewById(R.id.imgUserHead);
        imgBg = (ImageView) findViewById(R.id.imgBg);

        LinearLayout layoutGuaDuan = (LinearLayout) findViewById(R.id.layoutGuaDuan);
        LinearLayout layoutMianTi = (LinearLayout) findViewById(R.id.layoutMianTi);

        layoutGuaDuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgUserHead.setImageResource(R.drawable.header1);

                Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.header1);

                Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap,
                        mBitmap.getWidth() / scaleRatio,
                        mBitmap.getHeight() / scaleRatio,
                        false);
                Bitmap blurBitmap = FastBlur.doBlur(scaledBitmap, blurRadius, true);

                imgBg.setImageBitmap(blurBitmap);

            }
        });

        layoutMianTi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgUserHead.setImageResource(R.drawable.header2);

                Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.header2);

                Bitmap scaledBitmap = Bitmap.createScaledBitmap(mBitmap,
                        mBitmap.getWidth() / scaleRatio,
                        mBitmap.getHeight() / scaleRatio,
                        false);
                Bitmap blurBitmap = FastBlur.doBlur(scaledBitmap, blurRadius, true);

                imgBg.setImageBitmap(blurBitmap);
            }
        });
    }
}
