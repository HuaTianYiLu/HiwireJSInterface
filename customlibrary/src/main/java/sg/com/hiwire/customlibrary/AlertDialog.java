package sg.com.hiwire.customlibrary;

import android.content.Context;

public class AlertDialog {
    android.app.AlertDialog.Builder alertDialogBuilder;
    android.app.AlertDialog alertDialog;

    private void createBuilder(Context mContext) {
        alertDialogBuilder = new android.app.AlertDialog.Builder(mContext);
    }

    private void setPositiveButtonLabel(String label) {
        if (alertDialogBuilder != null) {
            alertDialogBuilder.setPositiveButton(label, null);
        }
    }

    private void createDialog() {
        if (alertDialogBuilder != null) {
            alertDialog = alertDialogBuilder.create();
        }
    }

    private void setTitle(String title) {
        if (alertDialog != null) {
            if (title == null) {
                alertDialog.setTitle(R.string._hw_alert_dialog_title);
            } else {
                alertDialog.setTitle(title);
            }
        }
    }

    public AlertDialog(Context mContext) {
        if (mContext == null) {
            return;
        }
        //alertDialogBuilder = new android.app.AlertDialog.Builder(mContext);
        createBuilder(mContext);
        //alertDialogBuilder.setPositiveButton(R.string._hw_alert_dialog_positive_button_label, null);
        setPositiveButtonLabel(mContext.getResources().getString(R.string._hw_alert_dialog_positive_button_label));
        //alertDialog = alertDialogBuilder.create();
        createDialog();
        //alertDialog.setTitle(R.string._hw_alert_dialog_title);
        setTitle(mContext.getResources().getString(R.string._hw_alert_dialog_title));
    }

    public AlertDialog(Context mContext, String title) {
        if (mContext == null) {
            return;
        }
        createBuilder(mContext);
        setPositiveButtonLabel(mContext.getResources().getString(R.string._hw_alert_dialog_positive_button_label));
        createDialog();
        setTitle(title);
    }

    public AlertDialog(Context mContext, String title, String posBtnLabel) {
        if (mContext == null) {
            return;
        }
        createBuilder(mContext);
        setPositiveButtonLabel(posBtnLabel);
        createDialog();
        setTitle(title);
    }

    public void showMessage(String msg) {
        alertDialog.setMessage(msg);
        alertDialog.show();
    }
}
