package mk.finki.labs.eimtlab.sharedkernel.domain.info;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Image implements ValueObject {

    private String pathToImage;

    public Image() {
        pathToImage = null;
    }

    public Image(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    public void updatePath(String path){
        this.pathToImage = path;
    }
}
