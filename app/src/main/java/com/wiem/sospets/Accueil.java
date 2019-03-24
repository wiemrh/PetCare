package com.wiem.sospets;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Accueil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment_Offres()).commit();
            navigationView.setCheckedItem(R.id.nav_offre);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_offre:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Offres()).commit();
                break;
            case R.id.nav_conseil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Conseils()).commit();
                break;
            case R.id.nav_veterinaire:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_MV()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Profile()).commit();
                break;
            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_About()).commit();
                break;
            case R.id.nav_dec:
                Toast.makeText(this, "You are sure that you want to sign out ?", Toast.LENGTH_SHORT).show();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}