package sapphyx.gsd.com.drywall.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import sapphyx.gsd.com.drywall.R;

public class RoundDialogHelper {

    /**
     * A Helper Class for a re-useable round dialog for messages and alerts
     * @param activity
     * @param msg
     */

    public void showAlertDialog(Activity activity, String msg){

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.round_dialog);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("FirstTime", true);
                editor.apply();
                dialog.dismiss();
            }
        });

        AnimationHelper.animateGroup(
                dialog.findViewById(R.id.text_dialog),
                dialog.findViewById(R.id.btn_dialog)
        );

        dialog.show();
    }

    public void showMessageDialog(Activity activity, String msg){

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.round_dialog);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        AnimationHelper.animateGroup(
                dialog.findViewById(R.id.text_dialog),
                dialog.findViewById(R.id.btn_dialog)
        );

        dialog.show();
    }

    public void showCategoriesDialog(Activity activity, String title, String msg){

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_simple_notice);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        TextView textTitle = dialog.findViewById(R.id.text_title_dialog);
        textTitle.setText(title);

        Button cancelButton = dialog.findViewById(R.id.btn_skip);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("CategoriesMsg", true);
                editor.apply();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void showFeaturedDialog(Activity activity, String title, String msg){

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_simple_notice);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        TextView textTitle = dialog.findViewById(R.id.text_title_dialog);
        textTitle.setText(title);

        Button cancelButton = dialog.findViewById(R.id.btn_skip);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("FeaturesMsg", true);
                editor.apply();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
