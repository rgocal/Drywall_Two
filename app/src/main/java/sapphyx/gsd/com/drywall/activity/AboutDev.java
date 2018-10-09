package sapphyx.gsd.com.drywall.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shashank.sony.fancyaboutpagelib.FancyAboutPage;

import sapphyx.gsd.com.drywall.R;

/**
 * Created by ry on 2/20/18.
 */

public class AboutDev extends AppCompatActivity {

    String appVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_main);

        Toolbar toolbar = findViewById(R.id.toolbar);

        AppCompatActivity activity = this;
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle("About Drywall");
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryDark));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.colorPrimaryDark));

        try {
            appVersion = getVersion();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        FancyAboutPage fancyAboutPage=findViewById(R.id.fancyaboutpage);
        fancyAboutPage.setCover(R.drawable.gsd_logo);
        fancyAboutPage.setName("Ryan Gocal");
        fancyAboutPage.setDescription("A freelancer android developer that seeks innovation and originality");
        fancyAboutPage.setAppIcon(R.mipmap.ic_launcher_round);
        fancyAboutPage.setAppName("Drywall");
        fancyAboutPage.setVersionNameAsAppSubTitle(appVersion);
        fancyAboutPage.setAppDescription("Drywall, a wallpaper companion app for Sapphyx Launcher, is also a wallpaper provider for all.\n\n" +
                "Built by design, Simple to use, and Great wallpapers awaiting on arrival.\n\n" +
                "Wallpapers used from UnSplash are credited by their original Authors.\n\n" +
                "This application aims to be the odd child from the other wallpaper dashboards you have probably tried, Enjoy!");
        fancyAboutPage.addEmailLink("rgocal09@gmail.com");
        fancyAboutPage.addFacebookLink("https://www.facebook.com/Gocalsd/");
        fancyAboutPage.addTwitterLink("https://twitter.com/Rgocal");
        fancyAboutPage.addGitHubLink("https://github.com/rgocal");
    }

    private String getVersion() throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo = getPackageManager().getPackageInfo("sapphyx.gsd.com.drywall", 0);
        return packageInfo.versionName;
    }
}