package workshop;
import java.util.*; 


abstract class Notification {
    protected String message;
    protected long timestamp;

    public Notification(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public abstract void display();
}


class LikeNotification extends Notification {
    private String likedBy;

    public LikeNotification(String likedBy) {
        super(likedBy + " liked your post.");
        this.likedBy = likedBy;
    }

    @Override
    public void display() {
        System.out.println(message + " [" + timestamp + "]");
    }
}


class CommentNotification extends Notification {
    private String commentBy;
    private String commentText;

    public CommentNotification(String commentBy, String commentText) {
        super(commentBy + " commented: " + commentText);
        this.commentBy = commentBy;
        this.commentText = commentText;
    }

    @Override
    public void display() {
        System.out.println(message + " [" + timestamp + "]");
    }
}


class UserFeed {
    private LinkedList<Notification> notifications;

    public UserFeed() {
        notifications = new LinkedList<>();
    }

    public void addNotification(Notification notification) {
        notifications.addFirst(notification);  
    }

   
    public void displayFeed() {
        System.out.println(" Notification Feed:");
        for (Notification n : notifications) {
            n.display();
        }
    }
}


public class socialmedia {
    public static void main(String[] args) throws InterruptedException {
        UserFeed userFeed = new UserFeed();

        userFeed.addNotification(new LikeNotification("Alice"));
        Thread.sleep(100);  
        userFeed.addNotification(new CommentNotification("Bob", "Nice photo!"));
        Thread.sleep(100);
        userFeed.addNotification(new LikeNotification("Charlie"));

        userFeed.displayFeed();
    }
}
