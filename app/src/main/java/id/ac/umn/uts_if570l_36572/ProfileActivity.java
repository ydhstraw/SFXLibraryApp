package id.ac.umn.uts_if570l_36572;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Profile");

        TextView ref1 = (TextView) findViewById(R.id.ref1);
        ref1.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref2 = (TextView) findViewById(R.id.ref2);
        ref2.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref3 = (TextView) findViewById(R.id.ref3);
        ref3.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref4 = (TextView) findViewById(R.id.ref4);
        ref4.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref5 = (TextView) findViewById(R.id.ref4);
        ref5.setMovementMethod(LinkMovementMethod.getInstance());

        TextView ref6 = (TextView) findViewById(R.id.ref4);
        ref6.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}