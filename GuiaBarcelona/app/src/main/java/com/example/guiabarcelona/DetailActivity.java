package com.example.guiabarcelona;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.IntentCompat;

import com.example.guiabarcelona.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_PLACE = "extra_place";

    private ActivityDetailBinding binding;
    private Place place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        place = IntentCompat.getParcelableExtra(getIntent(), EXTRA_PLACE, Place.class);
        if (place == null) {
            Toast.makeText(this, R.string.error_no_place, Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(place.getName());
        }

        binding.imgPlace.setImageResource(place.getImageRes());
        binding.txtName.setText(place.getName());
        binding.txtAddress.setText(place.getAddress());
        binding.txtDescription.setText(place.getDescription());

        binding.btnMap.setOnClickListener(v -> openMap());
        binding.btnCall.setOnClickListener(v -> dial());
        binding.btnWeb.setOnClickListener(v -> openWeb());
        binding.btnShare.setOnClickListener(v -> sharePlace());
    }

    private void openMap() {
        String label = Uri.encode(place.getName());
        String coords = place.getLatitude() + "," + place.getLongitude();
        Uri uri = Uri.parse("geo:" + coords + "?q=" + coords + "(" + label + ")");
        launch(new Intent(Intent.ACTION_VIEW, uri));
    }

    private void dial() {
        launch(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + place.getPhone())));
    }

    private void openWeb() {
        launch(new Intent(Intent.ACTION_VIEW, Uri.parse(place.getWebsite())));
    }

    private void sharePlace() {
        String text = place.getName() + "\n" + place.getAddress() + "\n" + place.getWebsite();
        Intent send = new Intent(Intent.ACTION_SEND);
        send.setType("text/plain");
        send.putExtra(Intent.EXTRA_SUBJECT, place.getName());
        send.putExtra(Intent.EXTRA_TEXT, text);
        launch(Intent.createChooser(send, getString(R.string.share_chooser)));
    }

    private void launch(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, R.string.error_no_app, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
