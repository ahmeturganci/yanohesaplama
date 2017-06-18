package com.au.yanoh.yanoh;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by ahmetu on 17.06.2017.
 */

public class Ders {

    public EditText dersAdi;
    public  EditText dersKredi;
    public Spinner dersHarf;
    public TextView dersDurum;

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


}
