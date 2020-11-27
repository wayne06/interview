package com.wnzhong.ajavasebasic.aoop.bdeepcopy;

/**
 * @author wayne
 */
public class Test {

    static class Body implements Cloneable {
        private Head head;
        public Body(Head head) {
            this.head = head;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Body newBody = (Body) super.clone();
            newBody.head = (Head) head.clone();
            return newBody;
        }
    }

    static class Head implements Cloneable {
        public Face face;
        public Head(Face face) {
            this.face = face;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            Head newHead = (Head) super.clone();
            newHead.face = (Face) face.clone();
            return newHead;
        }
    }

    static class Face implements Cloneable {
        public int size;
        public Face(int size) {
            this.size = size;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Body body0 = new Body(new Head(new Face(1)));
        Body body1 = (Body) body0.clone();
        System.out.println(body0 == body1);
        System.out.println(body0.head == body1.head);
        System.out.println(body0.head.face == body1.head.face);
    }
}
