package in.aman.piano2.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import in.aman.piano2.db.AppDataBase;
import in.aman.piano2.db.RecordItemDataSource;
import in.aman.piano2.di.qualifiers.ApplicationContext;
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
