package de.th.fontawesomeviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.th.fontawesome.FontAwesomeButton;
import de.th.fontawesome.FontAwesomeView;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        // FontAwesomeButton with ClickListener
        FontAwesomeButton faButton1 = findViewById(R.id.btnFaRipple);
        faButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello Button Ripple",Toast.LENGTH_SHORT).show();
            }
        });

        // FontAwesomeButton with ClickListener
        FontAwesomeButton faButton2 = findViewById(R.id.btnFaRotation);
        faButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello Button Rotation",Toast.LENGTH_SHORT).show();
            }
        });

        // FontAwesomeButton with ClickListener
        FontAwesomeButton faButton3 = findViewById(R.id.btnFaBounce);
        faButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello Button Rotation",Toast.LENGTH_SHORT).show();
            }
        });

        // FontAwesomeButton with ClickListener
        FontAwesomeButton faButton4 = findViewById(R.id.btnFaAlpha);
        faButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Hello Button Alpha",Toast.LENGTH_SHORT).show();
            }
        });

        // Floating Action Button with ClickListener
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FontAwesomeView viewFaTest2 = findViewById(R.id.viewFaTest2);
                // Set FontAwesome Icon for 'FontAwesomeView' programmatically
                viewFaTest2.setFaIcon(context, R.string.fa_address_card, Color.RED, 36);
                Toast.makeText(getApplicationContext(),"icon for view 'viewFaTest2' set programmatically",Toast.LENGTH_SHORT).show();
            }
        });

        // Set FontAwesome Icon with 'FontAwesomeDrawable' programmatically
        de.th.fontawesome.FontAwesomeDrawable drawable = new de.th.fontawesome.FontAwesomeDrawable(this, R.string.fa_address_card);
        drawable.setTextColor(ContextCompat.getColor(this, android.R.color.white));
        fab.setImageDrawable(drawable);

    }
}