package com.example.revisiterakhir;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


public class HitungFragment extends Fragment {
    //hapus kalo focl
//    OnMessageSendListener messageSendListener;
//    EditText edt;
//
//    public interface OnMessageSendListener {
//        void onMessageSend(String message);
//    }
//
//    public HitungFragment() {
//
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hitung_fragment, container, false);


        final Animation muter, stop;
        final EditText timer;
        final Button btnon, btnoff, btntimer;
        final ImageView kipas;

        stop = AnimationUtils.loadAnimation(getContext(),R.anim.stop_anim);
        muter = AnimationUtils.loadAnimation(getContext(),R.anim.muter_anim);
        timer = view.findViewById(R.id.setTimer);
        btnon = view.findViewById(R.id.nyala);
        btntimer = view.findViewById(R.id.button);
        btnoff = view.findViewById(R.id.mati);
        kipas = view.findViewById(R.id.kipas);
        btnon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean nyala = false;


                if (nyala){

                }else{
                    muter.setDuration(170);
                    muter.setRepeatCount(100);
                    kipas.startAnimation(muter);
                    nyala = true;

                }

            }
        });
        btnoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean nyala = false;

                if (nyala){

                }else{
                    kipas.startAnimation(stop);
                }
            }
        });

        btntimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = timer.getText().toString().trim();
                if (input.length() == 0){
                    timer.setError("kalau mau timer harus isi");
                }else if(v.getId() == R.id.button){
                    double masuk = keDouble(input);
                    long akhir = (long) (masuk * 100);

                    muter.setRepeatCount(0);
                    muter.setDuration(akhir);
                    kipas.startAnimation(muter);

                }


            }
        });
        return view;
    }

    private Double keDouble (String str){
        try{
            return Double.valueOf(str);
        }catch (NumberFormatException e){
            return null;
        }
    }

}
