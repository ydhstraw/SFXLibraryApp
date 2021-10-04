package id.ac.umn.uts_if570l_36572;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageViewFotoEffect;
    TextView textViewNamaEffect, textViewInfoEffect, textViewSourceEffect;
    Button buttonPlay;

    MediaPlayer effectPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewFotoEffect = findViewById(R.id.imageViewFotoEffect);
        textViewNamaEffect = findViewById(R.id.textViewNamaEffect);
        textViewInfoEffect = findViewById(R.id.textViewInfoEffect);
        textViewSourceEffect = findViewById(R.id.textViewSourceEffect);
        buttonPlay = findViewById(R.id.buttonPlay);

        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        String name = b.getString("nama_effect");
        setTitle(name);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if(getIntent().hasExtra("foto_effect") && getIntent().hasExtra("nama_effect") && getIntent().hasExtra("info_effect")) {

            Integer fotoEffect = getIntent().getIntExtra("foto_effect", 0);
            String namaEffect = getIntent().getStringExtra("nama_effect");
            String infoEffect = getIntent().getStringExtra("info_effect");
            Integer soundEffect = getIntent().getIntExtra("sound_effect", 0);
            String sourceEffect = getIntent().getStringExtra("source_effect");

            setDataActivity(fotoEffect, namaEffect, infoEffect, soundEffect, sourceEffect);
        }
    }

    private void setDataActivity(Integer fotoEffect, String namaEffect, String infoEffect, Integer soundEffect, String sourceEffect){
        Glide.with(this).asBitmap().load(fotoEffect).into(imageViewFotoEffect);

        textViewNamaEffect.setText(namaEffect);
        textViewInfoEffect.setText(infoEffect);
        textViewSourceEffect.setText(sourceEffect);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                effectPlayer = MediaPlayer.create(getApplicationContext(), soundEffect);
                effectPlayer.start();
                Toast.makeText(view.getContext(), "Playing "+namaEffect,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if (effectPlayer != null) effectPlayer.release();
    }
}