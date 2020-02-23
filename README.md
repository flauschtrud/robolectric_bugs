# Robolectric Bugs

This project reproduces the following problems that I encountered when using Robolectric for Android unit tests:
- `pressKey(KeyEvent.KEYCODE_ENTER)` does not seem to have any effect
- `closeSoftKeyboard()` does not seem to have any effect

The project includes the same tests both as an Robolectric tests and as a real Android instrumentation tests. The instrumentation tests pass and the Robolectric tests fail.
