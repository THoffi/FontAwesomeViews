package de.th.fontawesomeviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import de.th.fontawesome.FontAwesomeButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FontAwesomeButton with ClickListener
        FontAwesomeButton faButton = findViewById(R.id.btnFontAwesomeTest);
        faButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello Button",Toast.LENGTH_SHORT).show();
            }
        });

    }
}