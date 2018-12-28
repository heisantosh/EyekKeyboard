package io.github.heisantosh.eyekkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;

import static android.content.ContentValues.TAG;

public class EyekInputMethodServivce extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private EyekKeyboardView mKeyboardView;
    private Keyboard mKokSamLaiKeyboard;
    private Keyboard mAmaAniAhumKeyboard;
    private Keyboard mExtensionsKeyboard;

    @Override
    public void onInitializeInterface() {

        mKokSamLaiKeyboard = new Keyboard(this, R.xml.koksamlai);
        mAmaAniAhumKeyboard = new Keyboard(this, R.xml.amaaniahum);
        mExtensionsKeyboard = new Keyboard(this, R.xml.extensions);
    }

    @Override
    public View onCreateInputView() {
        mKeyboardView = (EyekKeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        mKeyboardView.setKeyboard(mKokSamLaiKeyboard);
        mKeyboardView.setOnKeyboardActionListener(this);
        mKeyboardView.setPreviewEnabled(false);
        return mKeyboardView;
    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {

        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return;

        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                CharSequence selectedText = ic.getSelectedText(0);
                if (TextUtils.isEmpty(selectedText)) {
                    // no selection, so delete previous character
                    ic.deleteSurroundingText(1, 0);
                } else {
                    // delete the selection
                    ic.commitText("", 1);
                }
                ic.deleteSurroundingText(1, 0);
                break;
            case -4:
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER));
                break;
            case -10002:
                mKeyboardView.setKeyboard(mAmaAniAhumKeyboard);
                break;
            case -10001:
                mKeyboardView.setKeyboard(mKokSamLaiKeyboard);
                break;
            case -10003:
                mKeyboardView.setKeyboard(mExtensionsKeyboard);
                break;
            default:
                char code = (char) primaryCode;
                ic.commitText(String.valueOf(code), 1);
        }
    }

    @Override
    public void onPress(int primaryCode) {
        // Hide key preview for DEL, SPACE, ENTER and layout switching keys.
        if (primaryCode > 0 && primaryCode != 32) {
            mKeyboardView.setPreviewEnabled(true);
        }
        else {
            mKeyboardView.setPreviewEnabled(false);
        }
    }

    @Override
    public void onRelease(int primaryCode) {
        mKeyboardView.setPreviewEnabled(false);
    }

    @Override
    public void onText(CharSequence text) { }

    @Override
    public void swipeLeft() { }

    @Override
    public void swipeRight() { }

    @Override
    public void swipeDown() { }

    @Override
    public void swipeUp() { }
}
