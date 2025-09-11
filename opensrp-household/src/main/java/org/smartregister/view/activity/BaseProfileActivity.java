package org.smartregister.view.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.AppBarLayout;

import org.smartregister.helper.ImageRenderHelper;

/**
 * Minimal base activity to satisfy dependencies from legacy OpenSRP UI classes.
 * Subclasses can override lifecycle hooks and wire a concrete presenter.
 */
public class BaseProfileActivity extends AppCompatActivity {

    protected Object presenter;
    protected AppBarLayout appBarLayout;
    protected ImageRenderHelper imageRenderHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumption();
    }

    // Hooks for subclasses
    protected void onCreation() { }

    protected void setupViews() { }

    protected void onResumption() { }

    protected void initializePresenter() { }

    // Hook for subclasses to load profile data
    protected void fetchProfileData() { }

    public void startFormActivity(String formName, String entityId, String metaData) { }

    public void displayToast(int resId) {
        try {
            Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
        } catch (Exception ignored) { }
    }
}
