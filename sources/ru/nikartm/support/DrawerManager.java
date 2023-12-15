package ru.nikartm.support;

import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import ru.nikartm.support.model.Badge;

public class DrawerManager {
    private AttributeController attrController;
    private BadgeDrawer drawer;

    public DrawerManager(View view, AttributeSet attributeSet) {
        initManager(view, attributeSet);
    }

    private void initManager(View view, AttributeSet attributeSet) {
        AttributeController attributeController = new AttributeController(view, attributeSet);
        this.attrController = attributeController;
        this.drawer = new BadgeDrawer(view, attributeController.getBadge());
    }

    public void drawBadge(Canvas canvas) {
        this.drawer.draw(canvas);
    }

    public Badge getBadge() {
        return this.attrController.getBadge();
    }
}
