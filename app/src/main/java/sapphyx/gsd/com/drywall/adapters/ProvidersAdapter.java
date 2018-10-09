package sapphyx.gsd.com.drywall.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sapphyx.gsd.com.drywall.R;
import sapphyx.gsd.com.drywall.util.AppManager;
import sapphyx.gsd.com.drywall.util.SettingsProvider;

public class ProvidersAdapter extends RecyclerView.Adapter<ProvidersAdapter.MyViewHolder> {

    private List<String> mDataSet;
    private Context mContext;

    public ProvidersAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.mDataSet = list;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.provider_item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        AppManager appsManager = new AppManager(mContext);
        final String packageName = mDataSet.get(position);
        Drawable icon = appsManager.getAppIconByPackageName(packageName);
        String label = appsManager.getApplicationLabelByPackageName(packageName);

        holder.name.setText(label);
        holder.appIcon.setImageDrawable(icon);

        SettingsProvider.get(mContext)
                .edit()
                .putInt("wallpaperProviders", getItemCount())
                .apply();

        holder.itemFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(packageName);
                if(intent != null){
                    mContext.startActivity(intent);
                }else {
                    Toast.makeText(mContext,packageName + "Couldn't find application", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView appIcon;
        public LinearLayout itemFrame;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.app_title);
            appIcon = view.findViewById(R.id.app_icon);
            itemFrame = view.findViewById(R.id.app_frame);
        }
    }
}