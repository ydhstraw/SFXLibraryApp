package id.ac.umn.uts_if570l_36572;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Profile = findViewById(R.id.buttonPro);
        Button Library = findViewById(R.id.buttonLib);
        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Profile();
            }
        });
        Library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Library();
            }
        });
    }

    public void Profile() {
        Intent btnProfile = new Intent(this,ProfileActivity.class);
        startActivity(btnProfile);
    }

    public void Library() {
        Intent btnLib = new Intent(this,LoginActivity.class);
        startActivity(btnLib);
    }
}