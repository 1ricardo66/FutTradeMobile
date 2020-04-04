package br.com.ricardofelix.futtrademobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import br.com.ricardofelix.futtrademobile.R;
import mehdi.sakout.aboutpage.AboutPage;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription("Fut trade é uma aplicação Open source.")
                .addGroup("Entre em contato")
                .addEmail("ricardofps66@gmail.com")
                .addGitHub("1ricardo66")
                .addInstagram("r1cardo66")
                .create();
        setContentView(aboutPage);
    }
}
