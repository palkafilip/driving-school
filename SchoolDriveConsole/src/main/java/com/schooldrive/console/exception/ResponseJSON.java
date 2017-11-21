package com.schooldrive.console.exception;

/**
 * Created by Filip on 04.11.2017.
 */
public class ResponseJSON {
    private String key;
    private String value;

    public ResponseJSON(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String returnJSON() {
        return "{ \"" + this.key + "\": \"" + value + "\" }";
    }
}
