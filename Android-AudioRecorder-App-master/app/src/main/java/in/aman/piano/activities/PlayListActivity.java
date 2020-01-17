package in.aman.piano.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import in.aman.piano.R;
import in.aman.piano.mvpbase.BaseActivity;
import in.aman.piano.playlist.PlayListFragment;
import javax.inject.Inject;

public class PlayListActivity extends BaseActivity implements HasSupportFragmentInjector {

  @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

  InterstitialAd interstitialAd;
  AdRequest adRequests;
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_record_list);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(R.string.tab_title_saved_recordings);
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setDisplayShowHomeEnabled(true);
    }
    setNavBarColor();

    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
              .add(R.id.record_list_container, PlayListFragment.newInstance())
              .commit();
    }
  }

  @Override public AndroidInjector<Fragment> supportFragmentInjector() {
    return dispatchingAndroidInjector;
  }
}
