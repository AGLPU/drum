package in.aman.piano2.di;

import dagger.Module;
import dagger.Provides;
import in.aman.piano2.di.scopes.FragmentScope;
import in.aman.piano2.playlist.PlayListMVPView;
import in.aman.piano2.playlist.PlayListPresenter;
import in.aman.piano2.playlist.PlayListPresenterImpl;
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
