package com.skilledanswers.skilledanswers.Model;

/**
 * Created by Nishanth on 3/13/2016.
 */
public class AroundTheWebModel {
    private int _Slno;
    private int _image;
    private String _heading;

    public AroundTheWebModel(int _Slno, int _image, String _heading) {
        this._Slno = _Slno;
        this._image = _image;
        this._heading = _heading;
    }

    public int get_Slno() {
        return _Slno;
    }

    public void set_Slno(int _Slno) {
        this._Slno = _Slno;
    }

    public int get_image() {
        return _image;
    }

    public void set_image(int _image) {
        this._image = _image;
    }

    public String get_heading() {
        return _heading;
    }

    public void set_heading(String _heading) {
        this._heading = _heading;
    }
}
