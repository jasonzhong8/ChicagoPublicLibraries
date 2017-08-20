package com.jasonzhong.chicagopubliclibraries.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.view.WindowManager;

/**
 * Created by junzhong on 2017-08-20.
 */

public class Util {

    public static void openAlertDialog(final Activity context, String tile, String message) {
        try {
            new AlertDialog.Builder(context).setTitle(tile)
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.finishAffinity(context);
                        }
                    }).show();
        } catch (WindowManager.BadTokenException e) {
            e.printStackTrace();
        }
    }
}
