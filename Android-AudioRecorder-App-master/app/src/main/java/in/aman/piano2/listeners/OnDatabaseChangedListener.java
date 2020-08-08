package in.aman.piano2.listeners;

public interface OnDatabaseChangedListener {
  void onNewDatabaseEntryAdded();

  void onDatabaseEntryRenamed();
}