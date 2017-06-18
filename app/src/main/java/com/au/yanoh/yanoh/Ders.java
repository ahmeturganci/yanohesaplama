package com.au.yanoh.yanoh;

import android.content.ContentProvider;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ahmetu on 17.06.2017.
 */

public class Ders {

    public EditText dersAdi;
    public  EditText dersKredi;
    public Spinner dersHarf;
    public TextView dersDurum;
    private LinearLayout parent;
    private Context context;
    float katasayi = 0f;
    float kredi = 0f;
    float dersPuani;
    boolean durumu = false;


    public  EditText getDersAdi(){
    return dersAdi;
    }
    public void setDersAdi(EditText dersAdi){
    this.dersAdi = dersAdi;
    }

    public  EditText getDersKredi(){
        return dersKredi;
    }
    public void setDersKredi(EditText dersKredi){
        this.dersKredi = dersKredi;
    }

    public Spinner getdersHarf() {
        return dersHarf;
    }
    public  void setDersHarf(Spinner dersHarf){
        this.dersHarf = dersHarf;
    }
    public TextView getDersDurum(){
        return  dersDurum;
    }
    public  void setDersDurum(TextView dersDurum){
        this.dersDurum= dersDurum;
    }

    //fonksiyonlar geleck


    public Ders(Context _c,LinearLayout _ll) {
        this.parent = _ll;
        this.context = _c;
        inifilate();
    }

    private void inifilate() {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.dersler, null);
        // Ad
        // d the new row before the add field button.
        this.dersAdi = (EditText)rowView.findViewById(R.id.dersAdi);
        this.dersKredi  = (EditText)rowView.findViewById(R.id.kredi);
        Toast.makeText(context,dersKredi + "asd", Toast.LENGTH_SHORT).show();

        this.dersHarf = (Spinner)rowView.findViewById(R.id.harf);
        this.dersDurum = (TextView)rowView.findViewById(R.id.durum);
        this.dersHarf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String[] harfler =  Ders.this.context.getResources().getStringArray(R.array.types);
               katasayi = YanohUtils.HarfKatsayisiAl(harfler[position]);
                hesapla();
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        this.dersKredi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                int temp= Integer.parseInt((Ders.this.dersKredi.getText()).toString());


                if(temp >=1 && temp <=10){
                    Ders.this.kredi = temp;
                    hesapla();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                int temp= Integer.parseInt((Ders.this.dersKredi.getText()).toString());


                if(temp >=1 && temp <=10){
                    Ders.this.kredi = temp;
                    hesapla();
                }else {
                    Toast.makeText(context, "Ders kredisi 1-10 arasındadır", Toast.LENGTH_SHORT).show();
                }
            }
        });

        parent.addView(rowView, parent.getChildCount() - 1);
    }

    private void hesapla() {
        dersPuani = this.katasayi*this.kredi;
        if(katasayi<2){
            durumu=false;
            this.dersDurum.setText("Kaldı");

        } else{
            durumu =true;
            this.dersDurum.setText("Geçti");
        }
    }


}
