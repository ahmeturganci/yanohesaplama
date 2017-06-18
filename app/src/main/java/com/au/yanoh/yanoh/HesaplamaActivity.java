package com.au.yanoh.yanoh;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

public class HesaplamaActivity extends AppCompatActivity {
    private LinearLayout parentLinearLayout;
    Button btnHesapla;
    EditText[] etler;
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

        for(int l=0; l<=gelenDS; l++){
            //sorunu şuraya birdaha yazsana kanka gitmediysen
            //sıkıntı şu ben dinamik olarak nesne bileşen üretiyorum ancak bunlardan değer alaıyorum hesap işi için alamam gerek
            onAddField();
        }

        btnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


    }
AdapterView.OnItemSelectedListener secilenHarfGorevi = new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        EditText etDersAdi =(EditText) parent.findViewById(R.id.dersAdi);
        EditText etDersKredi =(EditText)  parent.findViewById(R.id.kredi);
        TextView txtDurum = (TextView) parent.findViewById(R.id.durum);
        DersKontrol(view,txtDurum);

        //etDersAdi.setText("asdasdasd"+  position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
};
    protected void DersKontrol(View view,TextView textView){
        //Log.d("Ders Kontrol Çalıştı");
    }

/*TextWatcher yazilanMetinGorevi = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            s.
        }
    };*/
    public void onAddField() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.dersler, null);
        // Add the new row before the add field button.
        EditText etDersAdi = (EditText)rowView.findViewById(R.id.dersAdi);

        EditText etDersKredi = (EditText)rowView.findViewById(R.id.kredi);
        Spinner spnHaft  = (Spinner)rowView.findViewById(R.id.harf);
        spnHaft.setOnItemSelectedListener(secilenHarfGorevi);
        TextView tctDurum = (TextView)rowView.findViewById(R.id.durum);

        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);

    }


}
