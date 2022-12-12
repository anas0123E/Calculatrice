package com.example.calculatrice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalculDate extends AppCompatActivity {

    DatePicker dd,da;
    TextView resultat1;

    //Initialisation*****************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul_date);
        initier();
    }
    private void initier()
    {
        dd = (DatePicker) findViewById(R.id.DateDépart);
        da = (DatePicker) findViewById(R.id.DateArivée);
        resultat1 = (TextView) findViewById(R.id.resultat1);

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
            case R.id.modeStandard:
                toStandard();
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
    private void toStandard(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    //*******************************

    public void egale(View view) {
        Date départ = new Date(dd.getYear(),dd.getMonth(),dd.getDayOfMonth());
        Date arivée = new Date(da.getYear(),da.getMonth(),da.getDayOfMonth());

        long diffInMillies = Math.abs(départ.getTime() - arivée.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        long diffMonth = diff / 30;
        long diffYears = diff / 365;
        long diffWeeks =  diff / 7;
        resultat1.setText(diffYears+" ans; "+diffMonth+" mois; "+diffWeeks+" semaines; "+diff+" jours");

    }

}