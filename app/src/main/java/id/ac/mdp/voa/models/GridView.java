package id.ac.mdp.voa.models;

import android.graphics.Bitmap;

/**
 * Created by Tengku Kevin on 5/7/2017.
 */

public class GridView {
    private Bitmap image;

    public GridView(Bitmap image) {
        super();
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
