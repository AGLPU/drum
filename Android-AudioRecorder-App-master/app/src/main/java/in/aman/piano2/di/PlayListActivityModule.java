package in.aman.piano2.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import in.aman.piano2.activities.PlayListActivity;
import in.aman.piano2.di.qualifiers.ActivityContext;
import in.aman.piano2.di.scopes.ActivityScope;

/**
 * Created by arjun on 12/1/17.
 */

@Module
class PlayListActivityModule {
  @Provides
  @ActivityContext
  @ActivityScope
  Context provideActivityContext(PlayListActivity activity) {
    return activity;
  }
}
