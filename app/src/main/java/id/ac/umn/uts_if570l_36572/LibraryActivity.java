package id.ac.umn.uts_if570l_36572;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.Menu;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private ArrayList<Integer> fotoEffect = new ArrayList<>();
    private ArrayList<String> namaEffect = new ArrayList<>();
    private ArrayList<String> infoEffect = new ArrayList<>();
    private ArrayList<Integer> soundEffect = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        Bundle b = getIntent().getExtras();
        String name = b.getString("name");
        setTitle(name);
        Toast.makeText(LibraryActivity.this, "Welcome "+name, Toast.LENGTH_SHORT).show();

        getDataFromLocal();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.library_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuProfile) {
            Intent menuProfile = new Intent(this,ProfileActivity.class);
            startActivity(menuProfile);
        }else if (item.getItemId() == R.id.menuBack) {
            Intent btnProfile = new Intent(this,MainActivity.class);
            startActivity(btnProfile);
        }else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoEffect, namaEffect, infoEffect, soundEffect, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromLocal(){
        namaEffect.add("Pekora's Laugh");
        fotoEffect.add(R.drawable.pekora);
        infoEffect.add("HA⬆️Ha⬆️Ha⬆️Ha⬆️");
        soundEffect.add(R.raw.pekora);

        namaEffect.add("I'm die, thank you forever");
        fotoEffect.add(R.drawable.korone);
        infoEffect.add("What?!?! AAAARGH!!");
        soundEffect.add(R.raw.korone);

        namaEffect.add("Gura's a");
        fotoEffect.add(R.drawable.guraa);
        infoEffect.add("a");
        soundEffect.add(R.raw.guraa);

        namaEffect.add("POI!!");
        fotoEffect.add(R.drawable.poi);
        infoEffect.add("Oooh!!");
        soundEffect.add(R.raw.poi);

        namaEffect.add("Hotate");
        fotoEffect.add(R.drawable.hotate);
        infoEffect.add("Tetaho");
        soundEffect.add(R.raw.hotate);

        namaEffect.add("E");
        fotoEffect.add(R.drawable.e);
        infoEffect.add("E E E EEEE EEEEEE");
        soundEffect.add(R.raw.e);

        namaEffect.add("The Microsoft Sound");
        fotoEffect.add(R.drawable.win95);
        infoEffect.add("Windows 95 startup sound");
        soundEffect.add(R.raw.mssound);

        prosesRecyclerViewAdapter();

    }
}