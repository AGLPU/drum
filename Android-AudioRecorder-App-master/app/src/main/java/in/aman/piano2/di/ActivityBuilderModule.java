package in.aman.piano2.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.aman.piano2.activities.MainActivity;
import in.aman.piano2.activities.PlayListActivity;
import in.aman.piano2.activities.SettingsActivity;
import in.aman.piano2.di.scopes.ActivityScope;

/**
 * Created by arjun on 12/1/17.
 */

@Module
abstract class ActivityBuilderModule {
  @ActivityScope
  @ContributesAndroidInjector(modules = {MainActivityModule.class, RecordFragmentBuilderModule.class})
  abstract MainActivity contributeMainActivity();

  @ActivityScope
  @ContributesAndroidInjector(modules = {PlayListActivityModule.class, PlayListFragmentBuilderModule.class})
  abstract PlayListActivity contributePlayListActivity();

  @ContributesAndroidInjector()
  abstract SettingsActivity contributeSettingsActivity();
}
