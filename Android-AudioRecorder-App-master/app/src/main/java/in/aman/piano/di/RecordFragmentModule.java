package in.aman.piano.di;

import dagger.Module;
import dagger.Provides;
import in.aman.piano.audiorecording.AudioRecordMVPView;
import in.aman.piano.audiorecording.AudioRecordPresenter;
import in.aman.piano.audiorecording.AudioRecordPresenterImpl;
import in.aman.piano.di.scopes.FragmentScope;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by arjun on 12/1/17.
 */

@Module
class RecordFragmentModule {

  @Provides
  @FragmentScope
  AudioRecordPresenter<AudioRecordMVPView> provideAudioRecordPresenter(
      AudioRecordPresenterImpl<AudioRecordMVPView> audioRecordPresenter) {
    return audioRecordPresenter;
  }

  @Provides
  @FragmentScope
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }
}
