package in.aman.piano.settings;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.orhanobut.hawk.Hawk;
import in.aman.piano.R;
import in.aman.piano.libs.SettingBasic;
import in.aman.piano.theme.ColorsSetting;
import in.aman.piano.theme.ThemeHelper;
import in.aman.piano.theme.ThemedActivity;
import in.aman.piano.theme.ThemedFragment;

public class SettingsFragment extends ThemedFragment {

  private View rootView;
  private SettingBasic themeSetting;
  private ThemedActivity parent;
  private SettingBasic rateApp;
InterstitialAd interstitialAd;
AdRequest adRequests;
  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    rootView = inflater.inflate(R.layout.fragment_settings, container, false);
    parent = (ThemedActivity) getActivity();
    initViews();
    bindEvents();
    MobileAds.initialize(getActivity(),
            "ca-app-pub-3136435737091654~2057566095");
    interstitialAd = new InterstitialAd(getActivity());

    interstitialAd.setAdUnitId("ca-app-pub-3136435737091654/1059979507");

    // Create ad request.
    adRequests = new AdRequest.Builder().build();
    return rootView;
  }
  public void startAds(){
    interstitialAd.loadAd(adRequests);

    interstitialAd.show();

  }

  private void bindEvents() {
    themeSetting.setOnClickListener(v -> {
      final int originalColor = getPrimaryColor();
      startAds();
      new ColorsSetting((ThemedActivity) getActivity()).chooseColor(R.string.primary_color,
          new ColorsSetting.ColorChooser() {
            @Override
            public void onColorSelected(ColorsSetting.SelectedColor color) {
              Hawk.put(getString(R.string.preference_primary_color), color.colorPrimary);
              Hawk.put(getString(R.string.preference_accent_color), color.colorPrimary);
              Hawk.put(getString(R.string.preference_layer_colors), color.shades);
              parent.updateTheme();
              parent.updateUiElements();
            }

            @Override
            public void onDialogDismiss() {
              Hawk.put(getString(R.string.preference_primary_color), originalColor);
              Hawk.put(getString(R.string.preference_accent_color), originalColor);
              parent.updateTheme();
              parent.updateUiElements();
            }

            @Override
            public void onColorChanged(int color) {
              Hawk.put(getString(R.string.preference_primary_color), color);
              Hawk.put(getString(R.string.preference_accent_color), color);
              parent.updateTheme();
              parent.updateUiElements();
            }
          }, getPrimaryColor());
    });
    rateApp.setOnClickListener(v -> {
      Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
      Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
      goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
          Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
          Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
      try {
        startActivity(goToMarket);
      } catch (ActivityNotFoundException e) {
        startActivity(new Intent(Intent.ACTION_VIEW,
            Uri.parse(
                "http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
      }
    });
  }

  private void initViews() {
    themeSetting = rootView.findViewById(R.id.theme_settings);
    rateApp = rootView.findViewById(R.id.rate_app);
  }

  //Preference aboutPref = findPreference(getString(R.string.pref_about_key));
  //  aboutPref.setSummary(getString(R.string.pref_about_desc, BuildConfig.VERSION_NAME));
  //  aboutPref.setOnPreferenceClickListener(preference -> {
  //  LicensesFragment licensesFragment = new LicensesFragment();
  //  licensesFragment.show(
  //      ((SettingsActivity) getActivity()).getSupportFragmentManager(),
  //      "dialog_licenses");
  //  return true;
  //});

  @Override public void refreshTheme(ThemeHelper themeHelper) {

  }
}
