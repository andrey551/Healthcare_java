package Raw;

import java.util.List;

public class ListId {
    List<Long> listId;

    public ListId(List<Long> ListId) {
        this.listId = ListId;
    }

    public List<Long> getListId() {
        return listId;
    }

    public void setListId(List<Long> listId) {
        this.listId = listId;
    }

    public void addId(Long id) {
        this.listId.add(id);
    }

    @Override
    public String toString() {
        String ret = "(";
        for(Long i : listId) {
            ret +=  i.toString() + ", ";
        }

        ret += ")";

        return ret;
    }
}
