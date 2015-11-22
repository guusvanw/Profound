package com.poliyguus.profound.rest.model.theysaidso;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class VerseContents {

    private String verse;
    private String number;
    private String chapter;
    private String book;
    private String testament;
    private String bookid;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The verse
     */
    public String getVerse() {
        return verse;
    }

    /**
     *
     * @param verse
     * The verse
     */
    public void setVerse(String verse) {
        this.verse = verse;
    }

    /**
     *
     * @return
     * The number
     */
    public String getNumber() {
        return number;
    }

    /**
     *
     * @param number
     * The number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     *
     * @return
     * The chapter
     */
    public String getChapter() {
        return chapter;
    }

    /**
     *
     * @param chapter
     * The chapter
     */
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    /**
     *
     * @return
     * The book
     */
    public String getBook() {
        return book;
    }

    /**
     *
     * @param book
     * The book
     */
    public void setBook(String book) {
        this.book = book;
    }

    /**
     *
     * @return
     * The testament
     */
    public String getTestament() {
        return testament;
    }

    /**
     *
     * @param testament
     * The testament
     */
    public void setTestament(String testament) {
        this.testament = testament;
    }

    /**
     *
     * @return
     * The bookid
     */
    public String getBookid() {
        return bookid;
    }

    /**
     *
     * @param bookid
     * The bookid
     */
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
