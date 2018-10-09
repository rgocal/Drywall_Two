package sapphyx.gsd.com.drywall.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import de.psdev.licensesdialog.LicensesDialog;
import sapphyx.gsd.com.drywall.R;

/**
 * Created by ry on 2/11/18.
 */

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.wallpaper_actions);

        View touchOutSide = findViewById(R.id.touch_outside);
        touchOutSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getFragmentManager().beginTransaction()
                .replace(R.id.quick_content, new About.AboutFragment())
                .commit();
    }

    public static class AboutFragment extends PreferenceFragment {

        private static final String SCHEME = "package";

        private static final String APP_PKG_NAME_21 = "com.android.settings.ApplicationPkgName";
        private static final String APP_PKG_NAME_22 = "pkg";

        private static final String APP_DETAILS_PACKAGE_NAME = "com.android.settings";
        private static final String APP_DETAILS_CLASS_NAME = "com.android.settings.InstalledAppDetails";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.about);

            Preference prefLicense = findPreference("pref_license");
            prefLicense.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    new LicensesDialog.Builder(getActivity())
                            .setNotices(R.raw.licenses)
                            .build()
                            .show();
                    return false;
                }
            });

            Preference prefMore = findPreference("pref_more");
            prefMore.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    final Intent intent = new Intent(getActivity(), AboutDev.class);
                    startActivity(intent);
                    return false;
                }
            });

            Preference prefAbout = findPreference("pref_about");
            prefAbout.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    showInstalledAppDetails(getActivity(), "sapphyx.gsd.com.drywall");
                    return false;
                }
            });
        }

        public void showInstalledAppDetails(Context context, String packageName) {
            Intent intent = new Intent();
            final int apiLevel = Build.VERSION.SDK_INT;
            if (apiLevel >= 9) { // above 2.3
                intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts(SCHEME, packageName, null);
                intent.setData(uri);
            } else { // below 2.3
                final String appPkgName = (apiLevel == 8 ? APP_PKG_NAME_22
                        : APP_PKG_NAME_21);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setClassName(APP_DETAILS_PACKAGE_NAME,
                        APP_DETAILS_CLASS_NAME);
                intent.putExtra(appPkgName, packageName);
            }
            context.startActivity(intent);
        }
    }
}