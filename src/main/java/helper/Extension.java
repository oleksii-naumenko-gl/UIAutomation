package helper;

import java.util.List;

public class Extension {

    public String number;

    public String description;

    public int forwardingNumberCounter;

    // todo
    public boolean isMain = true;

    // todo List
    public String forwardingNumber = "";

    public List<String> forwardingNumbers;



    public int availableNumbers = 0;

    public Extension(String extNumber, String extDescription, int extCount){
        number = extNumber;
        description = extDescription;
        forwardingNumberCounter = extCount;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "number='" + number + '\'' +
                ", description='" + description + '\'' +
                ", forwardingNumbercounter=" + forwardingNumberCounter +
                '}';
    }
}
