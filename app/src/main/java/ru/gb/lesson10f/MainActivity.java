package ru.gb.lesson10f;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MainActivity extends AppCompatActivity
        implements FirstFragment.FirstController, SecondFragment.SecondController {

    public static final String SECOND_TAG = "SECOND_TAG";

    private FragmentManager manager;
    private int orientation = ORIENTATION_PORTRAIT;

    private SecondFragment second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orientation = getResources().getConfiguration().orientation;

        manager = getSupportFragmentManager();


        second = (SecondFragment) manager.findFragmentByTag(SECOND_TAG);

        if(savedInstanceState == null)
        {
            manager
                    .beginTransaction()
                    .replace(R.id.host_fist, new FirstFragment())
                    .commit();
        }

        if(second != null)
        {
            // выдернуть второй фрагмент из транзакции
            // !!!
            manager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            manager.beginTransaction().remove(second).commit();
            // !!!
            manager.executePendingTransactions();
            // добавить второй фрагмент в "новое" место
            manager.beginTransaction().replace(
                    orientation == ORIENTATION_PORTRAIT ? R.id.host_fist: R.id.host_second,
                    second,
                    SECOND_TAG
            )
                    .addToBackStack(null)
                    .commit();
        }

    }

    @Override
    public void firstAction(String text) {
        manager
                .beginTransaction()
                .replace(
                        orientation == ORIENTATION_PORTRAIT ? R.id.host_fist : R.id.host_second,
                        new SecondFragment(),
                        SECOND_TAG
                )
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void secondAction() {

    }
}