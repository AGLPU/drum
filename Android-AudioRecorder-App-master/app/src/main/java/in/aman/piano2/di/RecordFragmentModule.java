package in.aman.piano2.di;

import dagger.Module;
import dagger.Provides;
import in.aman.piano2.audiorecording.AudioRecordMVPView;
import in.aman.piano2.audiorecording.AudioRecordPresenter;
import in.aman.piano2.audiorecording.AudioRecordPresenterImpl;
import in.aman.piano2.di.scopes.FragmentScope;
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
