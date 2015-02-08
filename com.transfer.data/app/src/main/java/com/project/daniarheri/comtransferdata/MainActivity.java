package com.project.daniarheri.comtransferdata;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {

    int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText edittext = (EditText) findViewById(R.id.text_pesan);
        String message = edittext.getText().toString();
        intent.putExtra("pesan",message);
        startActivity(intent);
    }

    public void openURL(View view) {

        EditText URL = (EditText) findViewById(R.id.url);
        String url = URL.getText().toString();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    public void openChallenge(View view) {
        Intent intent = new Intent(this, Challenge.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("returnKey1")) {
                TextView viewresult = (TextView) findViewById(R.id.view_result);
                viewresult.setText("Jawaban Anda = "+data.getExtras().getString("returnKey1"));
                Toast.makeText(this, data.getExtras().getString("returnKey1"),Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void openImage(View view) {


        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }
}
