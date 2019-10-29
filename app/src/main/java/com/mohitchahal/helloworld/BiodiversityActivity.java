package com.mohitchahal.helloworld;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BiodiversityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodiversity);

        TextView descriptionView = findViewById(R.id.text_description);

        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        Region region = (Region) intent.getSerializableExtra("region");
        if (region == null) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            descriptionView.setText(Html.fromHtml(region.description, Html.FROM_HTML_MODE_COMPACT));
        } else {
            descriptionView.setText(Html.fromHtml(region.description));
        }
    }
}
