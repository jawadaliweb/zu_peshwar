package com.richpathanimator;

import android.animation.TypeEvaluator;
import com.richpath.pathparser.PathDataNode;
import com.richpath.pathparser.PathParserCompat;

public class PathEvaluator implements TypeEvaluator<PathDataNode[]> {
    private PathDataNode[] evaluatedNodes;

    public PathDataNode[] evaluate(float f, PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (this.evaluatedNodes == null) {
            this.evaluatedNodes = PathParserCompat.deepCopyNodes(pathDataNodeArr);
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            for (int i2 = 0; i2 < pathDataNodeArr[i].getParams().length; i2++) {
                float f2 = pathDataNodeArr[i].getParams()[i2];
                this.evaluatedNodes[i].getParams()[i2] = f2 + ((pathDataNodeArr2[i].getParams()[i2] - f2) * f);
            }
        }
        return this.evaluatedNodes;
    }
}
