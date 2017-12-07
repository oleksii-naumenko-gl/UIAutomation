package helper;

import java.util.Arrays;
import java.util.List;

import static helper.DefaultUser.extensions;

public class Extension {

    public String name;

    public String description;

    public int forwardingNumberCounter;

    // todo
    public boolean isMain = true;

    // todo List
    public String forwardingNumber = "";

    public List<String> forwardingNumbers;


    public int availableNumbers = 0;

    public Extension(String extDescription, String extNumber, int forwardingNumberCounter) {
        name = extDescription;
        description = extNumber;
        this.forwardingNumberCounter = forwardingNumberCounter;
    }

    public Extension(String extDescription, String extNumber) {
        name = extDescription;
        description = extNumber;

    }
    public static String getExtensionName(String extDescription){
        String extensionName="";
        for(int index=0; index < extensions.length; index++){
            if(extDescription.equalsIgnoreCase(extensions[index].description)){
                extensionName =  extensions[index].name;
            }
        }
        return extensionName;
    }



    
    @Override
    public String toString() {
        return "Extension{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Extension extension = (Extension) o;

        if (name != null ? !name.equals(extension.name) : extension.name != null) return false;
        return description != null ? description.equals(extension.description) : extension.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}