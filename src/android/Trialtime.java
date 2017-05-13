package br.com.balzer.trialtime.plugin;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.util.Log;

public class Trialtime extends CordovaPlugin {

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private final long ONE_DAY = 24 * 60 * 60 * 1000;
    private static final String LOG_TAG = "TrialTime";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        Context context = this.cordova.getActivity().getApplicationContext();
        if (action.equals("verify")) {
            Integer dias = data.getInt(0);
            SharedPreferences preferences = context.getSharedPreferences("InstallDate", Context.MODE_PRIVATE);
            String installDate = preferences.getString("InstallDate", null);
            Log.e(LOG_TAG, "Install date ->"+installDate);
            System.out.println("Install date ->"+installDate);
            if (installDate == null) {
                SharedPreferences.Editor editor = preferences.edit();
                Date now = new Date();
                String dateString = formatter.format(now);
                editor.putString("InstallDate", dateString);
//                editor.putString("InstallDate", "2017-04-11");
                editor.commit();
                //callbackContext.success("TA VALENDO!");
                
            } else {
                Date before;
                try {
                    before = (Date) formatter.parse(installDate);
                    Date now = new Date();
                    long diff = now.getTime() - before.getTime();
                    long days = diff / ONE_DAY;
                    System.out.println("DIAS DE USO -> " + days);
                    if (days > dias) { // More than 30 days?
                        System.out.println("Expirado !!!");
                        Log.e(LOG_TAG, "EXPIRADO");
                        callbackContext.error("O período de utilização gratuíta expirou!\n Faça seu registro para continuar utilizando o aplicativo!");
                    }else{
                        String dia = Long.toString(days);
                        Log.d(LOG_TAG, "BAGUA"+days+"#"+dias);
                        callbackContext.success(dia);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }
}
