package sapphyx.gsd.com.drywall.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sapphyx.gsd.com.drywall.R;

public class AppManager {

    private Context mContext;
    private String packageToHide = "sapphyx.gsd.com.drywall";
    private String livePicker = "com.android.wallpaper.livepicker";


    public AppManager(Context context){
        mContext = context;
    }

    public List<String> getInstalledPackages(){

        final PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_SET_WALLPAPER);
        List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);
        List<String> packageNames = new ArrayList<>();
        for(ResolveInfo resolveInfo : resolveInfoList){
            ActivityInfo activityInfo = resolveInfo.activityInfo;

            if(!packageToHide.equals(resolveInfo.activityInfo.packageName)){
                if(!livePicker.equals(resolveInfo.activityInfo.packageName)) {
                    packageNames.add(activityInfo.applicationInfo.packageName);
                }
            }
        }

        Collections.sort(resolveInfoList, new ResolveInfo.DisplayNameComparator(pm));

        return packageNames;

    }

    public Drawable getAppIconByPackageName(String packageName){
        Drawable icon;
        try{
            icon = mContext.getPackageManager().getApplicationIcon(packageName);
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            // Get a default icon
            icon = ContextCompat.getDrawable(mContext, R.mipmap.ic_app_icon);
        }
        return icon;
    }

    public String getApplicationLabelByPackageName(String packageName){
        PackageManager packageManager = mContext.getPackageManager();
        ApplicationInfo applicationInfo;
        String label = "Unknown";
        try {
            applicationInfo = packageManager.getApplicationInfo(packageName, 0);
            if(applicationInfo!=null){
                label = (String)packageManager.getApplicationLabel(applicationInfo);
            }

        }catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return label;
    }
}