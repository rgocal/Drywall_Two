package sapphyx.gsd.com.drywall.activity;

import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import sapphyx.gsd.com.drywall.R;
import sapphyx.gsd.com.drywall.fragments.CategoriesGrid;
import sapphyx.gsd.com.drywall.fragments.Device;
import sapphyx.gsd.com.drywall.fragments.Featured;
import sapphyx.gsd.com.drywall.util.RoundDialogHelper;
import sapphyx.gsd.com.drywall.views.IntrusiveTextView;
import sapphyx.gsd.com.drywall.views.RevealLayout;

/**
 * The Main Activity that uses bottombar to inflate three main fragments
 */

public class MainActivityBase extends AppCompatActivity {

    public static final String ARGS_INSTANCE = "sapphyx.gsd.com.drywall.argsInstance";

    private RevealLayout mRevealLayout;
    Toolbar toolbar;
    IntrusiveTextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new);

        ValueAnimator animator = ValueAnimator.ofArgb(Color.TRANSPARENT, ContextCompat.getColor(getApplicationContext(), R.color.transparent_primary));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int color = (Integer) valueAnimator.getAnimatedValue();
                getWindow().setNavigationBarColor(color);
                getWindow().setStatusBarColor(color);
            }
        });
        animator.setDuration(300);
        animator.start();

        toolbar = findViewById(R.id.toolbar);
        mRevealLayout = findViewById(R.id.frame_layout);
        toolbarTitle = findViewById(R.id.toolbar_title);

        AppCompatActivity activity = this;
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        activity.getSupportActionBar().setTitle("");

        toolbarTitle.setText("Explore");

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.contains("FirstTime")) {
            RoundDialogHelper alert = new RoundDialogHelper();
            alert.showAlertDialog(this, getResources().getString(R.string.first_public_message));
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = Device.newInstance(0);
                                mRevealLayout.show(700);
                                break;
                            case R.id.action_item2:
                                selectedFragment = Featured.newInstance(1);
                                mRevealLayout.show(700);
                                break;
                            case R.id.action_item3:
                                selectedFragment = CategoriesGrid.newInstance(2);
                                mRevealLayout.show(700);
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Device.newInstance(0));
        transaction.commit();
    }

}