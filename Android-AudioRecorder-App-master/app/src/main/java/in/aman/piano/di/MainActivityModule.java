package in.aman.piano.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import in.aman.piano.activities.MainActivity;
import in.aman.piano.di.qualifiers.ActivityContext;
import in.aman.piano.di.scopes.ActivityScope;

@Module
public class MainActivityModule {
  @Provides
  @ActivityContext
  @ActivityScope
  Context provideActivityContext(MainActivity activity) {
    return activity;
  }
}
