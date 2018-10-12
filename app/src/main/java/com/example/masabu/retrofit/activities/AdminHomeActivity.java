package com.example.masabu.retrofit.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.fragments.HomeFragments;
import com.example.masabu.retrofit.fragments.QuickMenuFragments;
import com.example.masabu.retrofit.fragments.SettingsFragments;
import com.example.masabu.retrofit.models.User;
import com.example.masabu.retrofit.storage.SharedPrefManager;

public class AdminHomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new HomeFragments());
    }

    private void displayFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerr, fragment)
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggeedIn()){
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        switch (item.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragments();
                break;
            case R.id.menu_quick_menu:
                fragment = new QuickMenuFragments();
                break;
            case R.id.menu_settings:
                fragment = new SettingsFragments();
                break;
        }
        if (fragment != null){
            displayFragment(fragment);
        }

        return false;
    }
}
