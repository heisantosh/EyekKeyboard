package io.github.heisantosh.eyekkeyboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;

import java.util.List;

public class EyekKeyboardView extends KeyboardView {
    Context context;
    public EyekKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context ;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setTextSize(35);
        paint.setColor(Color.BLACK);
        int x = 30;
        int y = 50;

        List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {
            if (key != null) {
                switch (key.codes[0]) {
                    case 43968: // ꯀ
                        canvas.drawText("꯱", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43969: // ꯁ
                        canvas.drawText("꯲", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43970: // ꯂ
                        canvas.drawText("꯳", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43971: // ꯃ
                        canvas.drawText("꯴", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43972: // ꯄ
                        canvas.drawText("꯵", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43973: // ꯅ
                        canvas.drawText("꯶", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43974: // ꯆ
                        canvas.drawText("꯷", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43975: // ꯇ
                        canvas.drawText("꯸", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43976: // ꯈ
                        canvas.drawText("꯹", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43977: // ꯉ
                        canvas.drawText("꯰", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43983: // ꯏ
                        canvas.drawText("ꯢ", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43986: // ꯒ
                        canvas.drawText("ꯘ", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43989: // ꯕ
                        canvas.drawText("ꯚ", key.x + (key.width - x), key.y + y, paint);
                        break;
                    case 43981: // ꯗ
                        canvas.drawText("ꯙ", key.x + (key.width - x), key.y + y, paint);
                        break;
                }
            }
        }
    }

//    private void drawText(String text, Canvas canvas, Keyboard.Key key) {
//        float textWidth, textHeight;
//        Paint textPaint = new Paint();
//        Rect textBounds = new Rect();
//
//        textPaint.getTextBounds(text, 0, text.length(), textBounds);
//        textWidth = textPaint.measureText(text);
//        textHeight = textBounds.height();
//
//        canvas.drawText(text, key.width - textWidth, key.height + textHeight, textPaint);
//    }

}
