package com.example.miniprojet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.miniprojet.Adapters.LoginAdapter;
import com.facebook.CallbackManager;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class LoginActivity extends AppCompatActivity {
    ViewPager viewpager;
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    Target  target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            SharePhoto photo = new SharePhoto.Builder().setBitmap(bitmap).build();
            if(ShareDialog.canShow(SharePhotoContent.class)){
                SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
                shareDialog.show(content);
            }
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            Toast.makeText(LoginActivity.this, "kkkkk"+errorDrawable, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            Toast.makeText(LoginActivity.this, "aaaa", Toast.LENGTH_SHORT).show();
        }
    };
    FloatingActionButton fb, google, twitter;
    private static final int NUM_PAGES = 2;
    private LoginActivity.ScreenSlidePlagerAdapter plagerAdapter;
    float v = 0;
    Button SignIn,SignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //tabLayout=(TabLayout) findViewById(R.id.tab_layout);

        callbackManager =CallbackManager.Factory.create();
        shareDialog=new ShareDialog(this);
        viewpager = findViewById(R.id.view_pager);
        fb = findViewById(R.id.fab_fb);
        google = findViewById(R.id.fab_google);
        twitter = findViewById(R.id.fab_twitter);
        //tabLayout.addTab(tabLayout.newTab().setText("Login"));
        //tabLayout.addTab(tabLayout.newTab().setText("Sign Up"));
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), this, 2);
        viewpager.setAdapter(adapter);
        //viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        fb.setTranslationY(300);
        google.setTranslationY(300);
        twitter.setTranslationY(300);
        fb.setAlpha(v);
        google.setAlpha(v);
        twitter.setAlpha(v);

        //  tabLayout.setAlpha(v);
        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
        plagerAdapter = new ScreenSlidePlagerAdapter(getSupportFragmentManager(), 0);
        viewpager.setAdapter(plagerAdapter);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "waaa", Toast.LENGTH_SHORT).show();
                Picasso.with(getApplicationContext()).load("C:\\Users\\DELL\\Desktop\\MiniProjet\\app\\src\\main\\res\\drawable-v24\\app_logo.png").into(target);
            }
        });
    }

    public void fonction(View view) {
        viewpager.setCurrentItem(0);
        SignIn=findViewById(R.id.SignIn);
        SignIn.setBackgroundResource(R.drawable.button_bg);
        SignUp=findViewById(R.id.SignUp);
        SignUp.setBackgroundResource(R.drawable.button_bg1);
    }

    public void fonctionIheb(View view) {
        viewpager.setCurrentItem(1);
        SignIn=findViewById(R.id.SignIn);
        SignIn.setBackgroundResource(R.drawable.button_bg1);
        SignUp=findViewById(R.id.SignUp);
        SignUp.setBackgroundResource(R.drawable.button_bg);
    }

    private static class ScreenSlidePlagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSlidePlagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    LoginTabFragment tab1 = new LoginTabFragment();

                    return tab1;
                case 1:
                    SignupTabFragment tab2 = new SignupTabFragment();
                    return tab2;


            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}