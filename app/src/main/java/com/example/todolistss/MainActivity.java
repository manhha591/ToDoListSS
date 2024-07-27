package com.example.todolistss;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.example.todolistss.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize ViewPager2 with an adapter
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        binding.viewPager.setAdapter(adapter);

        // Set up the BottomNavigationView
        binding.navView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        // Sync ViewPager2 with BottomNavigationView
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.navView.getMenu().getItem(position).setChecked(true);
            }
        });
    }

    // Handle BottomNavigationView item selection
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.navigation_home) {
            binding.viewPager.setCurrentItem(0);
            return true;
        } else if (itemId == R.id.navigation_dashboard) {
            binding.viewPager.setCurrentItem(1);
            return true;
        } else if (itemId == R.id.navigation_notifications) {
            binding.viewPager.setCurrentItem(2);
            return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            binding.viewPager.setCurrentItem(0); // Navigate to the first tab
        }
    }
}
