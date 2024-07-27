package com.example.todolistss;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.todolistss.ui.dashboard.DashboardFragment;
import com.example.todolistss.ui.home.HomeFragment;
import com.example.todolistss.ui.notifications.NotificationsFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fragmentActivity, @NonNull Lifecycle lifecycle) {
        super(fragmentActivity, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new DashboardFragment();
            case 2:
                return new NotificationsFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Số lượng các Fragment
    }
}
