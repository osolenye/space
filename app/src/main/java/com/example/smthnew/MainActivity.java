package com.example.smthnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.smthnew.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWriteWish.setOnClickListener(v -> {
            binding.etMyWish.setVisibility(View.VISIBLE);
            binding.btnPassWish.setVisibility(View.VISIBLE);
            binding.btnWriteWish.setVisibility(View.INVISIBLE);
        });


        binding.btnPassWish.setOnClickListener(v1 -> {

            try {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My message");
                emailIntent.putExtra(Intent.EXTRA_TEXT, binding.etMyWish.getText().toString());

                if (emailIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(emailIntent);
                }
            } catch (Exception ex) {
                Toast.makeText(this, "You have some problems", Toast.LENGTH_SHORT).show();
            }
        });
    }
}