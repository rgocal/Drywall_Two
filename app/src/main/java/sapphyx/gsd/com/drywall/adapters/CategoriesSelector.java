package sapphyx.gsd.com.drywall.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import sapphyx.gsd.com.drywall.R;
import sapphyx.gsd.com.drywall.activity.FrameActivity;
import sapphyx.gsd.com.drywall.util.AnimationHelper;
import sapphyx.gsd.com.drywall.util.SettingsProvider;

public class CategoriesSelector extends RecyclerView.Adapter<CategoriesSelector.MyViewHolder> {

    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int THREE = 2;
    public static final int FOUR = 3;
    public static final int FIVE = 4;
    public static final int SIX = 5;
    public static final int SEVEN = 6;
    public static final int EIGHT = 7;
    public static final int NINE = 8;
    public static final int TEN = 9;

    private ArrayList<CategoryItems> actionList;
    private Context mContext;

    public CategoriesSelector(ArrayList<CategoryItems> actionList, Context context) {
        this.mContext = context;
        this.actionList = actionList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final CategoryItems actions = actionList.get(position);

        holder.category.setText(actions.getCategory());
        holder.count.setText(actions.getCount());

        SettingsProvider.get(mContext)
                .edit()
                .putInt("categoryCount", getItemCount())
                .apply();

        switch (position){
            case ONE: {
                Glide.with(mContext)
                        .load("https://gocalsdb.files.wordpress.com/2018/08/download_20180718_2116496263314472983358047.jpg?w=788")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case TWO: {
                Glide.with(mContext)
                        .load("https://raw.githubusercontent.com/rgocal/Catalyst_Wallpapers/master/drawable-nodpi/wallpaper_1.jpg")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case THREE: {
                Glide.with(mContext)
                        .load("https://images.unsplash.com/photo-1512099053734-e6767b535838?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=5f77b37ad8ff3310ccfe9f044bda299f&auto=format&fit=crop&w=928&q=80")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case FOUR: {
                Glide.with(mContext)
                        .load("https://cdn.wccftech.com/wp-content/uploads/2017/08/Android-Oreo-wallpapers-4-740x658.jpg")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case FIVE: {
                holder.categoryBm.setImageResource(R.drawable.app_background);
            }
        }

        switch (position){
            case SIX: {
                Glide.with(mContext)
                        .load("https://images.unsplash.com/photo-1530592503159-ec956398ba3d?ixlib=rb-0.3.5&s=f38c8748114eae7cc092d6293907bb3c&auto=format&fit=crop&w=634&q=80")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case SEVEN: {
                Glide.with(mContext)
                        .load("https://images.unsplash.com/photo-1527647360380-128bf1a01e1f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=79d930d867d9332d4117941eb3d904ad&auto=format&fit=crop&w=633&q=80")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case EIGHT: {
                Glide.with(mContext)
                        .load("https://www.xyztimes.com/wp-content/uploads/2016/10/google-pixel-default-wallpaper.jpg")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position){
            case NINE: {
                Glide.with(mContext)
                        .load("https://images.unsplash.com/photo-1529401990940-3a1aecf05547?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=8238b8abd8944e93f420c75663f9905c&auto=format&fit=crop&w=800&q=80")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        switch (position) {
            case TEN: {
                Glide.with(mContext)
                        .load("https://images.unsplash.com/photo-1515094854286-bc6b38a1326f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=e31d0fa575713ce0f73cfc4af1260048&auto=format&fit=crop&w=700&q=80")
                        .thumbnail(0.3f)
                        .into(holder.categoryBm);
            }
        }

        holder.categoryFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                try {
                    switch (position) {
                        case ONE:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();

                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case TWO:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case THREE:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case FOUR:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case FIVE:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case SIX:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case SEVEN:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case EIGHT:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case NINE:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                        case TEN:
                            try {
                                //Launcher Activity with string data
                                final Intent intent = new Intent(mContext, FrameActivity.class);
                                mContext.startActivity(intent);

                                SettingsProvider.get(mContext)
                                        .edit()
                                        .putInt("POSITION", holder.getAdapterPosition())
                                        .apply();
                            }catch (Exception e){
                                Log.e("CATEGORY", "Selection was unavailable");
                            }
                            break;
                    }
                }catch (IndexOutOfBoundsException e) {
                    Log.e("Minibar Exception", "Position error");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return actionList == null ? 0 : actionList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category, count;
        public ImageView categoryBm;
        public FrameLayout categoryFrame;

        public MyViewHolder(View view) {
            super(view);
            category = view.findViewById(R.id.category_title);
            count = view.findViewById(R.id.category_count);
            categoryBm = view.findViewById(R.id.category_bm);
            categoryFrame = view.findViewById(R.id.category_frame);

            AnimationHelper.quickViewReveal(view.findViewById(R.id.category_bm), 300);
        }
    }
}