package com.spannabledemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private SpannableStringBuilder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        builder = new SpannableStringBuilder();
    }

    public void handleClick(View view){
        span();
    }

    private void span(){
        builder.clear();

        int perLength1 = builder.length();
        String row1 = "李白乘舟将欲行";
        builder.append(row1);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        builder.setSpan(colorSpan, perLength1, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        builder.append("\n");
        builder.append("\n");

        int perLength2 = builder.length();
        final String row2 = "忽闻岸上踏歌声";
        builder.append(row2);
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#ff0000"));
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View view) {
                ((TextView)view).setHighlightColor(Color.parseColor("#a0a0a0"));
                Toast.makeText(MainActivity.this, row2, Toast.LENGTH_SHORT).show();
            }
        };
        builder.setSpan(clickableSpan2, perLength2, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        builder.append("\n");
        builder.append("\n");

        String row3 = "桃花潭水深千尺";
        builder.append(row3);

        builder.append("\n");
        builder.append("\n");

        int perLength4 = builder.length();
        final String row4 = "不及汪伦送我情";
        builder.append(row4);
        ClickableSpan clickableSpan4 = new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.parseColor("#009ad6"));
                ds.setUnderlineText(false);
            }

            @Override
            public void onClick(View view) {
                ((TextView)view).setHighlightColor(Color.parseColor("#a0a0a0"));
                Toast.makeText(MainActivity.this, row4, Toast.LENGTH_SHORT).show();
            }
        };
        builder.setSpan(clickableSpan4, perLength4, builder.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(builder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }

}
