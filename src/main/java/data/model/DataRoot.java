package data.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "data")
@XmlType(propOrder = {"collectionInfo", "collectionRoot"})
public class DataRoot {
    private CollectionInfo collectionInfo = new CollectionInfo();
    private CollectionRoot collectionRoot = new CollectionRoot();


    public DataRoot() {}


    @XmlElement(name = "collection")
    public CollectionRoot getCollectionRoot() {
        return collectionRoot;
    }

    @XmlElement(name = "collection_info")
    public CollectionInfo getCollectionInfo() {
        return collectionInfo;
    }



    public void setCollectionRoot(CollectionRoot collectionRoot) {
        this.collectionRoot = collectionRoot;
    }

    public void setCollectionInfo(CollectionInfo collectionInfo) {
        this.collectionInfo = collectionInfo;
    }
}
