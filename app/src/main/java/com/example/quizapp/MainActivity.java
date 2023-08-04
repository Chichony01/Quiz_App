package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] ques= {"A male canary tends to have a better singing voice than a female canary?",
                        "The first country in the world to use postcards was the United States of America?"," Tea contains more caffeine than coffee and soda?",
                        "Mice have less bones than humans?","The first product with a bar code was chewing gum?","AB- is the rarest type of blood in humans?"};

     boolean[] ans = {true,false,false,false,true,true};

    private int score=0;
    Button yes,no;
    TextView question;

    private int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question= findViewById(R.id.question);

        //placing question in text view
        question.setText(ques[index]);

        // setting button algorithm
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index<=ques.length-1){
                    if(ans[index]== true){
                        score++;
                    }
                    index++;
                    if(index<ques.length-1){
                        question.setText(ques[index]);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Your score is "+ score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index< ques.length-1){
                    if(ans[index] == false){
                        score++;
                    }
                    index++;
                    if(index<=ques.length-1){
                        question.setText(ques[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is "+ score, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        }

        );
    }
}