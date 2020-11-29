package com.example.miniprojet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {
    EditText email,num,adress,pass;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root=(ViewGroup)inflater.inflate(R.layout.signup_tab_fragment,container,false);
        email=root.findViewById(R.id.email1);
        num=root.findViewById(R.id.num1);
        adress=root.findViewById(R.id.adress);
        pass=root.findViewById(R.id.pass1);
        email.setTranslationY(800);
        num.setTranslationY(800);
        adress.setTranslationY(800);
        pass.setTranslationY(800);
        email.setAlpha(v);
        num.setAlpha(v);
        adress.setAlpha(v);
        pass.setAlpha(v);
        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        num.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        adress.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        pass.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();
        return root;
    }
}
