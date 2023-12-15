package io.github.luizgrp.sectionedrecyclerviewadapter;

interface SectionPositionIdentifier {
    int getFooterPosition();

    int getHeaderPosition();

    int getPositionInAdapter(int i);

    int getPositionInSection(int i);

    int getSectionPosition();
}
