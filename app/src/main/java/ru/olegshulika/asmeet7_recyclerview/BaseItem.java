package ru.olegshulika.asmeet7_recyclerview;

public interface BaseItem {
    int getType();
}

enum ItemTypes {
    UNKNOWN(0),
    ITEM1(1),
    ITEM2(2),
    ITEM3(3),
    ITEM4RV(4);

    private final int type;

    ItemTypes(int id) {
        if (id>=1 && id<=4)
            this.type=id;
        else
            this.type=0;
    }

    public int getType(){
        return this.type;
    }

    public static ItemTypes fromId(int id) {
        ItemTypes[] list = ItemTypes.values();
        if (id>=0 && id<list.length)
            return list[id];
        else return ItemTypes.UNKNOWN;
    }
}


