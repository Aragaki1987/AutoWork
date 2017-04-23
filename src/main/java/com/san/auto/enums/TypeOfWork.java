package com.san.auto.enums;

/**
 * Created by nguye on 3/25/2017.
 */
public enum  TypeOfWork {
    CREATE("Create"),
    STUDY("Study"),
    REVIEW("Review"),
    CORRECT("Correct"),
    TEST("Test"),
    TRANSLATE("Translate"),
    SELECT_ITEM("Please select 1 item")
    ;
    private String value;

    TypeOfWork(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static TypeOfWork getTypeOfWork(String value) {
        if(value.equalsIgnoreCase(CREATE.getValue())) return CREATE;
        else if (value.equalsIgnoreCase(STUDY.getValue())) return STUDY;
        else if (value.equalsIgnoreCase(REVIEW.getValue())) return REVIEW;
        else if (value.equalsIgnoreCase(CORRECT.getValue())) return CORRECT;
        else if (value.equalsIgnoreCase(TEST.getValue())) return TEST;
        else if (value.equalsIgnoreCase(TRANSLATE.getValue())) return TRANSLATE;
        else return SELECT_ITEM;
    }
}
