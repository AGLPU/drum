package in.aman.piano2.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.aman.piano2.di.scopes.FragmentScope;
import in.aman.piano2.playlist.PlayListFragment;

/**
 * Created by arjun on 12/1/17.
 */

@Module
abstract class PlayListFragmentBuilderModule {
  @FragmentScope
  @ContributesAndroidInjector(modules = {PlayListFragmentModule.class})
  abstract PlayListFragment contributePlayListFragment();
}
