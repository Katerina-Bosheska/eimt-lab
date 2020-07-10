package mk.finki.labs.eimtlab.authorization.application;

import mk.finki.labs.eimtlab.authorization.domain.model.*;
import mk.finki.labs.eimtlab.authorization.domain.repository.NotificationRepository;
import mk.finki.labs.eimtlab.authorization.domain.repository.UserRepository;
import mk.finki.labs.eimtlab.authorization.integration.CommentPostedEvent;
import mk.finki.labs.eimtlab.authorization.integration.TransactionAddedEvent;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Transactional
public class AuthorizationService {

    private final NotificationRepository notificationRepository;

    private final UserRepository userRepository;

    public AuthorizationService(NotificationRepository notificationRepository,
                                UserRepository userRepository){
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void onCommentPosted(CommentPostedEvent commentPostedEvent){
        AuthorId authorId = commentPostedEvent.getArticleAuthor();
        UserId userId = new UserId(authorId.getId());
        User user = userRepository.findById(userId).get();
        Notification notification = new Notification(
            user, commentPostedEvent.getActivity(), commentPostedEvent.getArticleId(),
                commentPostedEvent.getArticleTitle(), commentPostedEvent.getPostedById(),
                commentPostedEvent.getPostedByName(), commentPostedEvent.getPostedOn(), false
        );
        notificationRepository.save(notification);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onTransactionAdded(TransactionAddedEvent event) {
        User user = userRepository.findById(event.getUserId()).orElseThrow(RuntimeException::new);
        user.setStatus(Status.Valid);
        userRepository.save(user);
    }


}
