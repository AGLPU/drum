package in.aman.piano.di;

import dagger.Module;
import dagger.Provides;
import in.aman.piano.di.scopes.FragmentScope;
import in.aman.piano.playlist.PlayListMVPView;
import in.aman.piano.playlist.PlayListPresenter;
import in.aman.piano.playlist.PlayListPresenterImpl;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by arjun on 12/1/17.
 */

@Module
class PlayListFragmentModule {

  @Provides
  @FragmentScope
  PlayListPresenter<PlayListMVPView> providePlayListPresenter(PlayListPresenterImpl<PlayListMVPView> playListPresenter) {
    return playListPresenter;
  }

  @Provides
  @FragmentScope
  CompositeDisposable provideCompositeDisposable() {
    return new CompositeDisposable();
  }
}
