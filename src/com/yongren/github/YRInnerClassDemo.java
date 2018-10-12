package com.yongren.github;

public class YRInnerClassDemo {
    public static void main(String[] args) {

        // 概念及部分特性，最关键的是无外乎 -- 外部类中可以访问内部类的所有
        test1();

        // 内部类肯定不是为了简简单单的为了权限分离，否则的化 通过private等关键字完全就足够，
        // 那内部类的必要如何体现呢？


    }

    static void test1() {
        // 内部类借由外部类方法的调用完成初始化
        Parcel pBoom = new Parcel();
        pBoom.ship("Iraq 💣");

        // 直接初始化: 格式 OuterClassName.InnerClassName
        Parcel p2 = new Parcel();
        Parcel.Content boom2 = p2.boom();
        Parcel.Destination target2 = p2.to("UK");

        System.out.println("--- test1 done ---");
    }
}

class Parcel {

    private String name = "Outter here";
    class Content {
        private int type = 11;
        public int contentType() {
            System.out.println("访问到了Outter的属性" + name);
            return type;
        }
    }

    class Destination {
        private String address;
        Destination(String toWhere) {
            address = toWhere;
        }

        String sacnAddress() {
            return address;
        }
    }

    // 更典型地：利用方法，通过 new 的方式，返回内部类实例
    public Destination to(String s) {
        return new Destination(s);
    }
    public Content boom() {
        return new Content();
    }

    public void ship(String dest) {
        Content boom = new Content();
        Destination target = new Destination(dest);
        // Outer中，可以访问到 内部类 Content & Destination 的所有，哪怕是private的，如这里的 type ⬅️⬅️⬅️⬅️⬅️
        System.out.println("Outer中，可以访问到 内部类的所有，哪怕是private的，如这里的 type:" + boom.type + " ~ target to " + target.sacnAddress());
    }

//    public String info() {
//
//    }

}
