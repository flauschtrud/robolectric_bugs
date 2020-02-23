# Robolectric Bugs

This project reproduces the following problems that I encountered when using Robolectric with Espresso for Android unit tests:
- `pressKey(KeyEvent.KEYCODE_ENTER)` does not seem to have any effect
- `closeSoftKeyboard()` does not seem to have any effect

The project includes the same tests both as Robolectric tests and as a real Android instrumentation tests. The instrumentation tests pass and the Robolectric tests fail.

See https://stackoverflow.com/questions/60343443/robolectric-espresso-how-to-perform-typing-a-newline-in-edittext and
https://github.com/robolectric/robolectric/issues/5477.
