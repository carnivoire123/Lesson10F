package ru.gb.lesson10f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment implements View.OnClickListener {

    private Button actionButton;

    @Override
    public void onClick(View view) {
        ((SecondController)requireActivity()).secondAction();
    }

    public interface SecondController {
        void secondAction();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        actionButton = view.findViewById(R.id.fragment_second_action);
        actionButton.setOnClickListener(this);
    }
}
