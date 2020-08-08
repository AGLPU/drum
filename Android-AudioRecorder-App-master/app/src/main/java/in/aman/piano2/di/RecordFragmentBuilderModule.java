package in.aman.piano2.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.aman.piano2.audiorecording.RecordFragment;
import in.aman.piano2.di.scopes.FragmentScope;

/**
 * Created by arjun on 12/1/17.
 */

@Module
abstract class RecordFragmentBuilderModule {
  @FragmentScope
  @ContributesAndroidInjector(modules = {RecordFragmentModule.class})
  abstract RecordFragment contributeRecordFragment();
}
