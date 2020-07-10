package mk.finki.labs.eimtlab.authorization.domain.model;

import mk.finki.labs.eimtlab.sharedkernel.domain.base.AbstractEntity;
import mk.finki.labs.eimtlab.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="notifications")
public class Notification extends AbstractEntity<NotificationId> {

    @ManyToOne
    private User user;

    // comment or like
    private String activity;

    // which article the comment is posted on
    @Embedded
    @AttributeOverride(name="id", column = @Column(name="article_id",nullable = false))
    private ArticleId articleId;

    private String articleTitle;

    @Embedded
    @AttributeOverride(name="id", column = @Column(name="activity_by_id",nullable = false))
    private AuthorId activityById;

    private String activityByName;

    private Date timeSent;

    private boolean isRead;

    public Notification(User user, String activity, ArticleId articleId, String articleTitle, AuthorId activityById, String activityByName, Date timeSent, boolean isRead) {
        super(DomainObjectId.randomId(NotificationId.class));
        this.user = user;
        this.activity = activity;
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.activityById = activityById;
        this.activityByName = activityByName;
        this.timeSent = timeSent;
        this.isRead = isRead;
    }

    public Notification(NotificationId id, User user, String activity, ArticleId articleId, String articleTitle, AuthorId activityById, String activityByName, Date timeSent, boolean isRead) {
        super(id);
        this.user = user;
        this.activity = activity;
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.timeSent = timeSent;
        this.isRead = isRead;
    }

    public void notificationRead(){
        this.isRead = true;
    }
}
