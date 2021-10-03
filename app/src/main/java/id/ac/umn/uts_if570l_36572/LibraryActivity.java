package id.ac.umn.uts_if570l_36572;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private ArrayList<String> fotoEffect = new ArrayList<>();
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

        getDataFromInternet();
    }

    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoEffect, namaEffect, infoEffect, soundEffect, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet(){
        namaEffect.add("test 1");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 1");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 2");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 2");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 3");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 3");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 1");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 1");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 2");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 2");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 3");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 3");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 1");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 1");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 2");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 2");
        soundEffect.add(R.raw.africa);

        namaEffect.add("test 3");
        fotoEffect.add("https://cdn.pixabay.com/photo/2017/07/09/20/48/speaker-2488096_960_720.png");
        infoEffect.add("tes 3");
        soundEffect.add(R.raw.africa);

        prosesRecyclerViewAdapter();

    }
}