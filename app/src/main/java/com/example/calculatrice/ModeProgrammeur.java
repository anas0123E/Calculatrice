package com.example.calculatrice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class ModeProgrammeur extends AppCompatActivity {

    //Attributs**********************
    TextView input,vHex,vDec,vBin,vOct;
    AppCompatButton Abutton,Bbutton,Cbutton,Dbutton,Ebutton,Fbutton;
    AppCompatButton HEX,DEC,OCT,BIN;
    AppCompatButton btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnPlusMoin;
    boolean hex,dec,oct,bin;
    //*******************************

    //Initialisations******************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_programmeur);
        initier();
    }
    private void initier(){

        input = (TextView) findViewById(R.id.input);
        vHex = (TextView) findViewById(R.id.vHex);
        vDec = (TextView) findViewById(R.id.vDec);
        vBin = (TextView) findViewById(R.id.vBin);
        vOct = (TextView) findViewById(R.id.vOct);
        Abutton = (AppCompatButton) findViewById(R.id.Abutton);
        Bbutton = (AppCompatButton) findViewById(R.id.Bbutton);
        Cbutton = (AppCompatButton) findViewById(R.id.Cbutton);
        Dbutton = (AppCompatButton) findViewById(R.id.Dbutton);
        Ebutton = (AppCompatButton) findViewById(R.id.Ebutton);
        Fbutton = (AppCompatButton) findViewById(R.id.Fbutton);
        btn9 = (AppCompatButton) findViewById(R.id.neufbutton);
        btn8 = (AppCompatButton) findViewById(R.id.huitbutton);
        btn7 = (AppCompatButton) findViewById(R.id.septbutton);
        btn6 = (AppCompatButton) findViewById(R.id.sixbutton);
        btn5 = (AppCompatButton) findViewById(R.id.cinqbutton);
        btn4 = (AppCompatButton) findViewById(R.id.quatrebutton);
        btn3 = (AppCompatButton) findViewById(R.id.troisbutton);
        btn2 = (AppCompatButton) findViewById(R.id.deuxbutton);
        HEX = (AppCompatButton) findViewById(R.id.bHex);
        DEC = (AppCompatButton) findViewById(R.id.bDec);
        OCT = (AppCompatButton) findViewById(R.id.bOct);
        BIN = (AppCompatButton) findViewById(R.id.bBin);
        btnPlusMoin = (AppCompatButton) findViewById(R.id.plusMoinbutton);
        dec = oct = bin = false;
        hex = true;
        inputChange();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_des_modes,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.modeScientifique:
                toScientifique();
                return true;
            case R.id.modeStandard:
                toStandard();
                return true;
            case R.id.modeCalculDate:
                toCalculDate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    private void toScientifique(){
        Intent intent = new Intent(this,ModeScientifique.class);
        startActivity(intent);
    }
    private void toStandard(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void toCalculDate(){
        Intent intent = new Intent(this,CalculDate.class);
        startActivity(intent);
    }
    //********************************

    //Bases***************************
    public void hexOnclick(View view) {
        if(hex == false) {
            decOnclick(view);
            dec = oct = bin = false;
            hex = true;
            Abutton.setClickable(true);
            Abutton.setTextColor(Color.parseColor("#FFFFFFFF"));
            Bbutton.setClickable(true);
            Bbutton.setTextColor(Color.parseColor("#FFFFFFFF"));
            Cbutton.setClickable(true);
            Cbutton.setTextColor(Color.parseColor("#FFFFFFFF"));
            Dbutton.setClickable(true);
            Dbutton.setTextColor(Color.parseColor("#FFFFFFFF"));
            Ebutton.setClickable(true);
            Ebutton.setTextColor(Color.parseColor("#FFFFFFFF"));
            Fbutton.setClickable(true);
            Fbutton.setTextColor(Color.parseColor("#FFFFFFFF"));
            HEX.setTextColor(Color.parseColor("#54704D"));
            DEC.setTextColor(Color.parseColor("#FFFFFFFF"));
            OCT.setTextColor(Color.parseColor("#FFFFFFFF"));
            BIN.setTextColor(Color.parseColor("#FFFFFFFF"));

        }
    }
    public void decOnclick(View view) {
        if(dec == false) {
            octOnclick(view);
            hex = oct = bin = false;
            dec = true;
            Abutton.setClickable(false);
            Abutton.setTextColor(Color.parseColor("#A8A6A6"));
            Bbutton.setClickable(false);
            Bbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Cbutton.setClickable(false);
            Cbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Dbutton.setClickable(false);
            Dbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Ebutton.setClickable(false);
            Ebutton.setTextColor(Color.parseColor("#A8A6A6"));
            Fbutton.setClickable(false);
            Fbutton.setTextColor(Color.parseColor("#A8A6A6"));
            btn9.setClickable(true);
            btn9.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn8.setClickable(true);
            btn8.setTextColor(Color.parseColor("#FFFFFFFF"));
            HEX.setTextColor(Color.parseColor("#FFFFFFFF"));
            DEC.setTextColor(Color.parseColor("#54704D"));
            OCT.setTextColor(Color.parseColor("#FFFFFFFF"));
            BIN.setTextColor(Color.parseColor("#FFFFFFFF"));
        }

    }
    public void octOnclick(View view) {
        if(oct == false) {
            binOnclick(view);
            hex = dec = bin = false;
            oct = true;
            Abutton.setClickable(false);
            Abutton.setTextColor(Color.parseColor("#A8A6A6"));
            Bbutton.setClickable(false);
            Bbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Cbutton.setClickable(false);
            Cbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Dbutton.setClickable(false);
            Dbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Ebutton.setClickable(false);
            Ebutton.setTextColor(Color.parseColor("#A8A6A6"));
            Fbutton.setClickable(false);
            Fbutton.setTextColor(Color.parseColor("#A8A6A6"));
            btn9.setClickable(false);
            btn9.setTextColor(Color.parseColor("#A8A6A6"));
            btn8.setClickable(false);
            btn8.setTextColor(Color.parseColor("#A8A6A6"));
            btn7.setClickable(true);
            btn7.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn6.setClickable(true);
            btn6.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn5.setClickable(true);
            btn5.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn4.setClickable(true);
            btn4.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn3.setClickable(true);
            btn3.setTextColor(Color.parseColor("#FFFFFFFF"));
            btn2.setClickable(true);
            btn2.setTextColor(Color.parseColor("#FFFFFFFF"));
            HEX.setTextColor(Color.parseColor("#FFFFFFFF"));
            DEC.setTextColor(Color.parseColor("#FFFFFFFF"));
            OCT.setTextColor(Color.parseColor("#54704D"));
            BIN.setTextColor(Color.parseColor("#FFFFFFFF"));
        }

    }
    public void binOnclick(View view) {
        if(bin == false) {
            hex = dec = oct = false;
            bin = true;
            input.setText("0");
            Abutton.setClickable(false);
            Abutton.setTextColor(Color.parseColor("#A8A6A6"));
            Bbutton.setClickable(false);
            Bbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Cbutton.setClickable(false);
            Cbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Dbutton.setClickable(false);
            Dbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Ebutton.setClickable(false);
            Ebutton.setTextColor(Color.parseColor("#A8A6A6"));
            Fbutton.setClickable(false);
            Fbutton.setTextColor(Color.parseColor("#A8A6A6"));
            Abutton.setClickable(false);
            btn9.setClickable(false);
            btn9.setTextColor(Color.parseColor("#A8A6A6"));
            btn8.setClickable(false);
            btn8.setTextColor(Color.parseColor("#A8A6A6"));
            btn7.setClickable(false);
            btn7.setTextColor(Color.parseColor("#A8A6A6"));
            btn6.setClickable(false);
            btn6.setTextColor(Color.parseColor("#A8A6A6"));
            btn5.setClickable(false);
            btn5.setTextColor(Color.parseColor("#A8A6A6"));
            btn4.setClickable(false);
            btn4.setTextColor(Color.parseColor("#A8A6A6"));
            btn3.setClickable(false);
            btn3.setTextColor(Color.parseColor("#A8A6A6"));
            btn2.setClickable(false);
            btn2.setTextColor(Color.parseColor("#A8A6A6"));
            HEX.setTextColor(Color.parseColor("#FFFFFFFF"));
            DEC.setTextColor(Color.parseColor("#FFFFFFFF"));
            OCT.setTextColor(Color.parseColor("#FFFFFFFF"));
            BIN.setTextColor(Color.parseColor("#54704D"));
        }
    }
    public void undoOnclick(View view) {
        if(input.getText().length() != 1)
            input.setText(input.getText().toString().substring(0,input.getText().toString().length()-1));
        else
            input.setText("0");
    }
    public void clearOnclick(View view) {
        input.setText("0");
    }
    //*********************************

    //Chiffres********************
    int binMaxLength = 23;
    public void aOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength){
            if (input.getText().toString().equals("0")) {
                input.setText("A");
            } else
                input.setText(input.getText() + "A");
        }
    }
    public void bOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("B");
            } else
                input.setText(input.getText() + "B");
        }
    }
    public void cOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("C");
            } else
                input.setText(input.getText() + "C");
        }
    }
    public void dOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("D");
            } else
                input.setText(input.getText() + "D");
        }
    }
    public void eOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("E");
            } else
                input.setText(input.getText() + "E");
        }
    }
    public void fOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("F");
            } else
                input.setText(input.getText() + "F");
        }
    }
    public void neufOnClick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("9");
            } else
                input.setText(input.getText() + "9");
        }
    }
    public void huitOnClick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("8");
            } else
                input.setText(input.getText() + "8");
        }
    }
    public void septOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("7");
            } else
                input.setText(input.getText() + "7");
        }
    }
    public void sixOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("6");
            } else
                input.setText(input.getText() + "6");
        }
    }
    public void cinqOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("5");
            } else
                input.setText(input.getText() + "5");
        }
    }
    public void quatreOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("4");
            } else
                input.setText(input.getText() + "4");
        }
    }
    public void troisOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("3");
            } else
                input.setText(input.getText() + "3");
        }
    }
    public void deuxOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("2");
            } else
                input.setText(input.getText() + "2");
        }
    }
    public void unOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("1");
            } else
                input.setText(input.getText() + "1");
        }
    }
    public void zeroOnclick(View view) {
        if (vBin.getText().toString().length() <= binMaxLength) {
            if (input.getText().toString().equals("0")) {
                input.setText("0");
            } else
                input.setText(input.getText() + "0");
        }
    }
    public void plusMoinOnclick(View view) {
        if(!input.getText().toString().substring(0,1).equals("-")) {
            if (vBin.getText().toString().length() <= binMaxLength) {
                input.setText("-" + input.getText());
            }
        }else{
            input.setText(input.getText().toString().substring(1));
        }
    }
    //*******************************

    public void inputChange(){
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                changeAll();
            }
        });
    }

    private void changeAll(){
        if(hex){

            int inputNUm = Integer.parseInt(input.getText().toString(),16);
            vHex.setText(Integer.toHexString(inputNUm).toUpperCase());
            vDec.setText(""+inputNUm);
            vOct.setText(Integer.toOctalString(inputNUm));
            vBin.setText(Integer.toBinaryString(inputNUm));

        }else if(dec){

            int inputNUm = Integer.parseInt(input.getText().toString());
            vHex.setText(Integer.toHexString(inputNUm).toUpperCase());
            vDec.setText(""+inputNUm);
            vOct.setText(Integer.toOctalString(inputNUm));
            vBin.setText(Integer.toBinaryString(inputNUm));

        }else if(oct){

            int inputNUm = Integer.parseInt(input.getText().toString(),8);
            vHex.setText(Integer.toHexString(inputNUm).toUpperCase());
            vDec.setText(""+inputNUm);
            vOct.setText(Integer.toOctalString(inputNUm));
            vBin.setText(Integer.toBinaryString(inputNUm));

        }else if(bin){

            int inputNUm = Integer.parseInt(input.getText().toString(),2);
            vHex.setText(Integer.toHexString(inputNUm).toUpperCase());
            vDec.setText(""+inputNUm);
            vOct.setText(Integer.toOctalString(inputNUm));
            vBin.setText(Integer.toBinaryString(inputNUm));

        }
    }


}