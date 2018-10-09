package sapphyx.gsd.com.drywall.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import sapphyx.gsd.com.drywall.fragments.collections.CollectionsTen;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsEight;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsFive;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsFour;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsNine;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsOne;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsSeven;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsSix;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsThree;
import sapphyx.gsd.com.drywall.fragments.collections.CollectionsTwo;
import sapphyx.gsd.com.drywall.util.SettingsProvider;

/**
 *A rather ugly activity that shows a category fragment in an Activity depending on the position that was clicked
 * previously in the categories adapter
 */

public class FrameActivity extends AppCompatActivity {

    Integer categoryPosition;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        categoryPosition = SettingsProvider.get(this).getInt("POSITION", 0);

        FragmentManager fm = getSupportFragmentManager();
        fragment = fm.findFragmentByTag("myFragmentTag");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();

            if(categoryPosition.equals(0)) {
                fragment = new CollectionsOne();
                getSupportActionBar().setTitle("Blog");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(1)) {
                fragment = new CollectionsTwo();
                getSupportActionBar().setTitle("GocalSD");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(2)) {
                fragment = new CollectionsThree();
                getSupportActionBar().setTitle("Environments");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(3)) {
                fragment = new CollectionsFour();
                getSupportActionBar().setTitle("OEM");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(4)) {
                fragment = new CollectionsFive();
                getSupportActionBar().setTitle("Colors");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(5)) {
                fragment = new CollectionsSix();
                getSupportActionBar().setTitle("CityScapes");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(6)) {
                fragment = new CollectionsSeven();
                getSupportActionBar().setTitle("Life");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(7)) {
                fragment = new CollectionsEight();
                getSupportActionBar().setTitle("Pixel");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(8)) {
                fragment = new CollectionsNine();
                getSupportActionBar().setTitle("Earth");
                getSupportActionBar().setSubtitle("Browsing Category");
            }
            if(categoryPosition.equals(9)) {
                fragment = new CollectionsTen();
                getSupportActionBar().setTitle("Seasons");
                getSupportActionBar().setSubtitle("Browsing Category");
            }

            ft.add(android.R.id.content, fragment, "collectionsTag");
            ft.commit();
        }
    }
}