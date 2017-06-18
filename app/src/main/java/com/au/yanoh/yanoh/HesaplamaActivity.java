package com.au.yanoh.yanoh;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class HesaplamaActivity extends AppCompatActivity {
    private LinearLayout parentLinearLayout;
    Button btnHesapla;
    EditText[] etler;
    LinkedList<Ders> dersler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesaplama);
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
        btnHesapla = (Button) findViewById(R.id.btnHesapla);

        //Diğer activity den verileri aldık.
        Bundle veri = getIntent().getExtras();
        int gelenDS = veri.getInt("DersSay");
        Toast.makeText(getApplicationContext(), gelenDS +" asd", Toast.LENGTH_SHORT).show();

        dersler = new LinkedList<Ders>();
        for(int l=0; l<gelenDS; l++){
            //sorunu şuraya birdaha yazsana kanka gitmediysen
            //sıkıntı şu ben dinamik olarak nesne bileşen üretiyorum ancak bunlardan değer alaıyorum hesap işi için alamam gerek
            dersler.add(new Ders(this,parentLinearLayout));
        }
        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                float krediler = 0f;
                float puanlar = 0f;
                for (int i = 0; i < dersler.size(); i++) {
                    Ders d = dersler.get(i);
                    krediler += d.kredi;
                    puanlar += d.dersPuani;
                    //katsayı çarpı kredi bunların toplamı / tüm kredilerin toplamı )
                    //toplam[katsayı * kredi]  / toplam[krediler]
                }
                float sonuc = puanlar/krediler;
                Toast.makeText(getApplicationContext(), sonuc +"  SONUÇ YANO", Toast.LENGTH_LONG).show();
                Log.e("WEBIS",sonuc + "SONUC YANO");
            }
        });


    }
}
