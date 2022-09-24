package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declarando os objetos
    ImageView imagem;
    TextView texto;
    Animation animImg, animText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapeando os objetos xml com java
        texto = (TextView) findViewById(R.id.tvTextAnim);
        imagem = (ImageView) findViewById(R.id.imgLogoAnim);

        //criando as animações
        animImg = AnimationUtils.loadAnimation(this, R.anim.logo_top);
        animText = AnimationUtils.loadAnimation(this, R.anim.carregar_button);

        //alterando nos objetos
        texto.setAnimation(animText);
        imagem.setAnimation(animImg);

        //depois de 3segundo carrega a tela principal
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        }, 5000);
    }
}