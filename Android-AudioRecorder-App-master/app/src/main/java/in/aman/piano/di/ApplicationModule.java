package in.aman.piano.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import in.aman.piano.db.AppDataBase;
import in.aman.piano.db.RecordItemDataSource;
import in.aman.piano.di.qualifiers.ApplicationContext;
import javax.inject.Singleton;

@Module
public class ApplicationModule {

  @Provides
  @ApplicationContext
  @Singleton
  Context provideApplicationContext(Application application) {
    return application.getApplicationContext();
  }

  @Provides
  @Singleton
  RecordItemDataSource provideRecordItemDataSource(@ApplicationContext Context context) {
    return AppDataBase.getInstance(context).getRecordItemDataSource();
  }
}
