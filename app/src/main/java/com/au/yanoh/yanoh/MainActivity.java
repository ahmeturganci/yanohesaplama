package com.au.yanoh.yanoh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etDS;//Ders sayılarını tutacak edittext
    Button btnDSAl;//Ders sayısını alıp diğer ekrana geçirme işlemi için
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDS = (EditText) findViewById(R.id.etDersSayisi);
        btnDSAl = (Button) findViewById(R.id.btnGecis);

        btnDSAl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int val = Integer.parseInt( etDS.getText().toString() );
                if(val >=11) {
                    Toast.makeText(MainActivity.this,
                            "Dönemlik ders sayısı 10 dan fazla olamaz.",
                            Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,
                            "Dönemlik ders sayısı" + val + "alındı.",
                            Toast.LENGTH_LONG).show();

                    Bundle extras = new Bundle();
                    extras.putInt("DersSay", val);


                    Intent intent = new Intent();
                    intent.putExtras(extras);
                    intent.setClass(getApplicationContext(), HesaplamaActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
