package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView AnsTxtV,Ans,NumTxtV1,NumTxtV2;

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bdiv1,bdiv2,bplus,bdiff,bmult,bwl,bclear,bdl,bequal;

    boolean iswh = false;

    int t = 0;
    float ans;

    String num1,num2;

    char op;

    public void slv(String c){

        String ans = AnsTxtV.getText().toString();

        if(ans.equals("0") || ans.equals("%") || ans.equals("/") || ans.equals("*") || ans.equals("-") || ans.equals("+")){
            AnsTxtV.setText(c);
        }else if(ans.length() < 15){
            AnsTxtV.setText(ans+c);
        }else{
            Toast.makeText(this, "15 ციფრზე მეტის შეყვანა შეუძლებელია", Toast.LENGTH_SHORT).show();
        }
    }

    public void Solve(){

    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        AnsTxtV = findViewById(R.id.AnsTxtV);

        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bdiv1 = findViewById(R.id.bdiv1);
        bdiv2 = findViewById(R.id.bdiv2);
        bplus = findViewById(R.id.bplus);
        bdiff = findViewById(R.id.bdiff);
        bmult = findViewById(R.id.bmult);
        bwl = findViewById(R.id.bwl);
        bclear = findViewById(R.id.bclear);
        bdl = findViewById(R.id.bdl);
        bequal = findViewById(R.id.bequal);
        Ans = findViewById(R.id.Ans);
        NumTxtV1 = findViewById(R.id.NumTxtV1);
        NumTxtV2 = findViewById(R.id.NumTxtV2);


        b0.setOnClickListener(v->{slv("0");});
        b1.setOnClickListener(v->{slv("1");});
        b2.setOnClickListener(v->{slv("2");});
        b3.setOnClickListener(v->{slv("3");});
        b4.setOnClickListener(v->{slv("4");});
        b5.setOnClickListener(v->{slv("5");});
        b6.setOnClickListener(v->{slv("6");});
        b7.setOnClickListener(v->{slv("7");});
        b8.setOnClickListener(v->{slv("8");});
        b9.setOnClickListener(v->{slv("9");});

        bwl.setOnClickListener(v->{
            if(!iswh) {
                String ans = AnsTxtV.getText().toString();
                if (ans.length() < 15) {
                    AnsTxtV.setText(ans + ".");
                }
                iswh = true;
            }
        });

        bdl.setOnClickListener(v->{
            String ans = AnsTxtV.getText().toString();
            if(!ans.equals("+") && !ans.equals("-") && !ans.equals("*") && !ans.equals("/") && !ans.equals("%")){
                AnsTxtV.setText(ans.substring(0,ans.length()-1));
                ans = AnsTxtV.getText().toString();
                if(ans.isEmpty()){
                    AnsTxtV.setText("0");
                }
            }
        });



        bplus.setOnClickListener(v->{bplus.setEnabled(false);op='+';String temp=AnsTxtV.getText().toString();if(!temp.equals("0")){num1=AnsTxtV.getText().toString();AnsTxtV.setText("+");iswh=false;}});
        bdiff.setOnClickListener(v->{bdiff.setEnabled(false);op='-';String temp=AnsTxtV.getText().toString();if(!temp.equals("0")){num1=AnsTxtV.getText().toString();AnsTxtV.setText("-");iswh=false;}});
        bmult.setOnClickListener(v->{bmult.setEnabled(false);op='*';String temp=AnsTxtV.getText().toString();if(!temp.equals("0")){num1=AnsTxtV.getText().toString();AnsTxtV.setText("*");iswh=false;}});
        bdiv1.setOnClickListener(v->{bdiv1.setEnabled(false);op='/';String temp=AnsTxtV.getText().toString();if(!temp.equals("0")){num1=AnsTxtV.getText().toString();AnsTxtV.setText("/");iswh=false;}});
//        bdiv2.setOnClickListener(v->{String temp=AnsTxtV.getText().toString();if(!temp.equals("0")){num1=AnsTxtV.getText().toString();AnsTxtV.setText("%");if(t==0){NumTxtV1.setText("Number 1 = " + num1);t=1;}else{NumTxtV2.setText("Number 2 = " + num1);t=0;}}});

        bequal.setOnClickListener(v->{

            num2 = AnsTxtV.getText().toString();

            String ans = "";

            switch (op){
                case '+':
                    bplus.setEnabled(true);
                    ans = String.valueOf(Float.parseFloat(num1) + Float.parseFloat(num2));
                    char ch1 = ans.charAt(ans.length()-2);
                    char ch2 = ans.charAt(ans.length()-1);
                    if(ch1 == '.' && ch2 == '0'){
                        ans = ans.substring(0,ans.length()-2);
                    }
                    Ans.setText(num1 + " " + op + " " + num2 + "  = " + ans);
                    break;
                case '%':
                    bdiv2.setEnabled(true);
                    ans = String.valueOf(Float.parseFloat(num1) % Float.parseFloat(num2));
                    char ch3 = ans.charAt(ans.length()-2);
                    char ch4 = ans.charAt(ans.length()-1);
                    if(ch3 == '.' && ch4 == '0'){
                        ans = ans.substring(0,ans.length()-2);
                    }
                    Ans.setText(num1 + " " + op + " " + num2 + "  = " + ans);
                    break;
                case '-':
                    bdiff.setEnabled(true);
                    ans = String.valueOf(Float.parseFloat(num1) - Float.parseFloat(num2));
                    char ch5 = ans.charAt(ans.length()-2);
                    char ch6 = ans.charAt(ans.length()-1);
                    if(ch5 == '.' && ch6 == '0'){
                        ans = ans.substring(0,ans.length()-2);
                    }
                    Ans.setText(num1 + " " + op + " " + num2 + "  = " + ans);
                    break;
                case '*':
                    bmult.setEnabled(true);
                    ans = String.valueOf(Float.parseFloat(num1) * Float.parseFloat(num2));
                    char ch7 = ans.charAt(ans.length()-2);
                    char ch8 = ans.charAt(ans.length()-1);
                    if(ch7 == '.' && ch8 == '0'){
                        ans = ans.substring(0,ans.length()-2);
                    }
                    Ans.setText(num1 + " " + op + " " + num2 + "  = " + ans);
                    break;
                case '/':
                    bdiv1.setEnabled(true);
                    ans = String.valueOf(Float.parseFloat(num1) / Float.parseFloat(num2));
                    char ch9 = ans.charAt(ans.length()-2);
                    char ch10 = ans.charAt(ans.length()-1);
                    if(ch9 == '.' && ch10 == '0'){
                        ans = ans.substring(0,ans.length()-2);
                    }
                    Ans.setText(num1 + " " + op + " " + num2 + "  = " + ans);
                    break;
            }
            AnsTxtV.setText("0");


        });



        bclear.setOnClickListener(v->{AnsTxtV.setText("0");iswh = false; NumTxtV1.setText(""); NumTxtV2.setText(""); Ans.setText("");bplus.setEnabled(true);bdiff.setEnabled(true);bmult.setEnabled(true);bdiv1.setEnabled(true);});



    }
}