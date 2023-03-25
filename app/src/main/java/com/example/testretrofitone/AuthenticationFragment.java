package com.example.testretrofitone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AuthenticationFragment extends Fragment {
    TextView buttonSignIn, buttonCreate, editEmail, editPassword;
    AnimeInterface action;
    public final static int ACTION_CLOSE_AUTH_PAGE = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_authentication, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        buttonCreate = view.findViewById(R.id.btn_sign_up);
        buttonSignIn = view.findViewById(R.id.btn_sign_in);
        editEmail = view.findViewById(R.id.input_email);
        editPassword = view.findViewById(R.id.input_password);


        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSignIn();
            }
        });

    }

    private void createUser() {
        runAction();
    }

    private void userSignIn() {
        runAction();
    }

    private void runAction(){
        action = (AnimeInterface) getActivity();
        action.setAction(ACTION_CLOSE_AUTH_PAGE);
    }
}
