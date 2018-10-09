package sapphyx.gsd.com.drywall.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestOptions;
import com.prof.rssparser.Article;

import java.util.ArrayList;

import sapphyx.gsd.com.drywall.R;
import sapphyx.gsd.com.drywall.activity.DetailsActivity;
import sapphyx.gsd.com.drywall.util.AnimationHelper;
import sapphyx.gsd.com.drywall.util.SettingsProvider;

public class CategoryThreeAdapter extends RecyclerView.Adapter<CategoryThreeAdapter.ViewHolder> {

    private ArrayList<Article> articles;

    private int rowLayout;
    private Context mContext;

    public CategoryThreeAdapter(ArrayList<Article> list, int rowLayout, Context context) {

        this.articles = list;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }


    @Override
    public long getItemId(int item) {
        // TODO Auto-generated method stub
        return item;
    }

    public void clearData() {
        if (articles != null)
            articles.clear();
    }

    @Override
    public CategoryThreeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new CategoryThreeAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CategoryThreeAdapter.ViewHolder viewHolder, final int position) {

        SettingsProvider.get(mContext)
                .edit()
                .putInt("categoryThreeCount", getItemCount())
                .apply();

        viewHolder.title.setText(articles.get(position).getTitle());

        RequestOptions options = new RequestOptions();
        options.placeholder(R.drawable.app_background)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .error(R.drawable.ic_alert)
                .transform(new FitCenter());

        Glide.with(mContext)
                .load(articles.get(position).getImage())
                .apply(RequestOptions.fitCenterTransform())
                .thumbnail(0.3f)
                .apply(options)
                .into(viewHolder.image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent intent = new Intent(mContext, DetailsActivity.class)
                        .putExtra("wall", articles.get(position).getImage())
                        .putExtra("wallTitle", articles.get(position).getTitle());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        LinearLayout titleBg;

        public ViewHolder(View itemView) {
            super(itemView);

            AnimationHelper.animateGroup(itemView.findViewById(R.id.card_image), itemView.findViewById(R.id.card_title), itemView.findViewById(R.id.title_bkg));

            title = itemView.findViewById(R.id.card_title);
            image = itemView.findViewById(R.id.card_image);
            titleBg = itemView.findViewById(R.id.title_bkg);
        }
    }
}