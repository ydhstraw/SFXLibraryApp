package id.ac.umn.uts_if570l_36572;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageViewFotoEffect;
    TextView textViewNamaEffect, textViewInfoEffect;
    Button buttonPlay;

    MediaPlayer effectPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewFotoEffect = findViewById(R.id.imageViewFotoEffect);
        textViewNamaEffect = findViewById(R.id.textViewNamaEffect);
        textViewInfoEffect = findViewById(R.id.textViewInfoEffect);
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

            String fotoEffect = getIntent().getStringExtra("foto_effect");
            String namaEffect = getIntent().getStringExtra("nama_effect");
            String infoEffect = getIntent().getStringExtra("info_effect");
            Integer soundEffect = getIntent().getIntExtra("sound_effect", 0);

            setDataActivity(fotoEffect, namaEffect, infoEffect, soundEffect);
        }


    }

    private void setDataActivity(String fotoEffect, String namaEffect, String infoEffect, Integer soundEffect){
        Glide.with(this).asBitmap().load(fotoEffect).into(imageViewFotoEffect);

        textViewNamaEffect.setText(namaEffect);
        textViewInfoEffect.setText(infoEffect);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                effectPlayer = MediaPlayer.create(getApplicationContext(), soundEffect);
                effectPlayer.start();
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