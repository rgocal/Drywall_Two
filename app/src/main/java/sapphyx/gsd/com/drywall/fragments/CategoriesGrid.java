package sapphyx.gsd.com.drywall.fragments;

import android.app.WallpaperManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import sapphyx.gsd.com.drywall.R;
import sapphyx.gsd.com.drywall.adapters.CategoriesSelector;
import sapphyx.gsd.com.drywall.adapters.CategoryItems;
import sapphyx.gsd.com.drywall.adapters.ProvidersAdapter;
import sapphyx.gsd.com.drywall.util.AppManager;
import sapphyx.gsd.com.drywall.util.GridSpacingItemDecoration;
import sapphyx.gsd.com.drywall.util.RoundDialogHelper;
import sapphyx.gsd.com.drywall.util.SettingsProvider;

import static sapphyx.gsd.com.drywall.activity.MainActivityBase.ARGS_INSTANCE;

/**
 * This fragment list all of the categories we have available to the user
 * Use the categories as a position item for inflating the individual fragments
 */

public class CategoriesGrid extends Fragment{

    private List<CategoryItems> categoriesList = new ArrayList<>();

    int numColumns = 2;
    String oneCount, twoCount, threeCount, fourCount, fiveCount, sixCount, sevenCount, eightCount, nineCount, tenCount;
    ImageView closeLayoutButton;
    FrameLayout providerHolder;

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private RecyclerView providerList, categoryList;
    private CategoriesSelector categoriesAdapter;
    private ProvidersAdapter providerAdapter;
    private GridLayoutManager mLayoutManager;

    public CategoriesGrid() {
    }

    public static CategoriesGrid newInstance(int instance) {
        Bundle args = new Bundle();
        args.putInt(ARGS_INSTANCE, instance);
        CategoriesGrid fragment = new CategoriesGrid();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.category_grid_layout, container, false);
        setHasOptionsMenu(true);

        categoryList = v.findViewById(R.id.category_list);
        providerList = v.findViewById(R.id.provider_list);
        closeLayoutButton = v.findViewById(R.id.close_providers);
        providerHolder = v.findViewById(R.id.providers_holder);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (!prefs.contains("CategoriesMsg")) {
            RoundDialogHelper alert = new RoundDialogHelper();
            alert.showCategoriesDialog(getActivity(), getResources().getString(R.string.first_categories_title),  getResources().getString(R.string.first_categories_message));
        }

        closeLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                providerHolder.setVisibility(View.GONE);
                providerList.setVisibility(View.GONE);
            }
        });

        //Categories Listview
        categoriesAdapter = new CategoriesSelector((ArrayList<CategoryItems>) categoriesList, getContext());

        mLayoutManager = new GridLayoutManager(getContext(), numColumns);
        categoryList.addItemDecoration(new GridSpacingItemDecoration(numColumns, dpToPx(6), true));
        categoryList.setAdapter(categoriesAdapter);
        categoryList.setHasFixedSize(true);
        categoryList.setLayoutManager(mLayoutManager);

        //Providers Listview
        providerAdapter = new ProvidersAdapter(getContext(), new AppManager(getContext()).getInstalledPackages());

        LinearLayoutManager providersManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        providerList.addItemDecoration(new GridSpacingItemDecoration(numColumns, dpToPx(0), false));
        providerList.setAdapter(providerAdapter);
        providerList.setHasFixedSize(true);
        providerList.setLayoutManager(providersManager);

        providerAdapter.notifyDataSetChanged();

        prepareCategoryData(v);

        return  v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.categories_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_live:
                Intent intent = new Intent(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
                startActivityForResult(intent, 155);
                break;
        }
        return true;

    }

    private void prepareCategoryData(View v) {

        oneCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryOneCount", 1));
        twoCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryTwoCount", 1));
        threeCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryThreeCount", 1));
        fourCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryFourCount", 1));
        fiveCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryFiveCount", 1));
        sixCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categorySixCount", 1));
        sevenCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categorySevenCount", 1));
        eightCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryEightCount", 1));
        nineCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryNineCount", 1));
        tenCount = String.valueOf(SettingsProvider.get(getContext()).getInt("categoryTenCount", 1));

        CategoryItems ONE = new CategoryItems(v, "MY BLOG", oneCount, R.drawable.camera_gopro);
        categoriesList.add(ONE);

        CategoryItems TWO = new CategoryItems(v, "GOCALSD", twoCount, R.drawable.cube_send);
        categoriesList.add(TWO);

        CategoryItems THREE = new CategoryItems(v, "ENVIRONMENT", threeCount, R.drawable.image_area);
        categoriesList.add(THREE);

        CategoryItems FOUR = new CategoryItems(v, "OEM", fourCount, R.drawable.cellphone_text);
        categoriesList.add(FOUR);

        CategoryItems FIVE = new CategoryItems(v, "COLORS", fiveCount, R.drawable.palette);
        categoriesList.add(FIVE);

        CategoryItems SIX = new CategoryItems(v, "CITYSCAPE", sixCount, R.drawable.city_variant_outline);
        categoriesList.add(SIX);

        CategoryItems SEVEN = new CategoryItems(v, "LIFE", sevenCount, R.drawable.dog_side);
        categoriesList.add(SEVEN);

        CategoryItems EIGHT = new CategoryItems(v, "PIXEL", eightCount, R.drawable.google_glass);
        categoriesList.add(EIGHT);

        CategoryItems NINE = new CategoryItems(v, "EARTH", nineCount, R.drawable.earth_box);
        categoriesList.add(NINE);

        CategoryItems TEN = new CategoryItems(v, "SEASONS", tenCount, R.drawable.earth_box);
        categoriesList.add(TEN);

        categoriesAdapter.notifyDataSetChanged();


    }
}
