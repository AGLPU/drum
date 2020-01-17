package in.aman.piano.listeners;

public interface OnDatabaseChangedListener {
  void onNewDatabaseEntryAdded();

  void onDatabaseEntryRenamed();
}