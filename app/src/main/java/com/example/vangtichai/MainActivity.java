package com.example.vangtichai;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnClr;
    private TextView textViewVal, textView1, textView2, textView5, textView10,
            textView20, textView50, textView100, textView500;
    private String currentVal;
    private static final String STATE_VAL = "currentVal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setEntities();

        if (savedInstanceState != null) {
            String savedVal = savedInstanceState.getString(STATE_VAL);
            currentVal = savedVal;
            calculateChange();
            textViewVal.setText(getString(R.string.tktext).concat(savedVal));
        }

        btn1.setOnClickListener(v -> addNumber("1"));
        btn2.setOnClickListener(v -> addNumber("2"));
        btn3.setOnClickListener(v -> addNumber("3"));
        btn4.setOnClickListener(v -> addNumber("4"));
        btn5.setOnClickListener(v -> addNumber("5"));
        btn6.setOnClickListener(v -> addNumber("6"));
        btn7.setOnClickListener(v -> addNumber("7"));
        btn8.setOnClickListener(v -> addNumber("8"));
        btn9.setOnClickListener(v -> addNumber("9"));
        btn0.setOnClickListener(v -> addNumber("0"));
        btnClr.setOnClickListener(v -> {
            currentVal = "";
            this.textViewVal.setText(getString(R.string.tktext).concat(currentVal));
            reset();
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        savedInstanceState.putString(STATE_VAL, currentVal);
        super.onSaveInstanceState(savedInstanceState);
    }

    private void addNumber(String number) {
        currentVal = currentVal.concat(number);
        this.textViewVal.setText(getString(R.string.tktext).concat(currentVal));
        calculateChange();
    }

    private void calculateChange() {
        if (currentVal.length() > 9) {
            Toast.makeText(getApplicationContext(),
                    "Number Limit Reached", Toast.LENGTH_SHORT).show();
            textViewVal.setBackgroundColor(getResources().getColor(R.color.red));
            textViewVal.setTextColor(getResources().getColor(R.color.white));
            return;
        }
        int amount = Integer.parseInt(currentVal);
        textView500.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._500tk).toString(), amount / 500));
        amount %= 500;
        textView100.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._100tk).toString(), amount/100));
        amount %= 100;
        textView50.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._50tk).toString(), amount/50));
        amount %= 50;
        textView20.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._20tk).toString(), amount/20));
        amount %= 20;
        textView10.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._10tk).toString(), amount/10));
        amount %= 10;
        textView5.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._5tk).toString(), amount/5));
        amount %= 5;
        textView2.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._2tk).toString(), amount/2));
        amount %= 2;
        textView1.setText(String.format(Locale.ENGLISH,"%s%d",
                getText(R.string._1tk).toString(), amount));

    }

    private void setEntities() {
        currentVal = "";

        this.btn0 = findViewById(R.id.btn0); this.btn1 = findViewById(R.id.btn1);
        this.btn2 = findViewById(R.id.btn2); this.btn3 = findViewById(R.id.btn3);
        this.btn4 = findViewById(R.id.btn4); this.btn5 = findViewById(R.id.btn5);
        this.btn6 = findViewById(R.id.btn6); this.btn7 = findViewById(R.id.btn7);
        this.btn8 = findViewById(R.id.btn8); this.btn9 = findViewById(R.id.btn9);
        this.btnClr = findViewById(R.id.btnClr);

        this.textViewVal = findViewById(R.id.text); this.textView1 = findViewById(R.id.text1);
        this.textView2 = findViewById(R.id.text2); this.textView5 = findViewById(R.id.text5);
        this.textView10 = findViewById(R.id.text10); this.textView20 = findViewById(R.id.text20);
        this.textView50 = findViewById(R.id.text50); this.textView100 = findViewById(R.id.text100);
        this.textView500 = findViewById(R.id.text500);

        this.textViewVal.setText(getString(R.string.tktext).concat(currentVal));
    }

    private void reset() {
        textViewVal.setBackgroundColor(getResources().getColor(R.color.white));
        textViewVal.setTextColor(getResources().getColor(R.color.dark_300));
        textView500.setText(getText(R.string._500tk).toString());
        textView100.setText(getText(R.string._100tk).toString());
        textView50.setText(getText(R.string._50tk).toString());
        textView20.setText(getText(R.string._20tk).toString());
        textView10.setText(getText(R.string._10tk).toString());
        textView5.setText(getText(R.string._5tk).toString());
        textView2.setText(getText(R.string._2tk).toString());
        textView1.setText(getText(R.string._1tk).toString());
    }
}