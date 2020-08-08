package in.aman.piano2.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.facebook.ads.AudienceNetworkAds;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import in.aman.piano2.R;
import in.aman.piano2.mvpbase.BaseActivity;
import in.aman.piano2.playlist.PlayListFragment;

public class PlayListActivity extends BaseActivity implements HasSupportFragmentInjector {

  @Inject DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


  Adsbuilder adsbuilder;

  private void setupFBAds() {
    // Initialize the Audience Network SDK
    AudienceNetworkAds.initialize(this);


    // Find the Ad Container
    adsbuilder = new Adsbuilder(this, null);
    adsbuilder.buildAdsListner();
    adsbuilder.loadAds();
  }
  @Override
  protected void onDestroy() {
    adsbuilder.destroyInterstialAds();
    adsbuilder.destroyBannerAds();
    super.onDestroy();
  }
  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_record_list);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setupFBAds();
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
