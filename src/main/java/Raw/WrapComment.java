package Raw;

import Model.Comment;

public class WrapComment {
    private coordinate coor;
    private Comment comment;
    public WrapComment(coordinate coor,
                       Comment comment) {
        this.coor = coor;
        this.comment = comment;
    }

    public WrapComment(){}

    public Comment getComment() {
        return comment;
    }

    public coordinate getCoor() {
        return coor;
    }
}
