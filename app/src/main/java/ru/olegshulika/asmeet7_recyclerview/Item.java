package ru.olegshulika.asmeet7_recyclerview;

public class Item implements BaseItem {
    protected ItemTypes itemType;
    private long idItem;
    private String text;

    public Item(long id, int type, String msg) {
        this.idItem = id;
        this.itemType = ItemTypes.fromId(type);
        this.text = msg;
    }

    @Override
    public int getType() {
        return itemType.getType();
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return idItem;
    }
}
