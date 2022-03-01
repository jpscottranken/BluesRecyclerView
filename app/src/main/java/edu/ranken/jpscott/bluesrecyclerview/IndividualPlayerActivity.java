package edu.ranken.jpscott.bluesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IndividualPlayerActivity extends AppCompatActivity {
    TextView  tvName;
    TextView  tvNumber;
    TextView  tvPosition;
    ImageView ivImage;
    Button btnMainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_player);
        String theName      = getIntent().getStringExtra("NAME");
        String theNumber    = getIntent().getStringExtra("NUMBER");
        String thePosition  = getIntent().getStringExtra("POSITION");
        int    theImage     = getIntent().getIntExtra("IMAGE", 0);

        //  Get references to widgets above
        tvName      = findViewById(R.id.tvIndPlayerName);
        tvNumber    = findViewById(R.id.tvIndPlayerNumber);
        tvPosition  = findViewById(R.id.tvIndPlayerPosition);
        ivImage     = findViewById(R.id.ivIndPlayerImage);
        btnMainPage = findViewById(R.id.btnMainPage);

        tvName.setText(theName);
        tvNumber.setText(theNumber);
        tvPosition.setText(thePosition);
        ivImage.setImageResource(theImage);

        btnMainPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}