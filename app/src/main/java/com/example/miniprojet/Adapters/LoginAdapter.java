package com.example.miniprojet.Adapters;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.miniprojet.LoginTabFragment;
import com.example.miniprojet.SignupTabFragment;

public class LoginAdapter extends FragmentPagerAdapter {
    private Context context;
    int totalTabs;

    public LoginAdapter(FragmentManager fm, Context context, int tooltabs) {
        super(fm);
        this.context = context;
        this.totalTabs = tooltabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LoginTabFragment loginTabFragment = new LoginTabFragment();
                return loginTabFragment;
            case 1:
                SignupTabFragment signupTab = new SignupTabFragment();
                return signupTab;
            default:
                return null;
        }
    }
}
