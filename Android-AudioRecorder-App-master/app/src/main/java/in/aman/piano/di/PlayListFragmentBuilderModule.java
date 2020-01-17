package in.aman.piano.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.aman.piano.di.scopes.FragmentScope;
import in.aman.piano.playlist.PlayListFragment;

/**
 * Created by arjun on 12/1/17.
 */

@Module
abstract class PlayListFragmentBuilderModule {
  @FragmentScope
  @ContributesAndroidInjector(modules = {PlayListFragmentModule.class})
  abstract PlayListFragment contributePlayListFragment();
}
