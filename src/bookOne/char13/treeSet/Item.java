package bookOne.char13.treeSet;

import java.util.Objects;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 11:00.
 */
public class Item implements Comparable<Item>{
    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber){
        description = aDescription;
        partNumber = aPartNumber;
    }

    public String getDescription() {
        return description;
    }

    public String toString(){
        return "[description=" + description + ",partNumber=" + partNumber + "]";
    }

    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, ((Item) otherObject).description) && partNumber == other.partNumber;
    }

    public int hashCode(){
        return Objects.hash(description,partNumber);
    }

    public int compareTo(Item other){
        return Integer.compare(partNumber,other.partNumber);
    }
}
