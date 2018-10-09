package sapphyx.gsd.com.drywall.activity.frames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sapphyx.gsd.com.drywall.R;
import sapphyx.gsd.com.drywall.fragments.Device;

/**
 * Created by ry on 3/2/18.
 * This activity is used as a shortcut to the Dashboard Fragment
 */

public class DeviceFrame extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        setContentView(R.layout.activity_frame);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.quick_content, new Device())
                .commit();
    }
}
