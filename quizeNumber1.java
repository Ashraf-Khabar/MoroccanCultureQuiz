package com.example.myquizapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.os.Handler;
import android.security.identity.IdentityCredentialException;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class quizeNumber1 extends AppCompatActivity implements View.OnClickListener{

    private TextView txtQuestion , txtNbrQuestions ;
    private Button option1 , option2 , option3 , option4 ;
    private List<questions> questionList ;
    private ImageView imgQuestion;
    int questionNum ;
    private int score ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize_number1);

        txtQuestion = findViewById(R.id.txtQuestion) ;
        txtNbrQuestions = findViewById(R.id.txtnbrQuestions) ;

        option1 = findViewById(R.id.option1) ;
        option2 = findViewById(R.id.option2) ;
        option3 = findViewById(R.id.option3) ;
        option4 = findViewById(R.id.option4) ;

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        getQuestionList () ;
    }

    private void getQuestionList ()
    {
        questionList = new ArrayList<>() ;
        questionList.add(new questions(1 , "القفطان لباس مغربي :" , 2,  "مريني" , "سعدي" , "موحدي" , "مرابطي" , 3));
        questionList.add(new questions(2 , "ينتمي طارق ابن زياد لقبيلة :" , 3 , "نفزاوة" , "خنشلة" , "لواتة" , "نفزة" , 4));
        questionList.add(new questions(3 , "متى تاسس المغرب :" , 9, "788" , "790" , "787" , "776" , 1));
        questionList.add(new questions(4 , "مؤسس الدولة الموحدية :" , 4 , "يوسف ابن تاشفين" , "محمد على الكومي", "محمد بن تومرت", "عبد الله ابن ياسين" , 3 )) ;
        questionList.add(new questions(5 ,  "أول عاصمة للمرابطين:" , 6 ,   "اغمات", "مراكش","تارودانت", "فاس", 1)) ;
        questionList.add(new questions(6 , "كلمة \" مراكش \" تعني :", 6 ,"الارض المقدسة","ارض المور","ارض الله" ,"ارض الموحدين",3)) ;
        questionList.add(new questions(7 , "\" تهافت التهافت \"كتاب ل :", 6 ,"ابي حامد الغزالي","محمد إبن رشد","محيي الدين تبن عربي","عبد الرحمن ابن خلدون",2)) ;
        questionList.add(new questions(8 , " متى بنيت جامعة القرويين :", 6 ,"859","855","896" ,"890",1)) ;
        questionList.add(new questions(9 , "برغواطة امارة امازيغية في منطقة :", 6 ,"سوس","تلمسان","جبال الاطلس الصغير" ,"اسفي و ازمور",4)) ;
        questionList.add(new questions(10 , "ينحدر مؤسس الدولة المرابطية عبد الله إبن ياسين من قبائل :", 6 ,"الطوارق","سوس","الريف" ,"صنهاجة",2)) ;
        setQuestion () ;
    }

    private void setQuestion ()
    {
        txtQuestion.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOption1());
        option2.setText(questionList.get(0).getOption2());
        option3.setText(questionList.get(0).getOption3());
        option4.setText(questionList.get(0).getOption4());

        txtNbrQuestions.setText(String.valueOf(1) + "/" + String.valueOf(questionList));
        questionNum = 0 ;
    }


    @Override
    public void onClick(View v) {

        int selectedOption = 0 ;
        switch (v.getId())
        {
            case R.id.option1:
                selectedOption = 1 ;
                break;
            case R.id.option2 :
                selectedOption = 2 ;
                break;
            case R.id.option3 :
                selectedOption = 3 ;
                break;
            case R.id.option4 :
                selectedOption = 4 ;
                break;
            default:
        }

        checkAnswer (selectedOption , v) ;
    }


    private void checkAnswer (int selectedOption , View view)
    {
        if ( selectedOption == questionList.get(questionNum).getCorrectAnswer())
        {
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score++ ;
        }
        else
        {
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            
            switch (questionList.get(questionNum).getCorrectAnswer())
            {
                case 1 :
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2 :
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3 :
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4 :
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }

        Handler handler = new Handler() ;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion () ;
            }
        }, 800 ) ;

    }

    private void changeQuestion ()
    {
        if (questionNum < questionList.size() - 1 )
        {

            questionNum ++ ;

            playAnimation(txtQuestion , 0 , 0);
            playAnimation (option1 , 0 , 1 );
            playAnimation (option2 , 0 , 2 );
            playAnimation (option3 , 0 , 3 );
            playAnimation (option4 , 0 , 4 );

            txtNbrQuestions.setText(String.valueOf(questionNum + 1 ) + "/" + String.valueOf(questionList.size()));
        }
        else
        {
            // go to score activity
            Intent intent = new Intent( quizeNumber1.this , scoreActivity.class ) ;
            intent.putExtra("الحصيلة", String.valueOf(score) + "/" + String.valueOf(questionList.size()));
            startActivity(intent);
            quizeNumber1.this.finish();
        }
    }

    private void playAnimation (View view , final int value , int viewNUm)
    {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500)
                .setStartDelay(100).setInterpolator(new DecelerateInterpolator())
                .setListener(new AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                            if ( value == 0 )
                            {
                                switch ( viewNUm )
                                {
                                    case 0 :
                                        ((TextView)view).setText(questionList.get(questionNum).getQuestion());
                                        break;
                                    case 1 :
                                        ((Button)view).setText(questionList.get(questionNum).getOption1());
                                        break;
                                    case 2 :
                                        ((Button)view).setText(questionList.get(questionNum).getOption2());
                                        break;
                                    case 3 :
                                        ((Button)view).setText(questionList.get(questionNum).getOption3());
                                        break;
                                    case 4 :
                                        ((Button)view).setText(questionList.get(questionNum).getOption4());
                                        break;
                                }

                                if (viewNUm != 0 )
                                {
                                    ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FDB913")));
                                }

                                playAnimation(view , 1 ,viewNUm );
                            }
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
    }
}