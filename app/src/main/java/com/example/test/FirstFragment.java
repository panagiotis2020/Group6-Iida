package com.example.test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import android.animation.ValueAnimator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.test.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private ImageView imageView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        imageView = view.findViewById(R.id.imageView);
        container.addView(imageView);

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Set the starting and ending coordinates for the object
        int startX = 0;
        int startY = -900;
        int endX = 400;
        int endY = 500;

        // Set up the ValueAnimator to animate the object's position
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(10000);  // 1 second
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float fraction = animation.getAnimatedFraction();
                int x = (int) (startX + (endX - startX) * fraction);
                int y = (int) (startY + (endY - startY) * fraction);

                // Set the object's new position
                imageView.setTranslationX(x);
                imageView.setTranslationY(y);
            }
        });
        animator.start();
    }
}