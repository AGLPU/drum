package in.aman.piano2.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import in.aman.piano2.activities.MainActivity;
import in.aman.piano2.di.qualifiers.ActivityContext;
import in.aman.piano2.di.scopes.ActivityScope;

@Module
public class MainActivityModule {
  @Provides
  @ActivityContext
  @ActivityScope
  Context provideActivityContext(MainActivity activity) {
    return activity;
  }
}
