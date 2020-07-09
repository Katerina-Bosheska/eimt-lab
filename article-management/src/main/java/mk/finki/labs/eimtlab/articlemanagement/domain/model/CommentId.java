package mk.finki.labs.eimtlab.articlemanagement.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CommentId extends DomainObjectId {

    public CommentId(){
        super(DomainObjectId.randomId(CommentId.class).toString());
    }

    public CommentId(String id) {
        super(id);
    }
}
