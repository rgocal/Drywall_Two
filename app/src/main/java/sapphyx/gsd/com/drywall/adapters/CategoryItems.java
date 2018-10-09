package sapphyx.gsd.com.drywall.adapters;

import android.view.View;
import android.widget.ImageView;

public class CategoryItems {

    private String category, count;
    private int image;

    public CategoryItems(View v, String category, String count, int image) {
        this.category = category;
        this.count = count;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String name) {
        this.category = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String name) {
        this.count = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}