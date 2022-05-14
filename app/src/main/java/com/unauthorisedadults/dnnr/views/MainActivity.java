package com.unauthorisedadults.dnnr.views;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseUser;
import com.unauthorisedadults.dnnr.R;
import com.unauthorisedadults.dnnr.viewModels.MainViewModel;

import java.util.Objects;

import pub.devrel.easypermissions.EasyPermissions;



@RequiresApi(api = Build.VERSION_CODES.S)
public class MainActivity extends AppCompatActivity {

    TextView username;
    MainViewModel mainViewModel;
    ImageView container;
    FirebaseUser user;

    public static final String[] BLUETOOTH_PERMISSIONS_S = {
            Manifest.permission.BLUETOOTH_SCAN,
            Manifest.permission.BLUETOOTH_CONNECT
    };

    private BluetoothAdapter adapter;

    private DrawerLayout drawerLayout;
    private NavigationView navigationDrawer;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationDrawer = findViewById(R.id.drawer_nav_view);
        getWindow().setStatusBarColor(getColor(R.color.BG_Red));

        setupNavigation();
        Bluetooth();

        checkSignedIn();
    }

    private void setupNavigation() {
        Toolbar toolbar = findViewById(R.id.DNNR_Toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home_fragment)
                .setOpenableLayout(drawerLayout)
                .build();
        navController = Navigation.findNavController(this, R.id.fragment_container);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationDrawer, navController);

        setupDrawerItems();
    }

    private void setupDrawerItems() {
        navigationDrawer.setNavigationItemSelectedListener(v -> {
            int itemId = v.getItemId();

            //Todo: Drawer menu actions...
            return false;
    });
    }

    /*Start group metoden sender brugeren til et group owner view. I dette view bliver gruppen oprettet
     og brugeren bliver sat som group owner*/
    public void startGroup(View view) {
      /*  Intent intent = new Intent(MainActivity.this, StartGroupOwnerActivity.class);
        intent.putExtra(UTIL.USER, user);
        startActivity(intent);*/
        Context context = getApplicationContext();
        Intent intent = new Intent(context, VoteActivity.class);
        startActivity(intent);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //TODO: Appbar button functionality made here!

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        navController = Navigation.findNavController(this, R.id.fragment_container);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bluetooth();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }



    private void checkSignedIn() {
        mainViewModel.getUser().observe(this, user -> {
            if (user != null) {
                if (user.getDisplayName() != null)
                    username.setText(user.getDisplayName());
                else if (user.isAnonymous())
                    username.setText("guest");
            } else
                startLogin();
        });
    }

    private void startLogin() {
        startActivity(new Intent(this, SignInActivity.class));

    }


    //Gør sådan at easy permissions kan tage over og sørger for permissions
    @SuppressLint("MissingPermission")
    private void Bluetooth() {
        adapter = BluetoothAdapter.getDefaultAdapter();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (!EasyPermissions.hasPermissions(this, BLUETOOTH_PERMISSIONS_S)) {
                EasyPermissions.requestPermissions(this, "Permissions Required", 1, BLUETOOTH_PERMISSIONS_S);
            }
            if (!adapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(enableBtIntent);
            }
        }
    }
}

