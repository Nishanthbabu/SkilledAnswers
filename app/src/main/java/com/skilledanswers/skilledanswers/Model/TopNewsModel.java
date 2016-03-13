package com.skilledanswers.skilledanswers.Model;

/**
 * Created by Nishanth on 3/9/2016.
 */
public class TopNewsModel {
    private int _slno;
    private int _newsImage;
    private String _newsHeading;
    private String _newsShortDesriprition;
    private String _newsDescription;
    private String _timestamp;
    private int _seen;
    private int _case;

    public TopNewsModel() {
    }

    public TopNewsModel(int _slno, int _newsImage, String _newsHeading, String _newsShortDesriprition, String _newsDescription, String _timestamp, int _seen, int _case) {
        this._slno = _slno;
        this._newsImage = _newsImage;
        this._newsHeading = _newsHeading;
        this._newsShortDesriprition = _newsShortDesriprition;
        this._newsDescription = _newsDescription;
        this._timestamp = _timestamp;
        this._seen = _seen;
        this._case = _case;
    }

    public int get_seen() {
        return _seen;
    }

    public String get_timestamp() {
        return _timestamp;
    }

    public void set_timestamp(String _timestamp) {
        this._timestamp = _timestamp;
    }

    public int is_seen() {
        return _seen;
    }

    public void set_seen(int _seen) {
        this._seen = _seen;
    }

    public int get_slno() {
        return _slno;
    }

    public void set_slno(int _slno) {
        this._slno = _slno;
    }

    public int get_case() {
        return _case;
    }

    public void set_case(int _case) {
        this._case = _case;
    }

    public int get_newsImage() {
        return _newsImage;
    }

    public void set_newsImage(int _newsImage) {
        this._newsImage = _newsImage;
    }

    public String get_newsHeading() {
        return _newsHeading;
    }

    public void set_newsHeading(String _newsHeading) {
        this._newsHeading = _newsHeading;
    }

    public String get_newsShortDesriprition() {
        return _newsShortDesriprition;
    }

    public void set_newsShortDesriprition(String _newsShortDesriprition) {
        this._newsShortDesriprition = _newsShortDesriprition;
    }

    public String get_newsDescription() {
        return _newsDescription;
    }

    public void set_newsDescription(String _newsDescription) {
        this._newsDescription = _newsDescription;
    }
}
