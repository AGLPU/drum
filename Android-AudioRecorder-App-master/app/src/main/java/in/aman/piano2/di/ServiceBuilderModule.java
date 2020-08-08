package in.aman.piano2.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import in.aman.piano2.recordingservice.AudioRecordService;

/**
 * Created by arjun on 12/1/17.
 */

@Module
abstract public class ServiceBuilderModule {
  @ContributesAndroidInjector(modules = {ServiceModule.class})
  abstract AudioRecordService contributeAudioRecordService();
}
