package ru.gb.lesson10f;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment  extends Fragment implements View.OnClickListener {

    private Button actionButton;
    private EditText actionText;

    @Override
    public void onClick(View view) {
        ((FirstController) requireActivity()).firstAction(
                actionText.getText().toString()
        );
    }

    public interface FirstController {
        void firstAction(String text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        actionButton = view.findViewById(R.id.fragment_first_action);
        actionText = view.findViewById(R.id.fragment_first_text);
        actionButton.setOnClickListener(this);
    }
}
