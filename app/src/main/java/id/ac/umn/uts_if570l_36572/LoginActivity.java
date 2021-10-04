package id.ac.umn.uts_if570l_36572;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText editTextPersonName;
    private Button buttonLogin;
    String userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextPersonName = (EditText) findViewById(R.id.editTextPersonName);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(editTextPersonName.getText().toString())){
                    Toast.makeText(LoginActivity.this, "Harap isi nama anda", Toast.LENGTH_SHORT).show();
                }else{
                    openLib();
                }
            }
        });

        //Button Next = findViewById(R.id.buttonLogin);
        //Next.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Next();
        //    }
        //});
    }
    //public void Next() {
    //    Intent btnNext = new Intent(this,LibraryActivity.class);
    //    startActivity(btnNext);
    //}

    public String openLib(){
        userProfile = editTextPersonName.getText().toString();
        Intent intent = getIntent();
        Intent profile = new Intent(this, LibraryActivity.class);
        profile.putExtra("name", userProfile);
        startActivity(profile);
        return null;
    }
}