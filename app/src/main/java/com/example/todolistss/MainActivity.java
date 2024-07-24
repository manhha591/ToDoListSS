package com.example.todolistss;

import android.content.Intent;
import android.os.Bundle;

import com.example.todolistss.ui.SecondActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.todolistss.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);
        binding.button.setOnClickListener(view -> {
            navController.popBackStack(); // Xóa tất cả các fragment trước home
            navController.navigate(R.id.navigation_notifications);
            startActivityForResult(new Intent(MainActivity.this, SecondActivity.class), 1);
        });
//        binding.navView.setOnNavigationItemSelectedListener(item -> {
//            if (item.getItemId() == R.id.navigation_home) {
//                navController.navigate(R.id.navigation_home);
//                return true;
//            } else if (item.getItemId() == R.id.navigation_dashboard) {
//                navController.navigate(R.id.navigation_dashboard);
//                return true;
//            } else if (item.getItemId() == R.id.navigation_notifications) {
//                navController.navigate(R.id.navigation_notifications);
//                return true;
//            }
//            return false;
//        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                navController.navigate(R.id.navigation_home);
            }
        }
    }
}