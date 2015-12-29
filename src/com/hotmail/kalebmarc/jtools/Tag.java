package com.hotmail.kalebmarc.jtools;

/**
 * Used for Logger
 * A <i>Tag</i> goes in front of a log in the format <i>[tag_example]</i>, in
 * a real-life scenario, it looks something like this:
 * <i>[warning] JVM is low on memory</i> while "warning" is the tag, and
 * "JVM is low on memory" being the message.
 *
 * @author Kaleb Haslam
 * @version 1.0
 * @since 1.0
 */
public class Tag {

    private final int maxStringLength = 25;
    private final String errorMessage = "Error with tag text; ";

    private String tagText;
    private boolean upperCase = false;

    public Tag(){}
    public Tag(String text){
        setTagText(text);
    }

    /**
     * Sets the text of the tag
     * @param text The text that you want to be displayed in the Tag
     */
    public void setTagText(String text){
        if(text == null) {
            System.err.println(this.errorMessage + "text cannot be null");
            return;
        }
        if(text.length() > this.maxStringLength) {
            System.err.println(this.errorMessage + "string cannot be greater than " + this.maxStringLength + " characters");
            return;
        }
        if(text.trim().equals("")) {
            System.err.println(this.errorMessage + "string cannot be empty");
            return;
        }
        this.tagText = text;
    }

    /**
     * Gets the text of the tag
     * @return Text the tag is currently set to display
     */
    public String getTagText(){
        if(this.tagText == null){
            System.err.println(this.errorMessage + "text is not set");
            return null;
        }
        if(isUpperCaseEnabled()){
            return this.tagText.toUpperCase();
        }else{
            return this.tagText;
        }
    }

    /**
     * Sets whether the tag is to be displayed in full caps or not.
     * If the tag text is "Example", and setUpperCase is set to true, then
     * it will be displayed as "EXAMPLE" when used.
     */
    public void setUpperCase(boolean isUpperCase){
        this.upperCase = isUpperCase;
    }

    /**
     * Gets whether setUpperCase is enabled or not
     * @return true if the tag is set to be displayed in full Upper Case
     */
    public boolean isUpperCaseEnabled(){
        return this.upperCase;
    }

    /**
     * Gets the formatted tag
     * @return the formatted tag
     */
    protected String get(){
        return ("[" + getTagText() + "]");
    }

}
