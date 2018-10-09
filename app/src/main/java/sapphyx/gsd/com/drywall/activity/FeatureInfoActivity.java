package sapphyx.gsd.com.drywall.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import sapphyx.gsd.com.drywall.R;

/**
 * Created by ry on 2/18/18.
 * A popup activity that simply shows the Wallpaper Title and Description info if any
 */

public class FeatureInfoActivity extends AppCompatActivity {

    public String wallDescription, wallTitle, wallDescriptionTextCatch;

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        wallTitle = getIntent().getStringExtra("wallTitle");
        wallDescription = getIntent().getStringExtra("wallDescription");
        wallDescriptionTextCatch = "No description available";

        setContentView(R.layout.activity_feature_info);

        View touchOutSide = findViewById(R.id.touch_outside);
        touchOutSide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView wallTitleText = findViewById(R.id.wallTitle);
        TextView wallDescriptionText = findViewById(R.id.wallDescription);

        wallTitleText.setText(wallTitle);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                wallDescriptionText.setText(Html.fromHtml(wallDescription, Html.FROM_HTML_MODE_COMPACT));
            } else {
                wallDescriptionText.setText(Html.fromHtml(wallDescription));
            }
        }catch (Exception e){
            Log.e("WallDescription", "Couldn't get description file so add a message");
            wallDescriptionText.setText(wallDescriptionTextCatch);
        }

        wallDescriptionText.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
