package unsw.Infs3634.Mydegree;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomepageActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        appBarTxt.setText("Home");

        ImageButton buttonlearn = findViewById(R.id.learn_btn);
        ImageButton buttonmgmt = findViewById(R.id.mg_btn);
        Button buttoncourses = findViewById(R.id.course_btn);
        Button buttontemplete = findViewById(R.id.df_btn);


        buttonlearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

//        buttonmgmt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomepageActivity.this, VideoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        buttoncourses.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent intent = new Intent(HomeActivity.this, QuizSelectionActivity.class);
//                    startActivity(intent);
//                }
//        });

        buttontemplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, DefaultTempleteActivity.class);
                startActivity(intent);
            }
        });


    }
}
