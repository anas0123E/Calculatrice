package com.example.calculatrice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Attributs**********
    TextView equation,resultat;
    boolean possible = true;
    boolean dot = true;
    ArrayList<String> opérators = new ArrayList<String>();
    //*****************************


    //Initialisations**********
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initier();
    }
    private void initier(){
        equation = (TextView) findViewById(R.id.equation);
        resultat = (TextView) findViewById(R.id.resultat);
        resultat.setText("0");
        opérators.add("+");
        opérators.add("-");
        opérators.add("/");
        opérators.add("*");
        opérators.add("%");
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
            case R.id.modeProgrammeur:
                toProgrammeur();
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
    private void toProgrammeur(){
        Intent intent = new Intent(this,ModeProgrammeur.class);
        startActivity(intent);
    }
    private void toCalculDate(){
        Intent intent = new Intent(this,CalculDate.class);
        startActivity(intent);
    }
    //*****************************


    //Boutons des opérateurs**********
    public void BackOnClick(View view) {
        if(resultat.getText().toString().length()!=1) {
            String val = resultat.getText().toString();
            if (val.substring(val.length() - 1) == ".") {
                dot = true;
            }
            val = val.substring(0, val.length() - 1);
            resultat.setText(val);
        }else{
            resultat.setText("0");
        }
    }
    public void ClearOnClick(View view) {
        equation.setText(" ");
        resultat.setText("0");
        possible = true;
        dot = true;
    }
    public void MulOnClick(View view) {
        if(possible){
            if(!opérators.contains(equation.getText().toString().substring(equation.getText().toString().length()-1))) {
                possible = false;
                equation.setText(resultat.getText() + "*");
                resultat.setText("0");
            }else{
                EgaleOnClick(view);
                equation.setText(resultat.getText() + "*");
                resultat.setText("0");
            }
        }

    }
    public void divOnClick(View view) {
        if(possible){
            if(!opérators.contains(equation.getText().toString().substring(equation.getText().toString().length()-1))) {
                possible = false;
                equation.setText(resultat.getText() + "/");
                resultat.setText("0");
            }else{
                EgaleOnClick(view);
                equation.setText(resultat.getText() + "/");
                resultat.setText("0");
            }
        }

    }
    public void soustOnClick(View view) {
        if(possible){
            if(!opérators.contains(equation.getText().toString().substring(equation.getText().toString().length()-1))) {
                possible = false;
                equation.setText(resultat.getText() + "-");
                resultat.setText("0");
            }else{
                EgaleOnClick(view);
                equation.setText(resultat.getText() + "-");
                resultat.setText("0");
            }
        }

    }
    public void PlusOnClick(View view) {
        if(possible){
            if(!opérators.contains(equation.getText().toString().substring(equation.getText().toString().length()-1))) {
                possible = false;
                equation.setText(resultat.getText() + "+");
                resultat.setText("0");
            }else{
                EgaleOnClick(view);
                equation.setText(resultat.getText() + "+");
                resultat.setText("0");
            }
        }

    }
    public void EgaleOnClick(View view) {
        if(equation.getText().toString() != "") {
            String result = equation.getText().toString();
            Double val1 = Double.parseDouble(result.substring(0, result.length() - 1));
            String operation = result.substring(result.length()-1);
            Double val2 = Double.parseDouble(resultat.getText().toString());
            DecimalFormat format = new DecimalFormat("0.#");
            switch (operation) {
                case "+":
                    Double rp = val1 + val2;
                    resultat.setText(""+format.format(rp));
                    equation.setText(format.format(val1) +" + "+ format.format(val2) +" =");
                    break;
                case "-":
                    Double rm = val1 - val2;
                    resultat.setText(""+format.format(rm));
                    equation.setText(format.format(val1) +" - "+ format.format(val2) +" =");
                    break;
                case "*":
                    Double rx = val1 * val2;
                    resultat.setText(""+format.format(rx));
                    equation.setText(format.format(val1) +" * "+ format.format(val2) +" =");
                    break;
                case "%":
                    Double rmod = val1 % val2;
                    resultat.setText(""+format.format(rmod));
                    equation.setText(format.format(val1) +" % "+ format.format(val2) +" =");
                    break;
                case "/":
                    Double rdiv = val1 / val2;
                    resultat.setText(""+format.format(rdiv));
                    equation.setText(format.format(val1) +" / "+ format.format(val2) +" =");
                    break;
            }
        }
    }
    public void modOnClick(View view) {
        if(possible){
            if(!opérators.contains(equation.getText().toString().substring(equation.getText().toString().length()-1))) {
                possible = false;
                equation.setText(resultat.getText() + "%");
                resultat.setText("0");
            }else{
                EgaleOnClick(view);
                equation.setText(resultat.getText() + "%");
                resultat.setText("0");
            }
        }
    }
    //*****************************


    //Boutons des chiffres**********
    public void septOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("7");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "7");
                possible = true;
            }else{
                ClearOnClick(view);
                septOnClick(view);
            }
        }
    }
    public void huitOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("8");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "8");
                possible = true;
            }else{
                ClearOnClick(view);
                huitOnClick(view);
            }
        }

    }
    public void neufOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("9");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "9");
                possible = true;
            }else{
                ClearOnClick(view);
                neufOnClick(view);
            }
        }
    }
    public void quatreOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("4");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "4");
                possible = true;
            }else{
                ClearOnClick(view);
                quatreOnClick(view);
            }
        }
    }
    public void cinqOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("5");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "5");
                possible = true;
            }else{
                ClearOnClick(view);
                cinqOnClick(view);
            }
        }
    }
    public void sixOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("6");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "6");
                possible = true;
            }else{
                ClearOnClick(view);
                sixOnClick(view);
            }
        }
    }
    public void unOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("1");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "1");
                possible = true;
            }else{
                ClearOnClick(view);
                unOnClick(view);
            }
        }
    }
    public void deuxOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("2");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "2");
                possible = true;
            }else{
                ClearOnClick(view);
                deuxOnClick(view);
            }
        }
    }
    public void troisOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("3");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "3");
                possible = true;
            }else{
                ClearOnClick(view);
                troisOnClick(view);
            }
        }
    }
    public void zeroOnClick(View view) {
        if(resultat.getText()=="0") {
            resultat.setText("0");
            possible = true;
            dot = true;
        }
        else
        {
            if(!equation.getText().toString().substring(equation.getText().toString().length()-1).equals("=")) {
                resultat.setText(resultat.getText() + "0");
                possible = true;
            }else{
                ClearOnClick(view);
                zeroOnClick(view);
            }
        }
    }
    public void pointOnClick(View view) {
        if(dot){
            dot = false;
            resultat.setText(resultat.getText()+".");
        }
    }
    //*****************************
}