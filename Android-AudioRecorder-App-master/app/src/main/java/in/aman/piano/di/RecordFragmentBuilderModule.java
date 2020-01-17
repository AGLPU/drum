package in.aman.piano.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.aman.piano.audiorecording.RecordFragment;
import in.aman.piano.di.scopes.FragmentScope;

/**
 * Created by arjun on 12/1/17.
 */

@Module
abstract class RecordFragmentBuilderModule {
  @FragmentScope
  @ContributesAndroidInjector(modules = {RecordFragmentModule.class})
  abstract RecordFragment contributeRecordFragment();
}
